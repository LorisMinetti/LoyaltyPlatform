package it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.benefitsCliente;

import it.unicam.cs.ids.LoyaltyPlatform.model.ClienteModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.subModel.SpesaTotalePerAttivitaCommerciale;

import java.util.List;
import java.util.UUID;

public interface SpesaTotalePerAttivitaCommercialeController {
    SpesaTotalePerAttivitaCommerciale createSpesaTotale(SpesaTotalePerAttivitaCommerciale spesaTotaleModel);

    SpesaTotalePerAttivitaCommerciale updateSpesaTotale(SpesaTotalePerAttivitaCommerciale spesaTotaleModel);

    boolean deleteSpesaTotale(SpesaTotalePerAttivitaCommerciale spesaTotaleModel);

    SpesaTotalePerAttivitaCommerciale getById(UUID id);

    List<SpesaTotalePerAttivitaCommerciale> findAll();

    List<SpesaTotalePerAttivitaCommerciale> findAllByCliente(ClienteModel cliente);
}
