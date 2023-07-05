package it.unicam.cs.ids.LoyaltyPlatform.controller;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.GestorePiattaformaController;
import it.unicam.cs.ids.LoyaltyPlatform.model.AttivitaCommercialeModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.ClienteModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.GestorePiattaformaModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaFedeltaModel;
import it.unicam.cs.ids.LoyaltyPlatform.repository.GestorePiattaformaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class GestorePiattaformaControllerImpl implements GestorePiattaformaController {

    @Autowired
    private GestorePiattaformaRepository gestorePiattaformaRepository;

    @Override
    public GestorePiattaformaModel createGestorePiattaforma(GestorePiattaformaModel gestorePiattaforma) {
        if(gestorePiattaforma.getId() != null) {
            log.error("Tentativo di creazione di un gestorePiattaforma con id già presente");
        }
        try{
            return gestorePiattaformaRepository.save(gestorePiattaforma);
        } catch (Exception e) {
            log.error("Errore durante la creazione di un gestorePiattaforma");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public GestorePiattaformaModel updateGestorePiattaforma(GestorePiattaformaModel gestorePiattaforma) {
        if(gestorePiattaforma.getId() == null) {
            log.error("Tentativo di aggiornamento di un gestorePiattaforma senza id");
        }
        try{
            return gestorePiattaformaRepository.save(gestorePiattaforma);
        } catch (Exception e) {
            log.error("Errore durante l'aggiornamento di un gestorePiattaforma");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deleteGestorePiattaforma(GestorePiattaformaModel gestorePiattaforma) {
        if(!gestorePiattaformaRepository.existsByIdAndFlagEliminaIsFalse(gestorePiattaforma.getId())){
            log.error("Tentativo di eliminazione di un cliente non presente");
            return false;
        }
        try{
            gestorePiattaformaRepository.setFlagDelete(gestorePiattaforma.getId());
            return true;
        } catch (Exception e) {
            log.error("Errore durante l'eliminazione di un cliente");
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public GestorePiattaformaModel getById(UUID id) {
        GestorePiattaformaModel ret = null;
        try {
            ret = gestorePiattaformaRepository.getByIdAndFlagEliminaIsFalse(id);
        } catch (Exception e) {
            log.error("Errore nel recupero del gestorePiattaforma per id");
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public List<GestorePiattaformaModel> findAll() {
        List<GestorePiattaformaModel> ret = new ArrayList<>();
        try{
            ret = this.gestorePiattaformaRepository.findAll();
        } catch (Exception e){
            log.error("Errore nel recupero della lista dei clienti");
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public ProgrammaFedeltaModel aggiungiProgrammaFedelta() {
        return null;
    }

    @Override
    public boolean rimuoviProgrammaFedelta() {
        return false;
    }

    @Override
    public List<ProgrammaFedeltaModel> getAllProgrammiFedelta() {
        return null;
    }

    @Override
    public void selezionaProgrammaFedelta(ProgrammaFedeltaModel programmaFedeltaModel) {}

}
