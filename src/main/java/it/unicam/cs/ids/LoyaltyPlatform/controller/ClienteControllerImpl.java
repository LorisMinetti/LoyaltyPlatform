package it.unicam.cs.ids.LoyaltyPlatform.controller;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.AcquistoController;
import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.AttivitaCommercialeController;
import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.ClienteController;
import it.unicam.cs.ids.LoyaltyPlatform.model.*;
import it.unicam.cs.ids.LoyaltyPlatform.repository.ClienteRepositoryImpl;
import it.unicam.cs.ids.LoyaltyPlatform.repository.inbound.ClienteRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Slf4j
public class ClienteControllerImpl implements ClienteController {

    private final ClienteRepository clienteRepository;

    private final AcquistoController acquistoController;

    public ClienteControllerImpl() {
        this.clienteRepository = ClienteRepositoryImpl.getInstance();
        this.acquistoController = AcquistoControllerImpl.getInstance();
    }

    /*
     *  Singleton constructor
     */
    private static class SingletonBuilder {
        private static final ClienteController INSTANCE = new ClienteControllerImpl();
    }

    public static ClienteController getInstance() {
        return SingletonBuilder.INSTANCE;
    }

    //TODO: implementare il metodo
    @Override
    public boolean effettuaPagamento() {
        return false;
    }

    @Override
    public AcquistoModel effettuaAcquisto(ClienteModel clienteModel, AttivitaCommercialeModel attivita, double valoreAcquisto) {

        AcquistoModel ret = AcquistoModel.builder().cliente(clienteModel).attivitaCommerciale(attivita).valoreAcquisto(valoreAcquisto).build();
        AcquistoModel nuovoAcquisto = acquistoController.createAcquisto(ret);

        //prendo tutti i programmi fedeltà attivi per l'attività commerciale
        calcoloBeneficiPerAcquisto(clienteModel, attivita, valoreAcquisto);
        //caso generale della spesa totale da sommare una volta effettuato un qualsiasi acquisto, sia il primo o un successivo
        aggiornaSpesaTotale(clienteModel, attivita, valoreAcquisto);

        /*
        in futuro andrà implementato il concetto di pagamento andato a buon fine.
        */

        return ret;
    }

    private void calcoloBeneficiPerAcquisto(ClienteModel cliente, AttivitaCommercialeModel attivita, double valoreAcquisto) {
        AttivitaCommercialeController attivitaCommercialeController = new AttivitaCommercialeControllerImpl();

        List<ProgrammaFedeltaModel> listaProgrammi = attivitaCommercialeController.getAvailablePrograms(attivita);
        Map<ProgrammaALivelliModel, Integer> livelloPerAttivitaCommerciale = cliente.getLivelloPerAttivitaCommerciale();
        Map<ProgrammaAPuntiModel, Integer> puntiPerAttivitaCommerciale = cliente.getPuntiPerAttivitaCommerciale();
        Map<ProgrammaCashbackModel, Double> saldoPerAttivitaCommerciale = cliente.getSaldoPerAttivitaCommerciale();

        if(listaProgrammi.isEmpty()) {
            throw new IllegalArgumentException("Non ci possono essere atttività commerciali senza programmi fedeltà attivi");
        } else {
            //ci sono programmi fedeltà attivi e devo quindi considerarli tutti
            for(ProgrammaFedeltaModel programmaFedeltaModel : listaProgrammi) {

                if(programmaFedeltaModel instanceof ProgrammaALivelliModel programmaALivelliModel) {
                    if(livelloPerAttivitaCommerciale.containsKey(programmaALivelliModel)) {
                        if( (ricaricaSpesaTotaleCliente(cliente, attivita) + valoreAcquisto) >
                                programmaALivelliModel.getLivelli().get(programmaALivelliModel.getLivelloAttuale()))  //caso in cui con l'acquisto il cliente raggiunge il livello successivo
                        {
                            //il cliente ha raggiunto il livello successivo
                            programmaALivelliModel.setLivelloAttuale(programmaALivelliModel.getLivelloAttuale() + 1);
                        }
                    }

                } else if(programmaFedeltaModel instanceof ProgrammaAPuntiModel programmaAPuntiModel) {
                    if(puntiPerAttivitaCommerciale.containsKey(programmaAPuntiModel)) {
                        puntiPerAttivitaCommerciale
                                .put(programmaAPuntiModel, (int)(puntiPerAttivitaCommerciale.get(programmaAPuntiModel) + programmaAPuntiModel.getRapportoPunti() * valoreAcquisto));
                    } else {
                        //caso in cui vanno inseriti punti per questa attività commerciale per la prima volta
                        puntiPerAttivitaCommerciale
                                .put(programmaAPuntiModel, (int)(programmaAPuntiModel.getRapportoPunti() * valoreAcquisto));
                    }

                } else if(programmaFedeltaModel instanceof ProgrammaCashbackModel programmaCashbackModel) {
                    if(saldoPerAttivitaCommerciale.containsKey(programmaCashbackModel)) {
                        saldoPerAttivitaCommerciale
                                .put(programmaCashbackModel, saldoPerAttivitaCommerciale.get(programmaCashbackModel) + (valoreAcquisto/100 * programmaCashbackModel.getPercentualeCashback()));
                    } else {
                        saldoPerAttivitaCommerciale
                                .put(programmaCashbackModel, programmaCashbackModel.getPercentualeCashback() * valoreAcquisto);
                    }
                }
            }
        }
    }

    private double ricaricaSpesaTotaleCliente(ClienteModel cliente, AttivitaCommercialeModel attivitaCommerciale){
        double spesaTotale = 0;
        if(attivitaCommerciale != null){
            //devo controllare che nella map che gestisce il saldo dei clienti per ogni attivita (ogni programma a livelli infatti porta con se infatti l'attivita che lo offre)
            //ci sia già un programma a livelli offerto da questa attivita
            if(cliente.getSpesaTotalePerAttivitaCommerciale().containsKey(attivitaCommerciale)){
                spesaTotale = cliente.getSpesaTotalePerAttivitaCommerciale().get(attivitaCommerciale);
            }
        }
        return spesaTotale;
    }

    private void aggiornaSpesaTotale(ClienteModel cliente, AttivitaCommercialeModel attivita, double valoreAcquisto) {

        Map<AttivitaCommercialeModel, Double> spesaTotalePerAttivitaCommerciale = cliente.getSpesaTotalePerAttivitaCommerciale();
        for (Map.Entry<AttivitaCommercialeModel, Double> entry : spesaTotalePerAttivitaCommerciale.entrySet()) {
            AttivitaCommercialeModel key = entry.getKey();
            Double value = entry.getValue();

            //se trovo l'attività commerciale nella map, aggiorno il valore
            if(spesaTotalePerAttivitaCommerciale.containsKey(attivita)){
                value += valoreAcquisto;
                spesaTotalePerAttivitaCommerciale.replace(key, value);
                return;
            }
        }
        //se non ho trovato l'attività commerciale nella map, la aggiungo
        spesaTotalePerAttivitaCommerciale.put(attivita, valoreAcquisto);

    }


    /**
     * Metodi implementati dall'interfaccia Controller
     */

    @Override
    public ClienteModel createCliente(ClienteModel cliente) {
        if(cliente.getId() != null){
            throw new IllegalArgumentException("Non è possibile creare un cliente con un ID già esistente");
        }

        log.debug("Creazione nuovo cliente" + cliente.getNome());
        ClienteModel result = null;

        //TODO: eliminare questa riga quando sarà implementato il metodo di generazione automatica dell'ID
        cliente.setId(UUID.randomUUID());

        try{
            result = clienteRepository.save(cliente);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //TODO: implementare la ricerca per id
    @Override
    public ClienteModel getByName(String name) {
        ClienteModel clienteModel = null;
        try{
            clienteModel = clienteRepository.findByName(name);
        } catch (Exception e){
            System.err.println("Errore durante la lettura del ClienteModel: " + e.getMessage());
        }
        return clienteModel;
    }

    @Override
    public ClienteModel updateCliente(ClienteModel cliente) {
        if(cliente.getId() == null){
            throw new IllegalArgumentException("Non è possibile aggiornare un cliente senza ID");
        }

        log.debug("Modifica cliente" + cliente.getNome() + " --> ID: " + cliente.getId());

        ClienteModel result = null;
        try{
            result = clienteRepository.update(cliente);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean deleteCliente(ClienteModel cliente) {
        log.debug("Eliminazione cliente" + cliente.getNome() + " --> ID: " + cliente.getId());

        try{
            clienteRepository.delete(cliente);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
