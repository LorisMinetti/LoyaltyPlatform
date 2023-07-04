package it.unicam.cs.ids.LoyaltyPlatform;

import it.unicam.cs.ids.LoyaltyPlatform.model.AdesioneProgrammaFedeltaModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.NotificaModel;
import it.unicam.cs.ids.LoyaltyPlatform.repository.AdesioneProgrammaFedeltaRepository;
import it.unicam.cs.ids.LoyaltyPlatform.repository.NotificaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class RecordScadutiService {

    @Autowired
    private AdesioneProgrammaFedeltaRepository adesioneProgrammaFedeltaRepository;
    @Autowired
    private NotificaRepository notificaRepository;

    @Scheduled(fixedRate =  10 * 60 * 1000) // Esegui ogni 10 minuti
    public void eliminaRecordScaduti() {
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
}
