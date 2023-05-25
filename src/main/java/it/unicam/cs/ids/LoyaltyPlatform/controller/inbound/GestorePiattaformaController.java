package it.unicam.cs.ids.LoyaltyPlatform.controller.inbound;

import it.unicam.cs.ids.LoyaltyPlatform.model.GestorePiattaformaModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaFedelta;

import java.util.List;
import java.util.UUID;

public interface GestorePiattaformaController {

    GestorePiattaformaModel createGestorePiattaforma(GestorePiattaformaModel gestorePiattaforma);

    GestorePiattaformaModel updateGestorePiattaforma(GestorePiattaformaModel gestorePiattaforma);

    boolean deleteGestorePiattaforma(GestorePiattaformaModel gestorePiattaforma);

    GestorePiattaformaModel getById(UUID id);

    ProgrammaFedelta aggiungiProgrammaFedelta();

    List<ProgrammaFedelta> getAllProgrammiFedelta();

    void selezionaProgrammaFedelta(ProgrammaFedelta programmaFedelta);

}
