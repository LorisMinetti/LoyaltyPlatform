package it.unicam.cs.ids.LoyaltyPlatform.interfaces;

import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaFedelta;

import java.util.List;

public interface AttivitaCommerciale {
    ProgrammaFedelta aderisciProgrammaFedelta();
    List<ProgrammaFedelta> getAvailablePrograms();
    void selezionaProgrammaFedelta(ProgrammaFedelta programmaFedelta);
}
