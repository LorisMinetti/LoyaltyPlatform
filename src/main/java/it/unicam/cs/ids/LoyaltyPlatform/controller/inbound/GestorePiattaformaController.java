package it.unicam.cs.ids.LoyaltyPlatform.controller.inbound;

import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaFedelta;

import java.util.List;

public interface GestorePiattaformaController {
    ProgrammaFedelta aggiungiProgrammaFedelta();

    List<ProgrammaFedelta> getAllProgrammiFedelta();
    void selezionaProgrammaFedelta(ProgrammaFedelta programmaFedelta);
}
