package it.unicam.cs.ids.LoyaltyPlatform.controller;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.AcquistoController;
import it.unicam.cs.ids.LoyaltyPlatform.model.AcquistoModel;
import it.unicam.cs.ids.LoyaltyPlatform.repository.AcquistoRepositoryImpl;
import it.unicam.cs.ids.LoyaltyPlatform.repository.inbound.AcquistoRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
public class AcquistoControllerImpl implements AcquistoController {

    private final AcquistoRepository acquistoRepository;

    public AcquistoControllerImpl() {
        this.acquistoRepository = AcquistoRepositoryImpl.getInstance();
    }

    /*
     *  Singleton constructor
     */
    private static class SingletonBuilder {
        private static final AcquistoController INSTANCE = new AcquistoControllerImpl();
    }

    public static AcquistoController getInstance() {
        return SingletonBuilder.INSTANCE;
    }

    @Override
    public AcquistoModel createAcquisto(AcquistoModel acquisto) {
        if(acquisto.getId() != null){
            throw new IllegalArgumentException("Non è possibile creare un acquisto con un ID già esistente");
        }

        log.debug("Creazione nuovo Acquisto dal valore: " + acquisto.getValoreAcquisto() + " effettuato dal cliente: " + acquisto.getCliente().getNome() + " " + acquisto.getCliente().getNome());
        AcquistoModel result = null;

        //TODO: eliminare questa riga quando sarà implementato il metodo di generazione automatica dell'ID
        acquisto.setId(UUID.randomUUID());

        try{
            result = acquistoRepository.save(acquisto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;    }

    @Override
    public AcquistoModel updateAcquisto(AcquistoModel acquistoModel) {
        return null;
    }

    @Override
    public boolean deleteAcquisto(AcquistoModel acquistoModel) {
        return false;
    }

    @Override
    public AcquistoModel getById(UUID id) {
        return null;
    }
}
