package it.unicam.cs.ids.LoyaltyPlatform.controller.inbound;

import it.unicam.cs.ids.LoyaltyPlatform.Coalizzabile;
import it.unicam.cs.ids.LoyaltyPlatform.model.AdesioneProgrammaFedeltaModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.AttivitaCommercialeModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.CoalizioneModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaFedeltaModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.subModel.request.AdesioneProgrammaFedeltaRequest;
import it.unicam.cs.ids.LoyaltyPlatform.model.subModel.request.CoalizioneRequest;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface AttivitaCommercialeController extends Coalizzabile {

    AttivitaCommercialeModel createAttivitaCommerciale(AttivitaCommercialeModel attivitaCommerciale);

    AttivitaCommercialeModel updateAttivitaCommerciale(AttivitaCommercialeModel attivitaCommerciale);

    boolean deleteAttivitaCommerciale(AttivitaCommercialeModel attivitaCommerciale);

    AttivitaCommercialeModel getById(UUID id);

    List<AttivitaCommercialeModel> findAll();

    /**
     * Adesione di un'attivitaCommerciale a un programma fedeltà
     * @param adesioneProgrammaFedeltaRequest
     * @return l'adesione effettuata
     */
    AdesioneProgrammaFedeltaModel aderisciProgrammaFedelta(AdesioneProgrammaFedeltaRequest adesioneProgrammaFedeltaRequest);

    /**
     * Restituisce i programmi fedeltà selezionabili per l'attività commerciale
     * @param attivitaCommercialeModel
     * @return
     */
    Set<ProgrammaFedeltaModel> getAvailablePrograms(AttivitaCommercialeModel attivitaCommercialeModel);

    /**
     * Permette di disdire un'adesione a un programma fedeltà che perdurerà fino alla fine della dataScadenza
     */
    Boolean disdiciAdesione(AdesioneProgrammaFedeltaModel adesione);


    CoalizioneModel richiediCoalizzazione(CoalizioneRequest request);
}
