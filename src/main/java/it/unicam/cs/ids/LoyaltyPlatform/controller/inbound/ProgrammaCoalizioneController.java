package it.unicam.cs.ids.LoyaltyPlatform.controller.inbound;

import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaCashbackModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaCoalizioneModel;

import java.util.UUID;

public interface ProgrammaCoalizioneController {

    ProgrammaCoalizioneModel createProgrammaCoalizione(ProgrammaCoalizioneModel programmaCoalizioneModel);

    ProgrammaCoalizioneModel updateProgrammaCoalizione(ProgrammaCoalizioneModel programmaCoalizioneModel);

    boolean deleteProgrammaCoalizione(ProgrammaCoalizioneModel programmaCoalizioneModel);

    ProgrammaCoalizioneModel getById(UUID id);

}
