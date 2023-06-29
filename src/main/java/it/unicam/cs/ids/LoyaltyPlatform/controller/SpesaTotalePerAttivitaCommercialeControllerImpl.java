package it.unicam.cs.ids.LoyaltyPlatform.controller;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.benefitsCliente.SpesaTotalePerAttivitaCommercialeController;
import it.unicam.cs.ids.LoyaltyPlatform.model.ClienteModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.subModel.SpesaTotalePerAttivitaCommerciale;
import it.unicam.cs.ids.LoyaltyPlatform.repository.SpesaTotalePerAttivitaCommercialeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class SpesaTotalePerAttivitaCommercialeControllerImpl implements SpesaTotalePerAttivitaCommercialeController {

    @Autowired
    private SpesaTotalePerAttivitaCommercialeRepository spesaTotalePerAttivitaCommercialeRepository;

    @Override
    public SpesaTotalePerAttivitaCommerciale createSpesaTotale(SpesaTotalePerAttivitaCommerciale spesaTotale) {
        if(spesaTotale == null) {
            log.error("Errore durante la creazione di un ProgrammaFedeltà. Elemento nullo");
        }
        SpesaTotalePerAttivitaCommerciale ret= null;
        try {
            ret = this.spesaTotalePerAttivitaCommercialeRepository.save(spesaTotale);
        } catch (Exception e) {
            log.debug("Errore di creazione spesaTotale {}:", spesaTotale);
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public SpesaTotalePerAttivitaCommerciale updateSpesaTotale(SpesaTotalePerAttivitaCommerciale spesaTotale) {
        if(spesaTotale.getId() == null) {
            log.error("Errore durante la modifica di un ProgrammaFedeltà. Elemento nullo");
        }
        SpesaTotalePerAttivitaCommerciale ret= null;
        try {
            ret = this.spesaTotalePerAttivitaCommercialeRepository.save(spesaTotale);
        } catch (Exception e) {
            log.debug("Errore di modifica spesaTotale {}:", spesaTotale);
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public boolean deleteSpesaTotale(SpesaTotalePerAttivitaCommerciale spesaTotale) {
        if( ! this.spesaTotalePerAttivitaCommercialeRepository.existsByIdAndFlagEliminaIsFalse(spesaTotale.getId())) {
            log.error("Errore durante l'eliminazione spesaTotale {} non presente a DB", spesaTotale);
        }
        try{
            this.spesaTotalePerAttivitaCommercialeRepository.setFlagDelete(spesaTotale.getId());
            return true;
        } catch(Exception e){
            log.error("Errore durante l'eliminazione spesaTotale {}", spesaTotale);
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public SpesaTotalePerAttivitaCommerciale getById(UUID id) {
        if( ! this.spesaTotalePerAttivitaCommercialeRepository.existsByIdAndFlagEliminaIsFalse(id)) {
            log.error("Errore durante il recupero spesaTotale");
        }
        SpesaTotalePerAttivitaCommerciale ret = null;
        try{
            ret = this.spesaTotalePerAttivitaCommercialeRepository.getByIdAndFlagEliminaIsFalse(id);
        } catch (Exception e){
            log.error("Errore durante il recupero spesaTotale");
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public List<SpesaTotalePerAttivitaCommerciale> findAll() {
        List<SpesaTotalePerAttivitaCommerciale> ret = new ArrayList<>();
        try {
            ret = this.spesaTotalePerAttivitaCommercialeRepository.findAll();
        } catch (Exception e) {
            log.error("Errore nel recupero della lista dei clienti");
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public List<SpesaTotalePerAttivitaCommerciale> findAllByCliente(ClienteModel cliente) {
        List<SpesaTotalePerAttivitaCommerciale> ret = new ArrayList<>();
        try {
            ret = this.spesaTotalePerAttivitaCommercialeRepository.findAllByCliente(cliente);
        } catch (Exception e) {
            log.error("Errore nel recupero della lista dei clienti");
            e.printStackTrace();
        }
        return ret;
    }
}
