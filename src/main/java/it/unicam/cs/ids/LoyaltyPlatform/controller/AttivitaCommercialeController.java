package it.unicam.cs.ids.LoyaltyPlatform.controller;

import it.unicam.cs.ids.LoyaltyPlatform.interfaces.AttivitaCommerciale;
import it.unicam.cs.ids.LoyaltyPlatform.model.AttivitaCommercialeModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaFedelta;

import java.util.List;

public class AttivitaCommercialeController implements AttivitaCommerciale {

    private final AttivitaCommercialeModel attivitaCommercialeModel;

    public AttivitaCommercialeController(AttivitaCommercialeModel attivitaCommercialeModel) {
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
}
