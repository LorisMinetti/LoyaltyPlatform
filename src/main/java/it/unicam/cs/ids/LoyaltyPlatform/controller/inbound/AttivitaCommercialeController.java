package it.unicam.cs.ids.LoyaltyPlatform.controller.inbound;

import it.unicam.cs.ids.LoyaltyPlatform.model.AttivitaCommercialeModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaFedeltaModel;

import java.util.List;
import java.util.UUID;

public interface AttivitaCommercialeController {

    AttivitaCommercialeModel createAttivitaCommerciale(AttivitaCommercialeModel attivitaCommerciale);

    AttivitaCommercialeModel updateAttivitaCommerciale(AttivitaCommercialeModel attivitaCommerciale);

    boolean deleteAttivitaCommerciale(AttivitaCommercialeModel attivitaCommerciale);

    AttivitaCommercialeModel getById(UUID id);

    ProgrammaFedeltaModel aderisciProgrammaFedelta();

    List<ProgrammaFedeltaModel> getAvailablePrograms();

    void selezionaProgrammaFedelta(ProgrammaFedeltaModel programmaFedeltaModel);

}
