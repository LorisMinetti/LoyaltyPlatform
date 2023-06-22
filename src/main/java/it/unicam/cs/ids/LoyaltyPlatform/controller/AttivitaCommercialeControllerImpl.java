package it.unicam.cs.ids.LoyaltyPlatform.controller;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.AttivitaCommercialeController;
import it.unicam.cs.ids.LoyaltyPlatform.model.AttivitaCommercialeModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaFedeltaModel;
import it.unicam.cs.ids.LoyaltyPlatform.repository.inbound.AttivitaCommercialeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Slf4j
@Service
public class AttivitaCommercialeControllerImpl implements AttivitaCommercialeController {

    @Autowired
    private AttivitaCommercialeRepository attivitaCommercialeRepository;


    @Override
    public ProgrammaFedeltaModel aderisciProgrammaFedelta() {
        return null;
    }

    @Override
    public Set<ProgrammaFedeltaModel> getAvailablePrograms(AttivitaCommercialeModel attivitaCommercialeModel) {
        return null;
    }

    @Override
    public void selezionaProgrammaFedelta(AttivitaCommercialeModel attivitaCommercialeModel, ProgrammaFedeltaModel programmaFedeltaModel) {
    }

    @Override
    public AttivitaCommercialeModel createAttivitaCommerciale(AttivitaCommercialeModel attivitaCommerciale) {
        if(attivitaCommerciale.getId() != null) {
            log.error("Tentativo di creazione di un attivitaCommerciale con id già presente");
        }
        try{
            return attivitaCommercialeRepository.save(attivitaCommerciale);
        } catch (Exception e) {
            log.error("Errore durante la creazione di un attivitaCommerciale");
            return null;
        }
    }

    @Override
    public AttivitaCommercialeModel updateAttivitaCommerciale(AttivitaCommercialeModel attivitaCommerciale) {
        if(attivitaCommerciale.getId() == null) {
            log.error("Tentativo di aggiornamento di un attivitaCommerciale senza id");
        }
        try{
            return attivitaCommercialeRepository.save(attivitaCommerciale);
        } catch (Exception e) {
            log.error("Errore durante l'aggiornamento di un attivitaCommerciale");
            return null;
        }
    }

    @Override
    public boolean deleteAttivitaCommerciale(AttivitaCommercialeModel attivitaCommerciale) {
        if(!attivitaCommercialeRepository.existsByIdAndFlagEliminaIsFalse(attivitaCommerciale.getId())){
            log.error("Tentativo di eliminazione di un attivitaCommerciale non presente");
            return false;
        }
        try{
            attivitaCommercialeRepository.setFlagDelete(attivitaCommerciale.getId());
            return true;
        } catch (Exception e) {
            log.error("Errore durante l'eliminazione di un attivitaCommerciale");
            e.printStackTrace();
            return false;
        }    }

    @Override
    public AttivitaCommercialeModel getById(UUID id) {
        AttivitaCommercialeModel ret = null;
        try{
            ret = attivitaCommercialeRepository.getByIdAndFlagEliminaIsFalse(id);
        } catch (Exception e){
            e.printStackTrace();
            log.error("Errore nel recupero del attivitaCommerciale per Id");
        }
        return ret;
    }

    @Override
    public List<AttivitaCommercialeModel> findAll() {
        List<AttivitaCommercialeModel> ret = new ArrayList<>();
        try{
            ret = this.attivitaCommercialeRepository.findAll();
        } catch (Exception e){
            e.printStackTrace();
            log.error("Errore nel recupero della lista dei clienti");
        }
        return ret;    }

}
