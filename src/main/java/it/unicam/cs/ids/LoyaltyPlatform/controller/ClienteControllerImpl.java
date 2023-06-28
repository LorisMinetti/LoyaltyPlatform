package it.unicam.cs.ids.LoyaltyPlatform.controller;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.*;
import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.benefitsCliente.LivelloPerAttivitaCommercialeController;
import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.benefitsCliente.PuntiPerAttivitaCommercialeController;
import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.benefitsCliente.SaldoPerAttivitaCommercialeController;
import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.benefitsCliente.SpesaTotalePerAttivitaCommercialeController;
import it.unicam.cs.ids.LoyaltyPlatform.model.*;
import it.unicam.cs.ids.LoyaltyPlatform.model.subModel.PuntiPerAttivitaCommerciale;
import it.unicam.cs.ids.LoyaltyPlatform.model.subModel.SaldoPerAttivitaCommerciale;
import it.unicam.cs.ids.LoyaltyPlatform.model.subModel.SpesaTotalePerAttivitaCommerciale;
import it.unicam.cs.ids.LoyaltyPlatform.model.subModel.request.AcquistoRequest;
import it.unicam.cs.ids.LoyaltyPlatform.repository.ClienteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ClienteControllerImpl implements ClienteController {


    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private AcquistoController acquistoController;
    @Autowired
    private AttivitaCommercialeController attivitaCommercialeController;
    @Autowired
    private ProgrammaFedeltaController programmaFedeltaController;
    @Autowired
    private PuntiPerAttivitaCommercialeController puntiPerAttivitaCommercialeController;
    @Autowired
    private SaldoPerAttivitaCommercialeController saldoPerAttivitaCommercialeController;
    @Autowired
    private LivelloPerAttivitaCommercialeController livelloPerAttivitaCommercialeController;
    @Autowired
    private AdesioneProgrammaFedeltaController adesioneProgrammaFedeltaController;
    @Autowired
    private SpesaTotalePerAttivitaCommercialeController spesaTotalePerAttivitaCommercialeController;


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
    public ClienteModel effettuaAcquisto(AcquistoRequest acquistoRequest) {
        if(acquistoRequest==null){
            log.error("Tentativo di effettuare un acquisto con una richiesta nulla");
            return null;
        }
        ClienteModel cliente = this.getById(acquistoRequest.getIdCliente());
        AttivitaCommercialeModel attivitaCommerciale = attivitaCommercialeController.getById(acquistoRequest.getIdAttivitaCommerciale());
        double prezzo = acquistoRequest.getValoreAcquisto();

        AcquistoModel acquisto = new AcquistoModel();
        acquisto.setCliente(cliente);
        acquisto.setAttivitaCommerciale(attivitaCommerciale);
        acquisto.setValoreAcquisto(prezzo);

        //Salvo effettivamente l'acquisto a DB
        try{
            acquistoController.createAcquisto(acquisto);
            //pagamento effettuato dalcliente
        } catch (Exception e){
            e.printStackTrace();
            log.error("Errore durante l'acquisto");
        }


        //La spesa totale va aggiornata sempre
        SpesaTotalePerAttivitaCommerciale spesaTotaleInstance =
                spesaTotalePerAttivitaCommercialeController.findAll()
                        .stream()
                        .filter(s -> s.getCliente().equals(cliente))
                        .filter(s -> s.getAttivitaCommerciale().getId().equals(attivitaCommerciale.getId()))
                        .findFirst()
                        .orElse(null);
        //Se non esiste una spesa totale per questa attività commerciale la creo
        if(spesaTotaleInstance == null){
            spesaTotaleInstance = new SpesaTotalePerAttivitaCommerciale();
            spesaTotaleInstance.setAttivitaCommerciale(attivitaCommerciale);
            spesaTotaleInstance.setCliente(cliente);
            spesaTotaleInstance.setSpesaTotale(prezzo);

            spesaTotalePerAttivitaCommercialeController.createSpesaTotale(spesaTotaleInstance);
            //cliente.getSpesaTotalePerAttivitaCommerciale().add(spesaTotaleInstance);       //Devo aggiungere l'istanza al Set<SpesaTotale...> del cliente

        } else {
            //Se esiste la aggiorno
            spesaTotaleInstance.setSpesaTotale( spesaTotaleInstance.getSpesaTotale() + prezzo );
            spesaTotalePerAttivitaCommercialeController.updateSpesaTotale(spesaTotaleInstance);
        }


        //Ricavo i programmi fedelta dell'attività commerciale
        List<ProgrammaFedeltaModel> programmiAderiti = adesioneProgrammaFedeltaController.findAll()
                .stream()
                .filter(a -> a.getIdAttivitaCommerciale().equals(attivitaCommerciale.getId()))
                .map(a -> programmaFedeltaController.getById(a.getIdProgrammaFedelta()))
//                .distinct()
                .collect(Collectors.toList());

        for(ProgrammaFedeltaModel programma : programmiAderiti) {

            switch (programma.getNome()) {
                case "Punti":

                    //Prendo l'istanza dei punti collegati all'attività commerciale del cliente che effettua l'acquisto
                    PuntiPerAttivitaCommerciale puntiAttualiInstance = puntiPerAttivitaCommercialeController.findAll()
                            .stream()
                            .filter(p -> p.getCliente().equals(cliente))
                            .filter(p -> p.getAttivitaCommerciale().equals(attivitaCommerciale))
                            .findFirst()
                            .orElse(null);

                    AdesioneProgrammaFedeltaModel adesionePunti = adesioneProgrammaFedeltaController.findAll()
                            .stream()
                            .filter(a -> a.getIdAttivitaCommerciale().equals(attivitaCommerciale.getId()))
                            .filter(a -> a.getIdProgrammaFedelta().equals(programma.getId()))
                            .findFirst()
                            .orElse(null);

                    if(puntiAttualiInstance == null) {
                        //Se non esiste un'istanza di punti per questa attività commerciale la creo
                        puntiAttualiInstance = new PuntiPerAttivitaCommerciale();
                        puntiAttualiInstance.setAttivitaCommerciale(attivitaCommerciale);
                        puntiAttualiInstance.setCliente(cliente);
                        puntiAttualiInstance.setPunti(prezzo * adesionePunti.getRapportoPunti());

                        puntiPerAttivitaCommercialeController.createPuntiPerAttivita(puntiAttualiInstance);    //Devo aggiungere l'istanza al DB
                        //cliente.getPuntiPerAttivitaCommerciale().add(puntiAttualiInstance);                    //Devo aggiungere l'istanza al Set<PuntiPerAttivitaCommerciale> del cliente

                    } else {
                        //Se esiste la aggiorno
                        puntiAttualiInstance.setPunti( puntiAttualiInstance.getPunti() + (prezzo * adesionePunti.getRapportoPunti()) );
                        puntiPerAttivitaCommercialeController.updatePuntiPerAttivita(puntiAttualiInstance);
                    }
                    break;


                case "Livelli":
                    //calcola benefici livelli
                    //TODO: da implementare
                    break;


                case "Cashback":
                    SaldoPerAttivitaCommerciale saldoAttualeInstance = saldoPerAttivitaCommercialeController.findAll()
                            .stream()
                            .filter(p -> p.getCliente().equals(cliente))
                            .filter(p -> p.getAttivitaCommerciale().equals(attivitaCommerciale))
                            .findFirst()
                            .orElse(null);

                    AdesioneProgrammaFedeltaModel adesioneCashback = adesioneProgrammaFedeltaController.findAll()
                            .stream()
                            .filter(a -> a.getIdAttivitaCommerciale().equals(attivitaCommerciale.getId()))
                            .filter(a -> a.getIdProgrammaFedelta().equals(programma.getId()))
                            .findFirst()
                            .orElse(null);

                    if(saldoAttualeInstance == null){
                        saldoAttualeInstance = new SaldoPerAttivitaCommerciale();
                        saldoAttualeInstance.setAttivitaCommerciale(attivitaCommerciale);
                        saldoAttualeInstance.setCliente(cliente);
                        saldoAttualeInstance.setSaldo( (prezzo / 100 ) * adesioneCashback.getPercentualeCashback());

                        saldoPerAttivitaCommercialeController.createSaldoPerAttivita(saldoAttualeInstance);    //Devo aggiungere l'istanza al DB
                        //cliente.getSaldoPerAttivitaCommerciale().add(saldoAttualeInstance);                    //Devo aggiungere l'istanza al Set<SaldoPerAttivitaCommerciale> del cliente

                    } else {
                        //Se esiste la aggiorno
                        saldoAttualeInstance.setSaldo( saldoAttualeInstance.getSaldo() + ( (prezzo / 100 ) * adesioneCashback.getPercentualeCashback() ) );
                        saldoPerAttivitaCommercialeController.updateSaldoPerAttivita(saldoAttualeInstance);
                    }
                    break;

            }
        }


        return cliente;

    }

    //TODO: implementare
    @Override
    public boolean effettuaPagamento() {
        return false;
    }
}
