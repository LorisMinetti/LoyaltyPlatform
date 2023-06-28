package it.unicam.cs.ids.LoyaltyPlatform.controller;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.AdesioneProgrammaFedeltaController;
import it.unicam.cs.ids.LoyaltyPlatform.model.AdesioneProgrammaFedeltaModel;
import it.unicam.cs.ids.LoyaltyPlatform.repository.AdesioneProgrammaFedeltaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class AdesioneProgrammaFedeltaControllerImpl implements AdesioneProgrammaFedeltaController {

    @Autowired
    private AdesioneProgrammaFedeltaRepository adesioneProgrammaFedeltaRepository;


    @Override
    public AdesioneProgrammaFedeltaModel createAdesioneProgrammaFedelta(AdesioneProgrammaFedeltaModel adesioneProgrammaFedelta) {
        if(adesioneProgrammaFedelta.getId() != null) {
            log.error("Tentativo di creazione di un adesioneProgrammaFedelta con id già presente");
        }
        try{
            adesioneProgrammaFedelta.setDataAdesione(LocalDateTime.now());

            return adesioneProgrammaFedeltaRepository.save(adesioneProgrammaFedelta);
        } catch (Exception e) {
            log.error("Errore durante la creazione di un adesioneProgrammaFedelta");
            return null;
        }    }

    @Override
    public AdesioneProgrammaFedeltaModel updateAdesioneProgrammaFedelta(AdesioneProgrammaFedeltaModel adesioneProgrammaFedelta) {
        if(adesioneProgrammaFedelta.getId() == null) {
            log.error("Tentativo di aggiornamento di un adesioneProgrammaFedelta senza id");
        }
        try{
            return adesioneProgrammaFedeltaRepository.save(adesioneProgrammaFedelta);
        } catch (Exception e) {
            log.error("Errore durante l'aggiornamento di un adesioneProgrammaFedelta");
            return null;
        }    }

    @Override
    public boolean deleteAdesioneProgrammaFedelta(AdesioneProgrammaFedeltaModel adesioneProgrammaFedelta) {
        if(!adesioneProgrammaFedeltaRepository.existsByIdAndFlagEliminaIsFalse(adesioneProgrammaFedelta.getId())){
            log.error("Tentativo di eliminazione di un adesioneProgrammaFedelta non presente");
            return false;
        }
        try{
            adesioneProgrammaFedeltaRepository.setFlagDelete(adesioneProgrammaFedelta.getId());
            return true;
        } catch (Exception e) {
            log.error("Errore durante l'eliminazione di un adesioneProgrammaFedelta");
            e.printStackTrace();
            return false;
        }    }

    @Override
    public AdesioneProgrammaFedeltaModel getById(UUID id) {
        AdesioneProgrammaFedeltaModel ret = null;
        try{
            ret = adesioneProgrammaFedeltaRepository.getByIdAndFlagEliminaIsFalse(id);
        } catch (Exception e){
            e.printStackTrace();
            log.error("Errore nel recupero del adesioneProgrammaFedelta per Id");
        }
        return ret;    }

    @Override
    public List<AdesioneProgrammaFedeltaModel> findAll() {
        List<AdesioneProgrammaFedeltaModel> ret = new ArrayList<>();
        try{
            ret = this.adesioneProgrammaFedeltaRepository.findAll();
        } catch (Exception e){
            e.printStackTrace();
            log.error("Errore nel recupero della lista dei clienti");
        }
        return ret;
    }

    @Override
    public Boolean setRinnovoFalse(UUID id) {
        if(!adesioneProgrammaFedeltaRepository.existsByIdAndFlagEliminaIsFalse( id ) ){
            log.error("Tentativo di disdire di un adesioneProgrammaFedelta non presente");
            return false;
        }
        try{
            adesioneProgrammaFedeltaRepository.setRinnovoAutomaticoToFalse(id);
            return true;
        } catch (Exception e) {
            log.error("Errore durante l'aggiornamento del rinnovo automatico di un adesioneProgrammaFedelta");
            e.getMessage();
            e.getCause();
            return false;
        }
    }
}

