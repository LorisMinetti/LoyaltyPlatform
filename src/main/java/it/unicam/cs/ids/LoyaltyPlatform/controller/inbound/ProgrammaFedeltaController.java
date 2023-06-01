package it.unicam.cs.ids.LoyaltyPlatform.controller.inbound;

import it.unicam.cs.ids.LoyaltyPlatform.model.MessaggioModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaFedeltaModel;

import java.util.UUID;

public interface ProgrammaFedeltaController {

    ProgrammaFedeltaModel createProgrammaFedelta(ProgrammaFedeltaModel programmaFedeltaModel);

    ProgrammaFedeltaModel updateProgrammaFedelta(ProgrammaFedeltaModel programmaFedeltaModel);

    boolean deleteProgrammaFedelta(ProgrammaFedeltaModel programmaFedeltaModel);

    ProgrammaFedeltaModel getById(UUID id);

}
