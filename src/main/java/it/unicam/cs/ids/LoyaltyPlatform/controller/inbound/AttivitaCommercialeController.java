package it.unicam.cs.ids.LoyaltyPlatform.controller.inbound;

import it.unicam.cs.ids.LoyaltyPlatform.model.AttivitaCommercialeModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaFedelta;

import java.util.List;
import java.util.UUID;

public interface AttivitaCommercialeController {

    AttivitaCommercialeModel createAttivitaCommerciale(AttivitaCommercialeModel attivitaCommerciale);

    AttivitaCommercialeModel updateAttivitaCommerciale(AttivitaCommercialeModel attivitaCommerciale);

    boolean deleteAttivitaCommerciale(AttivitaCommercialeModel attivitaCommerciale);

    AttivitaCommercialeModel getById(UUID id);

    ProgrammaFedelta aderisciProgrammaFedelta();

    List<ProgrammaFedelta> getAvailablePrograms();

    void selezionaProgrammaFedelta(ProgrammaFedelta programmaFedelta);

}
