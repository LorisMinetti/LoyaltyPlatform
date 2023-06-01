package it.unicam.cs.ids.LoyaltyPlatform.repository.inbound;

import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaCashbackModel;

import java.io.IOException;
import java.util.UUID;

public interface ProgrammaCashbackRepository {

    ProgrammaCashbackModel save(ProgrammaCashbackModel programmaCashbackModel);

    ProgrammaCashbackModel update(ProgrammaCashbackModel programmaCashbackModel) throws IOException;

    boolean delete(ProgrammaCashbackModel programmaCashbackModel);

    ProgrammaCashbackModel findById(UUID id);

}
