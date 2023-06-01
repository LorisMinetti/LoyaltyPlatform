package it.unicam.cs.ids.LoyaltyPlatform.controller;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.AttivitaCommercialeController;
import it.unicam.cs.ids.LoyaltyPlatform.model.AttivitaCommercialeModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaFedeltaModel;

import java.util.List;
import java.util.UUID;

public class AttivitaCommercialeControllerImpl implements AttivitaCommercialeController {

    private AttivitaCommercialeModel attivitaCommercialeModel;

    private final AttivitaCommercialeRepositoryImpl attivitaCommercialeRepositoryImpl;

    public AttivitaCommercialeControllerImpl() {
        this.attivitaCommercialeRepositoryImpl = AttivitaCommercialeRepositoryImpl.getInstance();
    }

    @Override
    public ProgrammaFedeltaModel aderisciProgrammaFedelta() {
        return null;
    }

    @Override
    public List<ProgrammaFedeltaModel> getAvailablePrograms() {
        if(attivitaCommercialeModel.getProgrammiFedeltaAderiti().isEmpty()){
            return null;
        } else {
            return attivitaCommercialeModel.getProgrammiFedeltaAderiti();
        }
    }

    @Override
    public void selezionaProgrammaFedelta(ProgrammaFedeltaModel programmaFedeltaModel) {
        if(programmaFedeltaModel != null && !attivitaCommercialeModel.getProgrammiFedeltaAderiti().contains(programmaFedeltaModel)) {
            attivitaCommercialeModel.getProgrammiFedeltaAderiti().add(programmaFedeltaModel);
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
        try{
            return attivitaCommercialeRepositoryImpl.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
