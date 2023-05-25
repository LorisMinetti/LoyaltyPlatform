package it.unicam.cs.ids.LoyaltyPlatform.controller;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.AttivitaCommercialeController;
import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.ClienteController;
import it.unicam.cs.ids.LoyaltyPlatform.model.*;
import it.unicam.cs.ids.LoyaltyPlatform.repository.ClienteRepositoryImpl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ClienteControllerImpl implements ClienteController {

    private ClienteModel cliente;

    private ClienteRepositoryImpl clienteRepositoryImpl;

    public ClienteControllerImpl(ClienteModel cliente) {
        this.cliente = cliente;
    }


    @Override
    public boolean effettuaPagamento() {
        return false;
    }




    @Override
    public Acquisto effettuaAcquisto(AttivitaCommercialeController attivita, double valoreAcquisto) {

        Acquisto ret = new Acquisto();
        ret.setClienteController(this);
        ret.setValoreAcquisto(valoreAcquisto);
        ret.setAttivitaCommerciale(attivita);

        //prendo tutti i programmi fedeltà attivi per l'attività commerciale
        calcoloBeneficiPerAcquisto(attivita, valoreAcquisto);
        //caso generale della spesa totale da sommare una volta effettuato un qualsiasi acquisto, sia il primo o un successivo
        aggiornaSpesaTotale(attivita, valoreAcquisto);

        /*
        in futuro andrà implementato il concetto di pagamento andato a buon fine.
        */

        return ret;
    }

    private void calcoloBeneficiPerAcquisto(AttivitaCommercialeController attivita, double valoreAcquisto) {
        List<ProgrammaFedelta> listaProgrammi = attivita.getAvailablePrograms();
        Map<ProgrammaALivelli, Integer> livelloPerAttivitaCommerciale = cliente.getLivelloPerAttivitaCommerciale();
        Map<ProgrammaAPunti, Integer> puntiPerAttivitaCommerciale = cliente.getPuntiPerAttivitaCommerciale();
        Map<ProgrammaCashback, Double> saldoPerAttivitaCommerciale = cliente.getSaldoPerAttivitaCommerciale();

        if(listaProgrammi.isEmpty()) {
            throw new IllegalArgumentException("Non ci possono essere atttività commerciali senza programmi fedeltà attivi");
        } else {
            //ci sono programmi fedeltà attivi e devo quindi considerarli tutti
            for(ProgrammaFedelta programmaFedelta : listaProgrammi) {

                if(programmaFedelta instanceof ProgrammaALivelli programmaALivelli) {
                    if(livelloPerAttivitaCommerciale.containsKey(programmaALivelli)) {
                        if( (ricaricaSpesaTotaleCliente(attivita) + valoreAcquisto) >
                                programmaALivelli.getLivelli().get(programmaALivelli.getLivelloAttuale()))  //caso in cui con l'acquisto il cliente raggiunge il livello successivo
                        {
                            //il cliente ha raggiunto il livello successivo
                            programmaALivelli.setLivelloAttuale(programmaALivelli.getLivelloAttuale() + 1);
                        }
                    }

                } else if(programmaFedelta instanceof ProgrammaAPunti programmaAPunti) {
                    if(puntiPerAttivitaCommerciale.containsKey(programmaAPunti)) {
                        puntiPerAttivitaCommerciale
                                .put(programmaAPunti, (int)(puntiPerAttivitaCommerciale.get(programmaAPunti) + programmaAPunti.getRapportoPunti() * valoreAcquisto));
                    } else {
                        //caso in cui vanno inseriti punti per questa attività commerciale per la prima volta
                        puntiPerAttivitaCommerciale
                                .put(programmaAPunti, (int)(programmaAPunti.getRapportoPunti() * valoreAcquisto));
                    }

                } else if(programmaFedelta instanceof ProgrammaCashback programmaCashback) {
                    if(saldoPerAttivitaCommerciale.containsKey(programmaCashback)) {
                        saldoPerAttivitaCommerciale
                                .put(programmaCashback, saldoPerAttivitaCommerciale.get(programmaCashback) + programmaCashback.getPercentualeCashback() * valoreAcquisto);
                    } else {
                        saldoPerAttivitaCommerciale
                                .put(programmaCashback, programmaCashback.getPercentualeCashback() * valoreAcquisto);
                    }
                }
            }
        }
    }


    private double ricaricaSpesaTotaleCliente(AttivitaCommercialeController attivitaCommerciale){
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

    private void aggiornaSpesaTotale(AttivitaCommercialeController attivita, double valoreAcquisto) {
        /*
         */
        if(cliente.getSpesaTotalePerAttivitaCommerciale().containsKey(attivita)) {
            cliente.getSpesaTotalePerAttivitaCommerciale().put(attivita, cliente.getSpesaTotalePerAttivitaCommerciale().get(attivita) + valoreAcquisto);
        } else {
            cliente.getSpesaTotalePerAttivitaCommerciale().put(attivita, valoreAcquisto);
        }
    }


    /**
     * Metodi implementati dall'interfaccia Controller
     */

    @Override
    public ClienteModel createCliente(ClienteModel cliente) {
        return null;
    }

    @Override
    public ClienteModel getById(UUID id) {
        return null;
    }

    @Override
    public ClienteModel updateCliente(ClienteModel cliente) {
        return null;
    }

    @Override
    public boolean deleteCliente(ClienteModel clienteModel) {
        return false;
    }
}
