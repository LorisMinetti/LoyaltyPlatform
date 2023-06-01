package it.unicam.cs.ids.LoyaltyPlatform.controller;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.GestorePiattaformaController;
import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.ProgrammaCashbackController;
import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaCashbackModel;
import it.unicam.cs.ids.LoyaltyPlatform.repository.GestorePiattaformaRepositoryImpl;
import it.unicam.cs.ids.LoyaltyPlatform.repository.ProgrammaCashbackRepositoryImpl;
import it.unicam.cs.ids.LoyaltyPlatform.repository.inbound.GestorePiattaformaRepository;
import it.unicam.cs.ids.LoyaltyPlatform.repository.inbound.ProgrammaCashbackRepository;

import java.util.UUID;

public class ProgrammaCashbackControllerImpl implements ProgrammaCashbackController {

    private final ProgrammaCashbackRepository programmaCashbackRepository;

    public ProgrammaCashbackControllerImpl() {
        this.programmaCashbackRepository = ProgrammaCashbackRepositoryImpl.getInstance();
    }

    /*
     *  Singleton constructor
     */
    private static class SingletonBuilder {
        private static final ProgrammaCashbackController INSTANCE = new ProgrammaCashbackControllerImpl();
    }

    public static ProgrammaCashbackController getInstance() {
        return SingletonBuilder.INSTANCE;
    }

    @Override
    public ProgrammaCashbackModel createProgrammaCashback(ProgrammaCashbackModel programmaCashbackModel) {
        return null;
    }

    @Override
    public ProgrammaCashbackModel updateProgrammaCashback(ProgrammaCashbackModel programmaCashbackModel) {
        return null;
    }

    @Override
    public boolean deleteProgrammaCashback(ProgrammaCashbackModel programmaCashbackModel) {
        return false;
    }

    @Override
    public ProgrammaCashbackModel getById(UUID id) {
        return null;
    }
}
