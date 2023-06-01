package it.unicam.cs.ids.LoyaltyPlatform.controller.inbound;

import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaALivelliModel;

import java.util.UUID;

public interface ProgrammaALivelliController {

    ProgrammaALivelliModel createProgrammaALivelli(ProgrammaALivelliModel programmaALivelliModel);

    ProgrammaALivelliModel updateProgrammaALivelli(ProgrammaALivelliModel programmaALivelliModel);

    boolean deleteProgrammaALivelli(ProgrammaALivelliModel programmaALivelliModel);

    ProgrammaALivelliModel getById(UUID id);

}
