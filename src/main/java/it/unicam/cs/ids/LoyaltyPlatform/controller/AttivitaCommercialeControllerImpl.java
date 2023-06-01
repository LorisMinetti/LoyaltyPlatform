package it.unicam.cs.ids.LoyaltyPlatform.controller;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.AttivitaCommercialeController;
import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.ClienteController;
import it.unicam.cs.ids.LoyaltyPlatform.model.AttivitaCommercialeModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaFedeltaModel;
import it.unicam.cs.ids.LoyaltyPlatform.repository.AttivitaCommercialeRepositoryImpl;
import it.unicam.cs.ids.LoyaltyPlatform.repository.inbound.AttivitaCommercialeRepository;

import java.util.List;
import java.util.UUID;

public class AttivitaCommercialeControllerImpl implements AttivitaCommercialeController {

    private final AttivitaCommercialeRepository attivitaCommercialeRepository;

    public AttivitaCommercialeControllerImpl() {
        this.attivitaCommercialeRepository = AttivitaCommercialeRepositoryImpl.getInstance();
    }

    /*
     *  Singleton constructor
     */
    private static class SingletonBuilder {
        private static final AttivitaCommercialeController INSTANCE = new AttivitaCommercialeControllerImpl();
    }

    public static AttivitaCommercialeController getInstance() {
        return SingletonBuilder.INSTANCE;
    }

    @Override
    public ProgrammaFedeltaModel aderisciProgrammaFedelta() {
        return null;
    }

    @Override
    public List<ProgrammaFedeltaModel> getAvailablePrograms(AttivitaCommercialeModel attivitaCommercialeModel) {
        if(attivitaCommercialeModel.getProgrammiFedeltaAderiti().isEmpty()){
            return null;
        } else {
            return attivitaCommercialeModel.getProgrammiFedeltaAderiti();
        }
    }

    @Override
    public void selezionaProgrammaFedelta(AttivitaCommercialeModel attivitaCommercialeModel, ProgrammaFedeltaModel programmaFedeltaModel) {
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
            return attivitaCommercialeRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
