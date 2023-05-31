package it.unicam.cs.ids.LoyaltyPlatform.repository.inbound;

import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaALivelliModel;

import java.io.IOException;
import java.util.UUID;

public interface ProgrammaALivelliRepository {

    ProgrammaALivelliModel save(ProgrammaALivelliModel programmaALivelliModel);

    ProgrammaALivelliModel update(ProgrammaALivelliModel programmaALivelliModel) throws IOException;

    boolean delete(ProgrammaALivelliModel programmaALivelliModel);

    ProgrammaALivelliModel findById(UUID id);

}
