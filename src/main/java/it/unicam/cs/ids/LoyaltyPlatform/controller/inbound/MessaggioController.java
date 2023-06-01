package it.unicam.cs.ids.LoyaltyPlatform.controller.inbound;

import it.unicam.cs.ids.LoyaltyPlatform.model.AcquistoModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.MessaggioModel;

import java.util.UUID;

public interface MessaggioController {

    MessaggioModel createMessaggio(MessaggioModel messaggioModel);

    MessaggioModel updateMessaggio(MessaggioModel messaggioModel);

    boolean deleteMessaggio(MessaggioModel messaggioModel);

    MessaggioModel getById(UUID id);

}
