package it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.benefitsCliente;

import it.unicam.cs.ids.LoyaltyPlatform.model.ClienteModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.subModel.PuntiPerAttivitaCommerciale;

import java.util.List;
import java.util.UUID;

public interface PuntiPerAttivitaCommercialeController {
    PuntiPerAttivitaCommerciale createPuntiPerAttivita(PuntiPerAttivitaCommerciale puntiPerAttivitaModel);

    PuntiPerAttivitaCommerciale updatePuntiPerAttivita(PuntiPerAttivitaCommerciale puntiPerAttivitaModel);

    boolean deletePuntiPerAttivita(PuntiPerAttivitaCommerciale puntiPerAttivitaModel);

    PuntiPerAttivitaCommerciale getById(UUID id);

    List<PuntiPerAttivitaCommerciale> findAll();

    List<PuntiPerAttivitaCommerciale> findAllByCliente(ClienteModel cliente);
}
