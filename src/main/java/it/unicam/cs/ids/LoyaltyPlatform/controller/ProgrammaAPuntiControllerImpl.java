package it.unicam.cs.ids.LoyaltyPlatform.controller;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.GestorePiattaformaController;
import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.ProgrammaAPuntiController;
import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaAPuntiModel;
import it.unicam.cs.ids.LoyaltyPlatform.repository.GestorePiattaformaRepositoryImpl;
import it.unicam.cs.ids.LoyaltyPlatform.repository.ProgrammaAPuntiRepositoryImpl;
import it.unicam.cs.ids.LoyaltyPlatform.repository.inbound.GestorePiattaformaRepository;
import it.unicam.cs.ids.LoyaltyPlatform.repository.inbound.ProgrammaAPuntiRepository;

import java.util.UUID;

public class ProgrammaAPuntiControllerImpl implements ProgrammaAPuntiController {

    private final ProgrammaAPuntiRepository programmaAPuntiRepository;

    public ProgrammaAPuntiControllerImpl() {
        this.programmaAPuntiRepository = ProgrammaAPuntiRepositoryImpl.getInstance();
    }

    /*
     *  Singleton constructor
     */
    private static class SingletonBuilder {
        private static final ProgrammaAPuntiController INSTANCE = new ProgrammaAPuntiControllerImpl();
    }

    public static ProgrammaAPuntiController getInstance() {
        return SingletonBuilder.INSTANCE;
    }

    @Override
    public ProgrammaAPuntiModel createProgrammaAPunti(ProgrammaAPuntiModel programmaAPuntiModel) {
        return null;
    }

    @Override
    public ProgrammaAPuntiModel updateProgrammaAPunti(ProgrammaAPuntiModel programmaAPuntiModel) {
        return null;
    }

    @Override
    public boolean deleteProgrammaAPunti(ProgrammaAPuntiModel programmaAPuntiModel) {
        return false;
    }

    @Override
    public ProgrammaAPuntiModel getById(UUID id) {
        return null;
    }
}
