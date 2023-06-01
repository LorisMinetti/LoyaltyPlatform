package it.unicam.cs.ids.LoyaltyPlatform.controller;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.GestorePiattaformaController;
import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.MessaggioController;
import it.unicam.cs.ids.LoyaltyPlatform.model.MessaggioModel;
import it.unicam.cs.ids.LoyaltyPlatform.repository.GestorePiattaformaRepositoryImpl;
import it.unicam.cs.ids.LoyaltyPlatform.repository.MessaggioRepositoryImpl;
import it.unicam.cs.ids.LoyaltyPlatform.repository.inbound.GestorePiattaformaRepository;
import it.unicam.cs.ids.LoyaltyPlatform.repository.inbound.MessaggioRepository;

import java.util.UUID;

public class MessaggioControllerImpl implements MessaggioController {

    private final MessaggioRepository messaggioRepository;

    public MessaggioControllerImpl() {
        this.messaggioRepository = MessaggioRepositoryImpl.getInstance();
    }

    /*
     *  Singleton constructor
     */
    private static class SingletonBuilder {
        private static final MessaggioController INSTANCE = new MessaggioControllerImpl();
    }

    public static MessaggioController getInstance() {
        return SingletonBuilder.INSTANCE;
    }

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
