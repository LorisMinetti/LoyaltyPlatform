package it.unicam.cs.ids.LoyaltyPlatform.controller;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.AttivitaCommercialeController;
import it.unicam.cs.ids.LoyaltyPlatform.model.AttivitaCommercialeModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaFedeltaModel;
import it.unicam.cs.ids.LoyaltyPlatform.repository.AttivitaCommercialeRepositoryImpl;
import it.unicam.cs.ids.LoyaltyPlatform.repository.inbound.AttivitaCommercialeRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.UUID;

@Slf4j
public class AttivitaCommercialeControllerImpl implements AttivitaCommercialeController {

    private final AttivitaCommercialeRepository attivitaCommercialeRepository;

    public AttivitaCommercialeControllerImpl() {
        this.attivitaCommercialeRepository = AttivitaCommercialeRepositoryImpl.getInstance();
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
        if(attivitaCommerciale.getId() != null){
            throw new IllegalArgumentException("Non è possibile creare un cliente con un ID già esistente");
        }

        log.debug("Creazione nuova attivita" + attivitaCommerciale.getNome());
        AttivitaCommercialeModel result = null;

        //TODO: eliminare questa riga quando sarà implementato il metodo di generazione automatica dell'ID
        attivitaCommerciale.setId(UUID.randomUUID());

        try{
            result = attivitaCommercialeRepository.save(attivitaCommerciale);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;    }

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
