package it.unicam.cs.ids.LoyaltyPlatform.controller.inbound;

import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaCashbackModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaFedeltaModel;

import java.util.UUID;

public interface ProgrammaCashbackController {

    ProgrammaCashbackModel createProgrammaCashback(ProgrammaCashbackModel programmaCashbackModel);

    ProgrammaCashbackModel updateProgrammaCashback(ProgrammaCashbackModel programmaCashbackModel);

    boolean deleteProgrammaCashback(ProgrammaCashbackModel programmaCashbackModel);

    ProgrammaCashbackModel getById(UUID id);

}
