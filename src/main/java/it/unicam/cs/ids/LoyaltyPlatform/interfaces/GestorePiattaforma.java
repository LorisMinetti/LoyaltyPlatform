package it.unicam.cs.ids.LoyaltyPlatform.interfaces;

import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaFedelta;

import java.util.List;

public interface GestorePiattaforma {
    ProgrammaFedelta aggiungiProgrammaFedelta();

    List<ProgrammaFedelta> getAllProgrammiFedelta();
    void selezionaProgrammaFedelta(ProgrammaFedelta programmaFedelta);
}
