package it.unicam.cs.ids.LoyaltyPlatform.controller;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.ProgrammaCashbackController;
import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaCashbackModel;
import it.unicam.cs.ids.LoyaltyPlatform.repository.ProgrammaCashbackRepositoryImpl;
import it.unicam.cs.ids.LoyaltyPlatform.repository.inbound.ProgrammaCashbackRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;


@Slf4j
public class ProgrammaCashbackControllerImpl implements ProgrammaCashbackController {

    private final ProgrammaCashbackRepository programmaCashbackRepository;

    public ProgrammaCashbackControllerImpl() {
        this.programmaCashbackRepository = ProgrammaCashbackRepositoryImpl.getInstance();
    }

    /*
     *  Singleton constructor
     */
    private static class SingletonBuilder {
        private static final ProgrammaCashbackController INSTANCE = new ProgrammaCashbackControllerImpl();
    }

    public static ProgrammaCashbackController getInstance() {
        return SingletonBuilder.INSTANCE;
    }

    @Override
    public ProgrammaCashbackModel createProgrammaCashback(ProgrammaCashbackModel programmaCashbackModel) {
        if(programmaCashbackModel.getId() != null){
            throw new IllegalArgumentException("Non è possibile creare un programmaCashback con un ID già esistente");
        }

        log.debug("Creazione nuovo ProgrammaCashback dalla percentuale: " + programmaCashbackModel.getPercentualeCashback() + " e con la spesa minima di: " + programmaCashbackModel.getSpesaMinima());
        ProgrammaCashbackModel result = null;

        //TODO: eliminare questa riga quando sarà implementato il metodo di generazione automatica dell'ID
        programmaCashbackModel.setId(UUID.randomUUID());

        try{
            result = programmaCashbackRepository.save(programmaCashbackModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ProgrammaCashbackModel updateProgrammaCashback(ProgrammaCashbackModel programmaCashbackModel) {
        return null;
    }

    @Override
    public boolean deleteProgrammaCashback(ProgrammaCashbackModel programmaCashbackModel) {
        return false;
    }

    @Override
    public ProgrammaCashbackModel getById(UUID id) {
        return null;
    }
}
