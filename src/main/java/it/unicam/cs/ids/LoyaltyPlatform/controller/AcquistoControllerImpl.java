package it.unicam.cs.ids.LoyaltyPlatform.controller;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.AcquistoController;
import it.unicam.cs.ids.LoyaltyPlatform.model.AcquistoModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.ClienteModel;
import it.unicam.cs.ids.LoyaltyPlatform.repository.AcquistoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class AcquistoControllerImpl implements AcquistoController {

    @Autowired
    private AcquistoRepository acquistoRepository;


    @Override
    public AcquistoModel createAcquisto(AcquistoModel acquisto) {
        if(acquisto.getId() != null) {
            log.error("Tentativo di creazione di un acquisto con id già presente");
        }
        try{
            return acquistoRepository.save(acquisto);
        } catch (Exception e) {
            log.error("Errore durante la creazione di un acquisto");
            return null;
        }
    }
    @Override
    public AcquistoModel updateAcquisto(AcquistoModel acquisto) {
        if(acquisto.getId() == null) {
            log.error("Tentativo di aggiornamento di un acquisto senza id");
        }
        try{
            return acquistoRepository.save(acquisto);
        } catch (Exception e) {
            log.error("Errore durante l'aggiornamento di un acquisto");
            return null;
        }    }

    @Override
    public boolean deleteAcquisto(AcquistoModel acquisto) {
        if(!acquistoRepository.existsByIdAndFlagEliminaIsFalse(acquisto.getId())){
            log.error("Tentativo di eliminazione di un acquisto non presente");
            return false;
        }
        try{
            acquistoRepository.setFlagDelete(acquisto.getId());
            return true;
        } catch (Exception e) {
            log.error("Errore durante l'eliminazione di un attivitaCommerciale");
            e.printStackTrace();
            return false;
        }    }

    @Override
    public AcquistoModel getById(UUID id) {
        AcquistoModel ret = null;
        try{
            ret = acquistoRepository.getByIdAndFlagEliminaIsFalse(id);
        } catch (Exception e){
            e.printStackTrace();
            log.error("Errore nel recupero del acquisto per Id");
        }
        return ret;
    }

    @Override
    public List<AcquistoModel> findAll() {
        List<AcquistoModel> ret = new ArrayList<>();
        try{
            ret = this.acquistoRepository.findAll();
        } catch (Exception e){
            e.printStackTrace();
            log.error("Errore nel recupero della lista dei acquisto");
        }
        return ret;    }

    @Override
    public List<AcquistoModel> findAllforCliente(ClienteModel cliente) {
        List<AcquistoModel> ret = new ArrayList<>();
        try{
            ret = this.acquistoRepository.findAllByCliente(cliente);
        } catch (Exception e){
            e.printStackTrace();
            log.error("Errore nel recupero della lista dei acquisto");
        }
        return ret;    }
}
