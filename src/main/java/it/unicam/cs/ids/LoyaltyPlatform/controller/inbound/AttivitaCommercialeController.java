package it.unicam.cs.ids.LoyaltyPlatform.controller.inbound;

import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaFedelta;

import java.util.List;

public interface AttivitaCommercialeController {
    ProgrammaFedelta aderisciProgrammaFedelta();
    List<ProgrammaFedelta> getAvailablePrograms();
    void selezionaProgrammaFedelta(ProgrammaFedelta programmaFedelta);
}
