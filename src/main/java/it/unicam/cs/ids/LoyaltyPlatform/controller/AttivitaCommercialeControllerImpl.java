package it.unicam.cs.ids.LoyaltyPlatform.controller;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.AttivitaCommercialeController;
import it.unicam.cs.ids.LoyaltyPlatform.model.AttivitaCommercialeModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaFedelta;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

public class AttivitaCommercialeControllerImpl implements AttivitaCommercialeController {

    private final AttivitaCommercialeModel attivitaCommercialeModel;

    public AttivitaCommercialeControllerImpl(AttivitaCommercialeModel attivitaCommercialeModel) {
        this.attivitaCommercialeModel = attivitaCommercialeModel;
    }

    @Override
    public ProgrammaFedelta aderisciProgrammaFedelta() {
        return null;
    }

    @Override
    public List<ProgrammaFedelta> getAvailablePrograms() {
        if(attivitaCommercialeModel.getProgrammiFedeltaAderiti().isEmpty()){
            return null;
        } else {
            return attivitaCommercialeModel.getProgrammiFedeltaAderiti();
        }
    }

    @Override
    public void selezionaProgrammaFedelta(ProgrammaFedelta programmaFedelta) {
        if(programmaFedelta != null && !attivitaCommercialeModel.getProgrammiFedeltaAderiti().contains(programmaFedelta)) {
            attivitaCommercialeModel.getProgrammiFedeltaAderiti().add(programmaFedelta);
        } else {
            throw new IllegalArgumentException("Programma fedeltà non valido");
        }
    }

    @Override
    public AttivitaCommercialeModel createAttivitaCommerciale(AttivitaCommercialeModel attivitaCommerciale) {
        return null;
    }

    @Override
    public AttivitaCommercialeModel updateAttivitaCommerciale(AttivitaCommercialeModel attivitaCommerciale) {
        return null;
    }

    @Override
    public boolean deleteAttivitaCommerciale(AttivitaCommercialeModel attivitaCommerciale) {
        return false;
    }

    @Override
    public AttivitaCommercialeModel getById(UUID id) {
        return null;
    }

}
