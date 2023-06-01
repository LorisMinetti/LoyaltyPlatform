package it.unicam.cs.ids.LoyaltyPlatform.controller;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.AttivitaCommercialeController;
import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.ClienteController;
import it.unicam.cs.ids.LoyaltyPlatform.model.*;
import it.unicam.cs.ids.LoyaltyPlatform.repository.ClienteRepositoryImpl;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Slf4j
public class ClienteControllerImpl implements ClienteController {

    private ClienteModel clienteModel;

    private final ClienteRepositoryImpl clienteRepositoryImpl;

    public ClienteControllerImpl() {
        this.clienteRepositoryImpl = ClienteRepositoryImpl.getInstance();
    }


    //TODO: implementare il metodo
    @Override
    public boolean effettuaPagamento() {
        return false;
    }




    @Override
    public AcquistoModel effettuaAcquisto(AttivitaCommercialeModel attivita, double valoreAcquisto) {

        AcquistoModel ret = new AcquistoModel();
        ret.setClienteModel(this.clienteModel);
        ret.setValoreAcquisto(valoreAcquisto);
        ret.setAttivitaCommercialeModel(attivita);

        //prendo tutti i programmi fedeltà attivi per l'attività commerciale
        calcoloBeneficiPerAcquisto(attivita, valoreAcquisto);
        //caso generale della spesa totale da sommare una volta effettuato un qualsiasi acquisto, sia il primo o un successivo
        aggiornaSpesaTotale(attivita, valoreAcquisto);

        /*
        in futuro andrà implementato il concetto di pagamento andato a buon fine.
        */

        return ret;
    }

    private void calcoloBeneficiPerAcquisto(AttivitaCommercialeModel attivita, double valoreAcquisto) {
        AttivitaCommercialeController attivitaCommercialeController = new AttivitaCommercialeControllerImpl();

        List<ProgrammaFedelta> listaProgrammi = attivitaCommercialeController.getAvailablePrograms();
        Map<ProgrammaALivelliModel, Integer> livelloPerAttivitaCommerciale = clienteModel.getLivelloPerAttivitaCommerciale();
        Map<ProgrammaAPuntiModel, Integer> puntiPerAttivitaCommerciale = clienteModel.getPuntiPerAttivitaCommerciale();
        Map<ProgrammaCashbackModel, Double> saldoPerAttivitaCommerciale = clienteModel.getSaldoPerAttivitaCommerciale();

        if(listaProgrammi.isEmpty()) {
            throw new IllegalArgumentException("Non ci possono essere atttività commerciali senza programmi fedeltà attivi");
        } else {
            //ci sono programmi fedeltà attivi e devo quindi considerarli tutti
            for(ProgrammaFedelta programmaFedelta : listaProgrammi) {

                if(programmaFedelta instanceof ProgrammaALivelliModel programmaALivelliModel) {
                    if(livelloPerAttivitaCommerciale.containsKey(programmaALivelliModel)) {
                        if( (ricaricaSpesaTotaleCliente(attivita) + valoreAcquisto) >
                                programmaALivelliModel.getLivelli().get(programmaALivelliModel.getLivelloAttuale()))  //caso in cui con l'acquisto il cliente raggiunge il livello successivo
                        {
                            //il cliente ha raggiunto il livello successivo
                            programmaALivelliModel.setLivelloAttuale(programmaALivelliModel.getLivelloAttuale() + 1);
                        }
                    }

                } else if(programmaFedelta instanceof ProgrammaAPuntiModel programmaAPuntiModel) {
                    if(puntiPerAttivitaCommerciale.containsKey(programmaAPuntiModel)) {
                        puntiPerAttivitaCommerciale
                                .put(programmaAPuntiModel, (int)(puntiPerAttivitaCommerciale.get(programmaAPuntiModel) + programmaAPuntiModel.getRapportoPunti() * valoreAcquisto));
                    } else {
                        //caso in cui vanno inseriti punti per questa attività commerciale per la prima volta
                        puntiPerAttivitaCommerciale
                                .put(programmaAPuntiModel, (int)(programmaAPuntiModel.getRapportoPunti() * valoreAcquisto));
                    }

                } else if(programmaFedelta instanceof ProgrammaCashbackModel programmaCashbackModel) {
                    if(saldoPerAttivitaCommerciale.containsKey(programmaCashbackModel)) {
                        saldoPerAttivitaCommerciale
                                .put(programmaCashbackModel, saldoPerAttivitaCommerciale.get(programmaCashbackModel) + programmaCashbackModel.getPercentualeCashback() * valoreAcquisto);
                    } else {
                        saldoPerAttivitaCommerciale
                                .put(programmaCashbackModel, programmaCashbackModel.getPercentualeCashback() * valoreAcquisto);
                    }
                }
            }
        }
    }

    private double ricaricaSpesaTotaleCliente(AttivitaCommercialeModel attivitaCommerciale){
        double spesaTotale = 0;
        if(attivitaCommerciale != null){
            //devo controllare che nella map che gestisce il saldo dei clienti per ogni attivita (ogni programma a livelli infatti porta con se infatti l'attivita che lo offre)
            //ci sia già un programma a livelli offerto da questa attivita
            if(clienteModel.getSpesaTotalePerAttivitaCommerciale().containsKey(attivitaCommerciale)){
                spesaTotale = clienteModel.getSpesaTotalePerAttivitaCommerciale().get(attivitaCommerciale);
            }
        }
        return spesaTotale;
    }

    private void aggiornaSpesaTotale(AttivitaCommercialeModel attivita, double valoreAcquisto) {
        /*
         */
        if(clienteModel.getSpesaTotalePerAttivitaCommerciale().containsKey(attivita)) {
            clienteModel.getSpesaTotalePerAttivitaCommerciale().put(attivita, clienteModel.getSpesaTotalePerAttivitaCommerciale().get(attivita) + valoreAcquisto);
        } else {
            clienteModel.getSpesaTotalePerAttivitaCommerciale().put(attivita, valoreAcquisto);
        }
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
            result = clienteRepositoryImpl.save(cliente);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //TODO: implementare la ricerca per id
    @Override
    public ClienteModel getById(UUID id) {
        return null;
    }

    @Override
    public ClienteModel updateCliente(ClienteModel cliente) {
        if(cliente.getId() == null){
            throw new IllegalArgumentException("Non è possibile aggiornare un cliente senza ID");
        }

        log.debug("Modifica cliente" + cliente.getNome() + " --> ID: " + cliente.getId());

        ClienteModel result = null;
        try{
            result = clienteRepositoryImpl.update(cliente);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean deleteCliente(ClienteModel clienteModel) {
        log.debug("Eliminazione cliente" + clienteModel.getNome() + " --> ID: " + clienteModel.getId());

        try{
            clienteRepositoryImpl.delete(clienteModel);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
