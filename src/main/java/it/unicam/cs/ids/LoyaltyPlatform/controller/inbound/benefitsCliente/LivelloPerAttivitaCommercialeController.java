package it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.benefitsCliente;

import it.unicam.cs.ids.LoyaltyPlatform.model.ClienteModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.subModel.LivelloPerAttivitaCommerciale;

import java.util.List;
import java.util.UUID;

public interface LivelloPerAttivitaCommercialeController {
    LivelloPerAttivitaCommerciale createLivelloPerAttivita(LivelloPerAttivitaCommerciale livello);

    LivelloPerAttivitaCommerciale updateLivelloPerAttivita(LivelloPerAttivitaCommerciale livello);

    boolean deleteLivelloPerAttivita(LivelloPerAttivitaCommerciale livello);

    LivelloPerAttivitaCommerciale getById(UUID id);

    List<LivelloPerAttivitaCommerciale> findAll();

    List<LivelloPerAttivitaCommerciale> findAllByCliente(ClienteModel cliente);
}
