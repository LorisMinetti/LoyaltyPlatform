package it.unicam.cs.ids.LoyaltyPlatform.controller.inbound;

import it.unicam.cs.ids.LoyaltyPlatform.model.AdesioneProgrammaFedeltaModel;

import java.util.List;
import java.util.UUID;

public interface AdesioneProgrammaFedeltaController {
    AdesioneProgrammaFedeltaModel createAdesioneProgrammaFedelta(AdesioneProgrammaFedeltaModel adesioneProgrammaFedelta);

    AdesioneProgrammaFedeltaModel updateAdesioneProgrammaFedelta(AdesioneProgrammaFedeltaModel adesioneProgrammaFedelta);

    AdesioneProgrammaFedeltaModel getById(UUID id);

    List<AdesioneProgrammaFedeltaModel> findAll();

    Boolean setRinnovoFalse(UUID id);
}
