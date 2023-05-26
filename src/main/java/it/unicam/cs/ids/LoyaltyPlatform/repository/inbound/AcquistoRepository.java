package it.unicam.cs.ids.LoyaltyPlatform.repository.inbound;

import it.unicam.cs.ids.LoyaltyPlatform.model.AcquistoModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.ClienteModel;

import java.io.IOException;
import java.util.UUID;

public interface AcquistoRepository {

    AcquistoModel save(AcquistoModel acquistoModel);

    AcquistoModel update(AcquistoModel acquistoModel) throws IOException;

    boolean delete(AcquistoModel acquistoModel);

    AcquistoModel findById(UUID id);

}
