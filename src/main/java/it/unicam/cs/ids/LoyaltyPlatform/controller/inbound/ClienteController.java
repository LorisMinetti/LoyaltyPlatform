package it.unicam.cs.ids.LoyaltyPlatform.controller.inbound;

import it.unicam.cs.ids.LoyaltyPlatform.model.AcquistoModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.AttivitaCommercialeModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.ClienteModel;

import java.util.List;
import java.util.UUID;

public interface ClienteController {

    ClienteModel createCliente(ClienteModel cliente);

    ClienteModel updateCliente(ClienteModel cliente);

    boolean deleteCliente(ClienteModel cliente);

    ClienteModel getById(UUID id);

    List<ClienteModel> findAll();

    AcquistoModel effettuaAcquisto(ClienteModel clienteModel, AttivitaCommercialeModel attivita, double valoreAcquisto);

    boolean effettuaPagamento();

}
