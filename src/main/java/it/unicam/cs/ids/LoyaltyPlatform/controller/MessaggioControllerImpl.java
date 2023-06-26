package it.unicam.cs.ids.LoyaltyPlatform.controller;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.MessaggioController;
import it.unicam.cs.ids.LoyaltyPlatform.model.MessaggioModel;
import it.unicam.cs.ids.LoyaltyPlatform.repository.MessaggioRepository;

import java.util.UUID;

public class MessaggioControllerImpl implements MessaggioController {

    private MessaggioRepository messaggioRepository;


    @Override
    public MessaggioModel createMessaggio(MessaggioModel messaggioModel) {
        return null;
    }

    @Override
    public MessaggioModel updateMessaggio(MessaggioModel messaggioModel) {
        return null;
    }

    @Override
    public boolean deleteMessaggio(MessaggioModel messaggioModel) {
        return false;
    }

    @Override
    public MessaggioModel getById(UUID id) {
        return null;
    }
}
