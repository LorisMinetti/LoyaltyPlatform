package it.unicam.cs.ids.LoyaltyPlatform.controller;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.benefitsCliente.PuntiPerAttivitaCommercialeController;
import it.unicam.cs.ids.LoyaltyPlatform.model.ClienteModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.subModel.PuntiPerAttivitaCommerciale;
import it.unicam.cs.ids.LoyaltyPlatform.repository.PuntiPerAttivitaCommercialeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class PuntiPerAttivitaCommercialeControllerImpl implements PuntiPerAttivitaCommercialeController {

    @Autowired
    private PuntiPerAttivitaCommercialeRepository puntiPerAttivitaCommercialeRepository;

    @Override
    public PuntiPerAttivitaCommerciale createPuntiPerAttivita(PuntiPerAttivitaCommerciale puntiPerAttivita) {
        if(puntiPerAttivita == null) {
            log.error("Errore durante la creazione di un ProgrammaFedeltà. Elemento nullo");
        }
        PuntiPerAttivitaCommerciale ret= null;
        try{
            ret = this.puntiPerAttivitaCommercialeRepository.save(puntiPerAttivita);
        } catch (Exception e){
            log.debug("Errore di creazione puntiPerAttivita {}:", puntiPerAttivita);
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public PuntiPerAttivitaCommerciale updatePuntiPerAttivita(PuntiPerAttivitaCommerciale puntiPerAttivita) {
        if(puntiPerAttivita.getId() == null) {
            log.error("Errore durante la modifica di un ProgrammaFedeltà. Elemento nullo");
        }
        PuntiPerAttivitaCommerciale ret= null;
        try{
            ret = this.puntiPerAttivitaCommercialeRepository.save(puntiPerAttivita);
        } catch (Exception e){
            log.debug("Errore di modifica puntiPerAttivita {}:", puntiPerAttivita);
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public boolean deletePuntiPerAttivita(PuntiPerAttivitaCommerciale puntiPerAttivita) {
        if( ! this.puntiPerAttivitaCommercialeRepository.existsByIdAndFlagEliminaIsFalse(puntiPerAttivita.getId())) {
            log.error("Errore durante l'eliminazione puntiPerAttivita {} non presente a DB", puntiPerAttivita);
        }
        try{
            this.puntiPerAttivitaCommercialeRepository.setFlagDelete(puntiPerAttivita.getId());
            return true;
        } catch(Exception e){
            log.error("Errore durante l'eliminazione puntiPerAttivita {}", puntiPerAttivita);
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public PuntiPerAttivitaCommerciale getById(UUID id) {
        if( ! this.puntiPerAttivitaCommercialeRepository.existsByIdAndFlagEliminaIsFalse(id)) {
            log.error("Errore durante il recupero puntiPerAttivita");
        }
        PuntiPerAttivitaCommerciale ret = null;
        try{
            ret = this.puntiPerAttivitaCommercialeRepository.getByIdAndFlagEliminaIsFalse(id);
        } catch (Exception e){
            log.error("Errore durante il recupero puntiPerAttivita");
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public List<PuntiPerAttivitaCommerciale> findAll() {
        List<PuntiPerAttivitaCommerciale> ret = new ArrayList<>();
        try{
            ret = this.puntiPerAttivitaCommercialeRepository.findAll();
        } catch (Exception e){
            log.error("Errore nel recupero della lista dei puntiPerAttivita");
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public List<PuntiPerAttivitaCommerciale> findAllByCliente(ClienteModel cliente) {
        List<PuntiPerAttivitaCommerciale> ret = new ArrayList<>();
        try{
            ret = this.puntiPerAttivitaCommercialeRepository.findAllByCliente(cliente);
        } catch (Exception e){
            log.error("Errore nel recupero della lista dei clienti");
            e.printStackTrace();

        }
        return ret;
    }
}

