package it.unicam.cs.ids.LoyaltyPlatform.repository.inbound;

import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaAPuntiModel;

import java.util.UUID;

public interface ProgrammaAPuntiRepository {

    ProgrammaAPuntiModel save(ProgrammaAPuntiModel programmaAPuntiModel);

    ProgrammaAPuntiModel update(ProgrammaAPuntiModel programmaAPuntiModel);

    boolean delete(ProgrammaAPuntiModel programmaAPuntiModel);

    ProgrammaAPuntiModel findById(UUID id);

}
