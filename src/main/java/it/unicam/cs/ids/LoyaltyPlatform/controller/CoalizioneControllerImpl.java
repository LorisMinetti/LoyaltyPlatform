package it.unicam.cs.ids.LoyaltyPlatform.controller;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.CoalizioneController;
import it.unicam.cs.ids.LoyaltyPlatform.model.CoalizioneModel;
import it.unicam.cs.ids.LoyaltyPlatform.repository.CoalizioneRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class CoalizioneControllerImpl implements CoalizioneController {

    @Autowired
    CoalizioneRepository coalizioneRepository;

    @Override
    public CoalizioneModel createCoalizione(CoalizioneModel coalizioneModel) {
        if (coalizioneModel.getId() != null) {
            log.error("Tentativo di creazione di una coalizione con id già presente");
        }
        try {
            return coalizioneRepository.save(coalizioneModel);
        } catch (Exception e) {
            log.error("Errore durante la creazione di una coalizione");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public CoalizioneModel updateCoalizione(CoalizioneModel coalizioneModel) {
        if (coalizioneModel.getId() == null) {
            log.error("Tentativo di aggiornamento di una coalizione senza id");
        }
        try {
            return coalizioneRepository.save(coalizioneModel);
        } catch (Exception e) {
            log.error("Errore durante l'aggiornamento di una coalizione");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deleteCoalizione(CoalizioneModel coalizioneModel) {
        if (!coalizioneRepository.existsByIdAndFlagEliminaIsFalse(coalizioneModel.getId())) {
            log.error("Tentativo di eliminazione di una coalizione non presente");
            return false;
        }
        try {
            coalizioneRepository.setFlagDelete(coalizioneModel.getId());
            return true;
        } catch (Exception e) {
            log.error("Errore durante l'eliminazione di una coalizione");
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public CoalizioneModel getById(UUID id) {
        CoalizioneModel ret = null;
        try {
            ret = coalizioneRepository.getByIdAndFlagEliminaIsFalse(id);
        } catch (Exception e) {
            log.error("Errore nel recupero della coalizione per id");
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public List<CoalizioneModel> findAll() {
        List<CoalizioneModel> ret = new ArrayList<>();
        try {
            ret = this.coalizioneRepository.findAll();
        } catch (Exception e) {
            log.error("Errore nel recupero della lista delle coalizioni");
            e.printStackTrace();
        }
        return ret;
    }
}
