package it.unicam.cs.ids.LoyaltyPlatform.controller.inbound;

import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaAPuntiModel;

import java.util.List;
import java.util.UUID;

public interface ProgrammaAPuntiController {

    ProgrammaAPuntiModel createProgrammaAPunti(ProgrammaAPuntiModel programmaAPuntiModel);

    ProgrammaAPuntiModel updateProgrammaAPunti(ProgrammaAPuntiModel programmaAPuntiModel);

    boolean deleteProgrammaAPunti(ProgrammaAPuntiModel programmaAPuntiModel);

    ProgrammaAPuntiModel getById(UUID id);

    List<ProgrammaAPuntiModel> findAll();


}
