package it.unicam.cs.ids.LoyaltyPlatform.repository.inbound;

import it.unicam.cs.ids.LoyaltyPlatform.model.ClienteModel;

import java.io.IOException;
import java.util.UUID;

public interface ClienteRepository {

    ClienteModel save(ClienteModel clienteModel);

    ClienteModel update(ClienteModel clienteModel) throws IOException;

    boolean delete(ClienteModel clienteModel);

    ClienteModel findByName(String name);

}
