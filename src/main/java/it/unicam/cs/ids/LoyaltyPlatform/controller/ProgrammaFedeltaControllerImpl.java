package it.unicam.cs.ids.LoyaltyPlatform.controller;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.GestorePiattaformaController;
import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.ProgrammaFedeltaController;
import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaFedeltaModel;
import it.unicam.cs.ids.LoyaltyPlatform.repository.GestorePiattaformaRepositoryImpl;
import it.unicam.cs.ids.LoyaltyPlatform.repository.ProgrammaFedeltaRepositoryImpl;
import it.unicam.cs.ids.LoyaltyPlatform.repository.inbound.GestorePiattaformaRepository;
import it.unicam.cs.ids.LoyaltyPlatform.repository.inbound.ProgrammaFedeltaRepository;

import java.util.UUID;

public class ProgrammaFedeltaControllerImpl implements ProgrammaFedeltaController {

    private final ProgrammaFedeltaRepository programmaFedeltaRepository;

    public ProgrammaFedeltaControllerImpl() {
        this.programmaFedeltaRepository = ProgrammaFedeltaRepositoryImpl.getInstance();
    }

    /*
     *  Singleton constructor
     */
    private static class SingletonBuilder {
        private static final ProgrammaFedeltaController INSTANCE = new ProgrammaFedeltaControllerImpl();
    }

    public static ProgrammaFedeltaController getInstance() {
        return SingletonBuilder.INSTANCE;
    }

    @Override
    public ProgrammaFedeltaModel createProgrammaFedelta(ProgrammaFedeltaModel programmaFedeltaModel) {
        return null;
    }

    @Override
    public ProgrammaFedeltaModel updateProgrammaFedelta(ProgrammaFedeltaModel programmaFedeltaModel) {
        return null;
    }

    @Override
    public boolean deleteProgrammaFedelta(ProgrammaFedeltaModel programmaFedeltaModel) {
        return false;
    }

    @Override
    public ProgrammaFedeltaModel getById(UUID id) {
        return null;
    }
}
