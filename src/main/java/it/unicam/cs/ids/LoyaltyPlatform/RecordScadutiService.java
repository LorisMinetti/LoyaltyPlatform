package it.unicam.cs.ids.LoyaltyPlatform;

import it.unicam.cs.ids.LoyaltyPlatform.model.AdesioneProgrammaFedeltaModel;
import it.unicam.cs.ids.LoyaltyPlatform.repository.AdesioneProgrammaFedeltaRepository;
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

    public void eliminaRecordScaduti() {
        LocalDateTime now = LocalDateTime.now();
        List<AdesioneProgrammaFedeltaModel> adesioniScadute = adesioneProgrammaFedeltaRepository.findAllByDataScadenzaBefore(now);
        adesioneProgrammaFedeltaRepository.deleteAll(adesioniScadute);
    }

    @Scheduled(cron = "0 0 0 * * *") // Esegui ogni giorno a mezzanotte
    public void eseguiEliminazioneRecordScaduti() {
        eliminaRecordScaduti();
    }
}
