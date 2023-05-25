package it.unicam.cs.ids.LoyaltyPlatform.controller;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.GestorePiattaformaController;
import it.unicam.cs.ids.LoyaltyPlatform.model.GestorePiattaformaModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaFedelta;

import java.util.List;
import java.util.UUID;

public class GestorePiattaformaControllerImpl implements GestorePiattaformaController {

    private GestorePiattaformaModel gestorePiattaforma;

    @Override
    public ProgrammaFedelta aggiungiProgrammaFedelta() {
        return null;
    }

    @Override
    public List<ProgrammaFedelta> getAllProgrammiFedelta() {
        return null;
    }

    @Override
    public void selezionaProgrammaFedelta(ProgrammaFedelta programmaFedelta) {

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
