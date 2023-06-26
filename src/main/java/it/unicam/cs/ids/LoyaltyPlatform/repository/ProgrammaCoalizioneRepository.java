package it.unicam.cs.ids.LoyaltyPlatform.repository;

import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaCoalizioneModel;

import java.io.IOException;
import java.util.UUID;

public interface ProgrammaCoalizioneRepository {

    ProgrammaCoalizioneModel save(ProgrammaCoalizioneModel programmaCoalizioneModel);

    ProgrammaCoalizioneModel update(ProgrammaCoalizioneModel programmaCoalizioneModel) throws IOException;

    boolean delete(ProgrammaCoalizioneModel programmaCoalizioneModel);

    ProgrammaCoalizioneModel findById(UUID id);

}
