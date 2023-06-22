package it.unicam.cs.ids.LoyaltyPlatform.controller;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.ClienteController;
import it.unicam.cs.ids.LoyaltyPlatform.model.AcquistoModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.AttivitaCommercialeModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.ClienteModel;
import it.unicam.cs.ids.LoyaltyPlatform.repository.inbound.ClienteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class ClienteControllerImpl implements ClienteController {


    @Autowired(required = false)
    private ClienteRepository clienteRepository;
    @Override
    public ClienteModel createCliente(ClienteModel cliente) {
        if(cliente.getId() != null) {
            log.error("Tentativo di creazione di un cliente con id già presente");
        }
        try{
            return clienteRepository.save(cliente);
        } catch (Exception e) {
            log.error("Errore durante la creazione di un cliente");
            return null;
        }
    }

    @Override
    public ClienteModel updateCliente(ClienteModel cliente) {
        if(cliente.getId() == null) {
            log.error("Tentativo di aggiornamento di un cliente senza id");
        }
        try{
            return clienteRepository.save(cliente);
        } catch (Exception e) {
            log.error("Errore durante l'aggiornamento di un cliente");
            return null;
        }
    }

    @Override
    public boolean deleteCliente(ClienteModel cliente) {
        if(!clienteRepository.existsByIdAndFlagEliminaIsFalse(cliente.getId())){
            log.error("Tentativo di eliminazione di un cliente non presente");
            return false;
        }
        try{
            clienteRepository.setFlagDelete(cliente.getId());
            return true;
        } catch (Exception e) {
            log.error("Errore durante l'eliminazione di un cliente");
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public ClienteModel getById(UUID id) {
        ClienteModel ret = null;
        try{
            ret = clienteRepository.getByIdAndFlagEliminaIsFalse(id);
        } catch (Exception e){
            e.printStackTrace();
            log.error("Errore nel recupero del cliente per Id");
        }
        return ret;
    }

    @Override
    public List<ClienteModel> findAll(){
        List<ClienteModel> ret = new ArrayList<>();
        try{
            ret = this.clienteRepository.findAll();
        } catch (Exception e){
            e.printStackTrace();
            log.error("Errore nel recupero della lista dei clienti");
        }
        return ret;
    }


    //TODO: implementare
    @Override
    public AcquistoModel effettuaAcquisto(ClienteModel clienteModel, AttivitaCommercialeModel attivita, double valoreAcquisto) {
        return null;
    }

    //TODO: implementare
    @Override
    public boolean effettuaPagamento() {
        return false;
    }
}
