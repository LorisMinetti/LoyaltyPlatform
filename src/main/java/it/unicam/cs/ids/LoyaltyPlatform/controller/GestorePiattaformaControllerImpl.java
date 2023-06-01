package it.unicam.cs.ids.LoyaltyPlatform.controller;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.ClienteController;
import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.GestorePiattaformaController;
import it.unicam.cs.ids.LoyaltyPlatform.model.GestorePiattaformaModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaFedeltaModel;
import it.unicam.cs.ids.LoyaltyPlatform.repository.GestorePiattaformaRepositoryImpl;
import it.unicam.cs.ids.LoyaltyPlatform.repository.inbound.GestorePiattaformaRepository;

import java.util.List;
import java.util.UUID;

public class GestorePiattaformaControllerImpl implements GestorePiattaformaController {

    private final GestorePiattaformaRepository gestorePiattaformaRepository;

    public GestorePiattaformaControllerImpl() {
        this.gestorePiattaformaRepository = GestorePiattaformaRepositoryImpl.getInstance();
    }

    /*
     *  Singleton constructor
     */
    private static class SingletonBuilder {
        private static final GestorePiattaformaController INSTANCE = new GestorePiattaformaControllerImpl();
    }

    public static GestorePiattaformaController getInstance() {
        return SingletonBuilder.INSTANCE;
    }

    @Override
    public ProgrammaFedeltaModel aggiungiProgrammaFedelta() {
        return null;
    }

    @Override
    public List<ProgrammaFedeltaModel> getAllProgrammiFedelta() {
        return null;
    }

    @Override
    public void selezionaProgrammaFedelta(ProgrammaFedeltaModel programmaFedeltaModel) {

    }

    @Override
    public GestorePiattaformaModel createGestorePiattaforma(GestorePiattaformaModel gestorePiattaforma) {
        return null;
    }

    @Override
    public GestorePiattaformaModel updateGestorePiattaforma(GestorePiattaformaModel gestorePiattaforma) {
        return null;
    }

    @Override
    public boolean deleteGestorePiattaforma(GestorePiattaformaModel gestorePiattaforma) {
        return false;
    }

    @Override
    public GestorePiattaformaModel getById(UUID id) {
        return null;
    }
}
