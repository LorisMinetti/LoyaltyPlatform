package it.unicam.cs.ids.LoyaltyPlatform.controller;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.benefitsCliente.LivelloPerAttivitaCommercialeController;
import it.unicam.cs.ids.LoyaltyPlatform.model.ClienteModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.subModel.LivelloPerAttivitaCommerciale;
import it.unicam.cs.ids.LoyaltyPlatform.repository.LivelloPerAttivitaCommercialeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class LivelloPerAttivitaCommercialeControllerImpl implements LivelloPerAttivitaCommercialeController {
    
    @Autowired
    private LivelloPerAttivitaCommercialeRepository livelloPerAttivitaCommercialeRepository;
    
    @Override
    public LivelloPerAttivitaCommerciale createLivelloPerAttivita(LivelloPerAttivitaCommerciale livello) {
        if(livello == null){
            log.error("Errore durante la creazione di un livello. Elemento nullo");
        }
        LivelloPerAttivitaCommerciale ret= null;
        try{
            ret = this.livelloPerAttivitaCommercialeRepository.save(livello);
        } catch (Exception e){
            log.debug("Errore di creazione livello {}:", livello);
        }

        return ret;    }

    @Override
    public LivelloPerAttivitaCommerciale updateLivelloPerAttivita(LivelloPerAttivitaCommerciale livello) {
        if(livello.getId() == null){
            log.error("Errore durante la modifica di un livello. Elemento nullo");
        }
        LivelloPerAttivitaCommerciale ret= null;
        try{
            ret = this.livelloPerAttivitaCommercialeRepository.save(livello);
        } catch (Exception e){
            log.debug("Errore di modifica livello {}:", livello);
        }

        return ret;    }

    @Override
    public boolean deleteLivelloPerAttivita(LivelloPerAttivitaCommerciale livello) {
        if( ! this.livelloPerAttivitaCommercialeRepository
                .existsByIdAndFlagEliminaIsFalse(livello.getId()) )
        {
            log.error("Errore durante l'eliminazione livello {} non presente a DB", livello);
        }
        try{
            this.livelloPerAttivitaCommercialeRepository.setFlagDelete(livello.getId());
            return true;
        } catch(Exception e){
            log.error("Errore durante l'eliminazione livello {}", livello);
        }
        return false;    }

    @Override
    public LivelloPerAttivitaCommerciale getById(UUID id) {
        if( ! this.livelloPerAttivitaCommercialeRepository.existsByIdAndFlagEliminaIsFalse(id) ){
            log.error("Errore durante il recupero livello");
        }
        LivelloPerAttivitaCommerciale ret = null;
        try{
            ret = this.livelloPerAttivitaCommercialeRepository.getByIdAndFlagEliminaIsFalse(id);
        } catch (Exception e){
            e.printStackTrace();
            log.error("Errore durante il recupero livello");
        }
        return ret;    }

    @Override
    public List<LivelloPerAttivitaCommerciale> findAll() {
        List<LivelloPerAttivitaCommerciale> ret = new ArrayList<>();
        try{
            ret = this.livelloPerAttivitaCommercialeRepository.findAll();
        } catch (Exception e){
            e.printStackTrace();
            log.error("Errore nel recupero della lista dei livelli");
        }
        return ret;    }

    @Override
    public List<LivelloPerAttivitaCommerciale> findAllByCliente(ClienteModel cliente) {
        List<LivelloPerAttivitaCommerciale> ret = new ArrayList<>();
        try{
            ret = this.livelloPerAttivitaCommercialeRepository.findAllByCliente(cliente);
        } catch (Exception e){
            e.printStackTrace();
            log.error("Errore nel recupero della lista dei livelli");
        }
        return ret;    
    }
}
