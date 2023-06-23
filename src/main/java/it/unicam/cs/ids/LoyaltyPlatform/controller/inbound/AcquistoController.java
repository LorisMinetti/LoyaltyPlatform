package it.unicam.cs.ids.LoyaltyPlatform.controller.inbound;

import it.unicam.cs.ids.LoyaltyPlatform.model.AcquistoModel;

import java.util.List;
import java.util.UUID;

public interface AcquistoController {

    AcquistoModel createAcquisto(AcquistoModel acquistoModel);

    AcquistoModel updateAcquisto(AcquistoModel acquistoModel);

    boolean deleteAcquisto(AcquistoModel acquistoModel);

    AcquistoModel getById(UUID id);

    List<AcquistoModel> findAllforCliente();


}
