package it.unicam.cs.ids.LoyaltyPlatform.controller.inbound;

import it.unicam.cs.ids.LoyaltyPlatform.model.AttivitaCommercialeModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaFedeltaModel;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface AttivitaCommercialeController {

    AttivitaCommercialeModel createAttivitaCommerciale(AttivitaCommercialeModel attivitaCommerciale);

    AttivitaCommercialeModel updateAttivitaCommerciale(AttivitaCommercialeModel attivitaCommerciale);

    boolean deleteAttivitaCommerciale(AttivitaCommercialeModel attivitaCommerciale);

    AttivitaCommercialeModel getById(UUID id);

    List<AttivitaCommercialeModel> findAll();

    ProgrammaFedeltaModel aderisciProgrammaFedelta();

    Set<ProgrammaFedeltaModel> getAvailablePrograms(AttivitaCommercialeModel attivitaCommercialeModel);

    void selezionaProgrammaFedelta(AttivitaCommercialeModel attivitaCommercialeModel, ProgrammaFedeltaModel programmaFedeltaModel);

}
