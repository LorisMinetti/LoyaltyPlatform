package it.unicam.cs.ids.LoyaltyPlatform.controller;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.AcquistoController;
import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.GestorePiattaformaController;
import it.unicam.cs.ids.LoyaltyPlatform.model.AcquistoModel;
import it.unicam.cs.ids.LoyaltyPlatform.repository.AcquistoRepositoryImpl;
import it.unicam.cs.ids.LoyaltyPlatform.repository.GestorePiattaformaRepositoryImpl;
import it.unicam.cs.ids.LoyaltyPlatform.repository.inbound.AcquistoRepository;
import it.unicam.cs.ids.LoyaltyPlatform.repository.inbound.GestorePiattaformaRepository;

import java.util.UUID;

public class AcquistoControllerImpl implements AcquistoController {

    private final AcquistoRepository acquistoRepository;

    public AcquistoControllerImpl() {
        this.acquistoRepository = AcquistoRepositoryImpl.getInstance();
    }

    /*
     *  Singleton constructor
     */
    private static class SingletonBuilder {
        private static final AcquistoController INSTANCE = new AcquistoControllerImpl();
    }

    public static AcquistoController getInstance() {
        return SingletonBuilder.INSTANCE;
    }

    @Override
    public AcquistoModel createAcquisto(AcquistoModel acquistoModel) {
        return null;
    }

    @Override
    public AcquistoModel updateAcquisto(AcquistoModel acquistoModel) {
        return null;
    }

    @Override
    public boolean deleteAcquisto(AcquistoModel acquistoModel) {
        return false;
    }

    @Override
    public AcquistoModel getById(UUID id) {
        return null;
    }
}
