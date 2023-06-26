package it.unicam.cs.ids.LoyaltyPlatform.controller;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.ProgrammaCoalizioneController;
import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaCoalizioneModel;
import it.unicam.cs.ids.LoyaltyPlatform.repository.ProgrammaCoalizioneRepository;

import java.util.List;
import java.util.UUID;

public class ProgrammaCoalizioneControllerImpl implements ProgrammaCoalizioneController {

    private ProgrammaCoalizioneRepository programmaCoalizioneRepository;


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

    @Override
    public List<ProgrammaCoalizioneModel> findAll() {
        return null;
    }

}
