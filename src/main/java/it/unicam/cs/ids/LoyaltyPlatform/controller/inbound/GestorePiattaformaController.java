package it.unicam.cs.ids.LoyaltyPlatform.controller.inbound;

import it.unicam.cs.ids.LoyaltyPlatform.model.GestorePiattaformaModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaFedeltaModel;

import java.util.List;
import java.util.UUID;

public interface GestorePiattaformaController {

    GestorePiattaformaModel createGestorePiattaforma(GestorePiattaformaModel gestorePiattaforma);

    GestorePiattaformaModel updateGestorePiattaforma(GestorePiattaformaModel gestorePiattaforma);

    boolean deleteGestorePiattaforma(GestorePiattaformaModel gestorePiattaforma);

    GestorePiattaformaModel getById(UUID id);

    List<GestorePiattaformaModel> findAll();

    ProgrammaFedeltaModel aggiungiProgrammaFedelta(ProgrammaFedeltaModel programmaFedeltaModel);

    boolean rimuoviProgrammaFedelta(ProgrammaFedeltaModel programmaFedeltaModel);

    List<ProgrammaFedeltaModel> getAllProgrammiFedelta();

    boolean rendiDisponibile(ProgrammaFedeltaModel dto);

}
