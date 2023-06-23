package it.unicam.cs.ids.LoyaltyPlatform.controller;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.AcquistoController;
import it.unicam.cs.ids.LoyaltyPlatform.model.AcquistoModel;

import it.unicam.cs.ids.LoyaltyPlatform.repository.inbound.AcquistoRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.UUID;

@Slf4j
public class AcquistoControllerImpl implements AcquistoController {

    private AcquistoRepository acquistoRepository;


    @Override
    public AcquistoModel createAcquisto(AcquistoModel acquisto) {
        return null;
    }
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

    @Override
    public List<AcquistoModel> findAllforCliente() {
        return null;
    }
}
