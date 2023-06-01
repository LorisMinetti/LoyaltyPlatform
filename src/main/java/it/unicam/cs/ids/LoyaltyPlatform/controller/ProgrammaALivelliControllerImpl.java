package it.unicam.cs.ids.LoyaltyPlatform.controller;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.GestorePiattaformaController;
import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.ProgrammaALivelliController;
import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaALivelliModel;
import it.unicam.cs.ids.LoyaltyPlatform.repository.GestorePiattaformaRepositoryImpl;
import it.unicam.cs.ids.LoyaltyPlatform.repository.ProgrammaALivelliRepositoryImpl;
import it.unicam.cs.ids.LoyaltyPlatform.repository.inbound.GestorePiattaformaRepository;
import it.unicam.cs.ids.LoyaltyPlatform.repository.inbound.ProgrammaALivelliRepository;

import java.util.UUID;

public class ProgrammaALivelliControllerImpl implements ProgrammaALivelliController {

    private final ProgrammaALivelliRepository programmaALivelliRepository;

    public ProgrammaALivelliControllerImpl() {
        this.programmaALivelliRepository = ProgrammaALivelliRepositoryImpl.getInstance();
    }

    /*
     *  Singleton constructor
     */
    private static class SingletonBuilder {
        private static final ProgrammaALivelliController INSTANCE = new ProgrammaALivelliControllerImpl();
    }

    public static ProgrammaALivelliController getInstance() {
        return SingletonBuilder.INSTANCE;
    }

    @Override
    public ProgrammaALivelliModel createProgrammaALivelli(ProgrammaALivelliModel programmaALivelliModel) {
        return null;
    }

    @Override
    public ProgrammaALivelliModel updateProgrammaALivelli(ProgrammaALivelliModel programmaALivelliModel) {
        return null;
    }

    @Override
    public boolean deleteProgrammaALivelli(ProgrammaALivelliModel programmaALivelliModel) {
        return false;
    }

    @Override
    public ProgrammaALivelliModel getById(UUID id) {
        return null;
    }
}
