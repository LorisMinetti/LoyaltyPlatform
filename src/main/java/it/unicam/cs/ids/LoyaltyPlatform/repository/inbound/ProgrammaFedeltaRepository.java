package it.unicam.cs.ids.LoyaltyPlatform.repository.inbound;

import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaFedeltaModel;

import java.io.IOException;
import java.util.UUID;

public interface ProgrammaFedeltaRepository {

    ProgrammaFedeltaModel save(ProgrammaFedeltaModel programmaFedeltaModel);

    ProgrammaFedeltaModel update(ProgrammaFedeltaModel programmaFedeltaModel) throws IOException;

    boolean delete(ProgrammaFedeltaModel programmaFedeltaModel);

    ProgrammaFedeltaModel findById(UUID id);

}
