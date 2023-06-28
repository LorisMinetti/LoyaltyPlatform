package it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.benefitsCliente;

import it.unicam.cs.ids.LoyaltyPlatform.model.ClienteModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.subModel.SaldoPerAttivitaCommerciale;

import java.util.List;
import java.util.UUID;

public interface SaldoPerAttivitaCommercialeController {
    SaldoPerAttivitaCommerciale createSaldoPerAttivita(SaldoPerAttivitaCommerciale saldoPerAttivitaModel);

    SaldoPerAttivitaCommerciale updateSaldoPerAttivita(SaldoPerAttivitaCommerciale saldoPerAttivitaModel);

    boolean deleteSaldoPerAttivita(SaldoPerAttivitaCommerciale saldoPerAttivitaModel);

    SaldoPerAttivitaCommerciale getById(UUID id);

    List<SaldoPerAttivitaCommerciale> findAll();

    List<SaldoPerAttivitaCommerciale> findAllByCliente(ClienteModel cliente);
}
