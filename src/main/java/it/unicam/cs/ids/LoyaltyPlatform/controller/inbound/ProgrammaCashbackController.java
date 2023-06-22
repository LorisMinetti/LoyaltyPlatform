package it.unicam.cs.ids.LoyaltyPlatform.controller.inbound;

import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaCashbackModel;

import java.util.List;
import java.util.UUID;

public interface ProgrammaCashbackController {

    ProgrammaCashbackModel createProgrammaCashback(ProgrammaCashbackModel programmaCashbackModel);

    ProgrammaCashbackModel updateProgrammaCashback(ProgrammaCashbackModel programmaCashbackModel);

    boolean deleteProgrammaCashback(ProgrammaCashbackModel programmaCashbackModel);

    ProgrammaCashbackModel getById(UUID id);

    List<ProgrammaCashbackModel> findAll();


}
