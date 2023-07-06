package it.unicam.cs.ids.LoyaltyPlatform;

import it.unicam.cs.ids.LoyaltyPlatform.model.AdesioneProgrammaFedeltaModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.NotificaModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaFedeltaModel;
import it.unicam.cs.ids.LoyaltyPlatform.repository.AdesioneProgrammaFedeltaRepository;
import it.unicam.cs.ids.LoyaltyPlatform.repository.NotificaRepository;
import it.unicam.cs.ids.LoyaltyPlatform.repository.ProgrammaFedeltaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class RecordScadutiService {

    @Autowired
    private AdesioneProgrammaFedeltaRepository adesioneProgrammaFedeltaRepository;
    @Autowired
    private NotificaRepository notificaRepository;
    @Autowired
    private ProgrammaFedeltaRepository programmaFedeltaRepository;

    @Scheduled(fixedRate =  10 * 60 * 1000) // Esegui ogni 10 minuti
    public void eliminaAdesioniScadute() {
        LocalDateTime now = LocalDateTime.now();
        List<AdesioneProgrammaFedeltaModel> adesioniScadute = adesioneProgrammaFedeltaRepository.findAllByRinnovoAutomaticoIsFalseAndDataScadenzaIsBefore(now);
        adesioneProgrammaFedeltaRepository.deleteAll(adesioniScadute);
    }

    @Scheduled(fixedRate = 24 * 60 * 60 * 1000)
    public void eliminaVecchieNotifiche(){
        LocalDateTime now = LocalDateTime.now();
        List<NotificaModel> notificheDeletable = notificaRepository.findAllByDestroyTimeBefore(now);
        notificaRepository.deleteAll(notificheDeletable);
    }

    @Scheduled(fixedRate = 2 * 60 * 1000) // Esegui ogni 2 minuti
    public void eliminaProgrammaFedelta(){
        LocalDateTime now = LocalDateTime.now();
        List<ProgrammaFedeltaModel> programmiFedeltaScaduti = programmaFedeltaRepository.findAllBySelezionabileIsFalseAndFlagEliminaIsFalse();

        programmiFedeltaScaduti.forEach( x -> {
            Optional<LocalDateTime> ultimaAdesione = Optional.empty();

            List<AdesioneProgrammaFedeltaModel> adesioniProgramma = adesioneProgrammaFedeltaRepository.findAllByIdProgrammaFedeltaAndRinnovoAutomaticoIsFalseAndFlagEliminaIsFalse(x.getId());
            for(AdesioneProgrammaFedeltaModel y : adesioniProgramma) {

                if (ultimaAdesione.isPresent()) {
                    if (y.getDataScadenza().isAfter(ultimaAdesione.get())) {
                        ultimaAdesione = Optional.ofNullable(y.getDataScadenza());
                    }
                }
            }
            if(ultimaAdesione.isPresent()){
                if(ultimaAdesione.get().isBefore(now)){
                    programmaFedeltaRepository.setFlagDelete(x.getId());
                }
            }
        });
    }
}
