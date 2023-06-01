package it.unicam.cs.ids.LoyaltyPlatform.controller;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.ProgrammaCashbackController;
import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.ProgrammaCoalizioneController;
import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaCoalizioneModel;
import it.unicam.cs.ids.LoyaltyPlatform.repository.ProgrammaCashbackRepositoryImpl;
import it.unicam.cs.ids.LoyaltyPlatform.repository.ProgrammaCoalizioneRepositoryImpl;
import it.unicam.cs.ids.LoyaltyPlatform.repository.inbound.ProgrammaCashbackRepository;
import it.unicam.cs.ids.LoyaltyPlatform.repository.inbound.ProgrammaCoalizioneRepository;

import java.util.UUID;

public class ProgrammaCoalizioneControllerImpl implements ProgrammaCoalizioneController {

    private final ProgrammaCoalizioneRepository programmaCoalizioneRepository;

    public ProgrammaCoalizioneControllerImpl() {
        this.programmaCoalizioneRepository = ProgrammaCoalizioneRepositoryImpl.getInstance();
    }

    /*
     *  Singleton constructor
     */
    private static class SingletonBuilder {
        private static final ProgrammaCoalizioneController INSTANCE = new ProgrammaCoalizioneControllerImpl();
    }

    public static ProgrammaCoalizioneController getInstance() {
        return SingletonBuilder.INSTANCE;
    }

    @Override
    public ProgrammaCoalizioneModel createProgrammaCoalizione(ProgrammaCoalizioneModel programmaCoalizioneModel) {
        return null;
    }

    @Override
    public ProgrammaCoalizioneModel updateProgrammaCoalizione(ProgrammaCoalizioneModel programmaCoalizioneModel) {
        return null;
    }

    @Override
    public boolean deleteProgrammaCoalizione(ProgrammaCoalizioneModel programmaCoalizioneModel) {
        return false;
    }

    @Override
    public ProgrammaCoalizioneModel getById(UUID id) {
        return null;
    }

}
