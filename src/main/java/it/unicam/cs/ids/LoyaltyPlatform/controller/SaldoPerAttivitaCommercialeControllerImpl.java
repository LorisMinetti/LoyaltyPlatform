package it.unicam.cs.ids.LoyaltyPlatform.controller;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.benefitsCliente.SaldoPerAttivitaCommercialeController;
import it.unicam.cs.ids.LoyaltyPlatform.model.ClienteModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.subModel.SaldoPerAttivitaCommerciale;
import it.unicam.cs.ids.LoyaltyPlatform.repository.SaldoPerAttivitaCommercialeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class SaldoPerAttivitaCommercialeControllerImpl implements SaldoPerAttivitaCommercialeController
{

    @Autowired
    private SaldoPerAttivitaCommercialeRepository saldoPerAttivitaCommercialeRepository;
    @Override
    public SaldoPerAttivitaCommerciale createSaldoPerAttivita(SaldoPerAttivitaCommerciale saldoPerAttivitaModel) {
        if(saldoPerAttivitaModel == null){
            log.error("Errore durante la creazione di un ProgrammaFedeltà. Elemento nullo");
        }
        SaldoPerAttivitaCommerciale ret= null;
        try{
            ret = this.saldoPerAttivitaCommercialeRepository.save(saldoPerAttivitaModel);
        } catch (Exception e){
            log.debug("Errore di creazione saldoPerAttivitaModel {}:", saldoPerAttivitaModel);
        }

        return ret;    }

    @Override
    public SaldoPerAttivitaCommerciale updateSaldoPerAttivita(SaldoPerAttivitaCommerciale saldoPerAttivitaModel) {
        if(saldoPerAttivitaModel.getId() == null){
            log.error("Errore durante la modifica di un ProgrammaFedeltà. Elemento nullo");
        }
        SaldoPerAttivitaCommerciale ret= null;
        try{
            ret = this.saldoPerAttivitaCommercialeRepository.save(saldoPerAttivitaModel);
        } catch (Exception e){
            log.debug("Errore di modifica saldoPerAttivitaModel {}:", saldoPerAttivitaModel);
        }

        return ret;    }

    @Override
    public boolean deleteSaldoPerAttivita(SaldoPerAttivitaCommerciale saldoPerAttivitaModel) {
        if( ! this.saldoPerAttivitaCommercialeRepository
                .existsByIdAndFlagEliminaIsFalse(saldoPerAttivitaModel.getId()) )
        {
            log.error("Errore durante l'eliminazione saldoPerAttivitaModel {} non presente a DB", saldoPerAttivitaModel);
        }
        try{
            this.saldoPerAttivitaCommercialeRepository.setFlagDelete(saldoPerAttivitaModel.getId());
            return true;
        } catch(Exception e){
            log.error("Errore durante l'eliminazione saldoPerAttivitaModel {}", saldoPerAttivitaModel);
        }
        return false;    }

    @Override
    public SaldoPerAttivitaCommerciale getById(UUID id) {
        if( ! this.saldoPerAttivitaCommercialeRepository.existsByIdAndFlagEliminaIsFalse(id) ){
            log.error("Errore durante il recupero saldoPerAttivitaModel");
        }
        SaldoPerAttivitaCommerciale ret = null;
        try{
            ret = this.saldoPerAttivitaCommercialeRepository.getByIdAndFlagEliminaIsFalse(id);
        } catch (Exception e){
            e.printStackTrace();
            log.error("Errore durante il recupero saldoPerAttivitaModel");
        }
        return ret;    }

    @Override
    public List<SaldoPerAttivitaCommerciale> findAll() {
        List<SaldoPerAttivitaCommerciale> ret = new ArrayList<>();
        try{
            ret = this.saldoPerAttivitaCommercialeRepository.findAll();
        } catch (Exception e){
            e.printStackTrace();
            log.error("Errore nel recupero della lista dei clienti");
        }
        return ret;    }

    @Override
    public List<SaldoPerAttivitaCommerciale> findAllByCliente(ClienteModel cliente) {
        List<SaldoPerAttivitaCommerciale> ret = new ArrayList<>();
        try{
            ret = this.saldoPerAttivitaCommercialeRepository.findAllByCliente(cliente);
        } catch (Exception e){
            e.printStackTrace();
            log.error("Errore nel recupero della lista dei clienti");
        }
        return ret;    }
}
