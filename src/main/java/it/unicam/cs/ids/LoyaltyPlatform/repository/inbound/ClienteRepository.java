package it.unicam.cs.ids.LoyaltyPlatform.repository.inbound;

import it.unicam.cs.ids.LoyaltyPlatform.model.ClienteModel;

import java.util.UUID;

public interface ClienteRepository {

    void save(ClienteModel clienteModel);

    void update(ClienteModel clienteModel);

    boolean delete(ClienteModel clienteModel);

    ClienteModel findById(UUID id);

}
