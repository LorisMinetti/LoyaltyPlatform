package it.unicam.cs.ids.LoyaltyPlatform.controller.inbound;

import it.unicam.cs.ids.LoyaltyPlatform.model.AcquistoModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.AttivitaCommercialeModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.ClienteModel;

import java.util.UUID;

public interface ClienteController {

    ClienteModel createCliente(ClienteModel cliente);

    ClienteModel updateCliente(ClienteModel cliente);

    boolean deleteCliente(ClienteModel cliente);

    ClienteModel getById(UUID id);

    AcquistoModel effettuaAcquisto(AttivitaCommercialeModel attivita, double valoreAcquisto);

    boolean effettuaPagamento();

}
