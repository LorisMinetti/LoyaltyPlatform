package it.unicam.cs.ids.LoyaltyPlatform.controller.inbound;

import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaFedeltaModel;

import java.util.List;
import java.util.UUID;

public interface ProgrammaFedeltaController {

    ProgrammaFedeltaModel createProgrammaFedelta(ProgrammaFedeltaModel programmaFedeltaModel);

    ProgrammaFedeltaModel updateProgrammaFedelta(ProgrammaFedeltaModel programmaFedeltaModel);

    boolean deleteProgrammaFedelta(ProgrammaFedeltaModel programmaFedeltaModel);

    ProgrammaFedeltaModel getById(UUID id);

    List<ProgrammaFedeltaModel> findAll();



}
