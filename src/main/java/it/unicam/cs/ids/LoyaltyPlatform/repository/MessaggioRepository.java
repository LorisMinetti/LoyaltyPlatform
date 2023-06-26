package it.unicam.cs.ids.LoyaltyPlatform.repository;

import it.unicam.cs.ids.LoyaltyPlatform.model.MessaggioModel;

import java.io.IOException;
import java.util.UUID;

public interface MessaggioRepository {

    MessaggioModel save(MessaggioModel messaggioModel);

    MessaggioModel update(MessaggioModel messaggioModel) throws IOException;

    boolean delete(MessaggioModel messaggioModel);

    MessaggioModel findById(UUID id);

}
