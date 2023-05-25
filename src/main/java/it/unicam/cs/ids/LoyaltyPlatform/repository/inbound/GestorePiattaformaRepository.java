package it.unicam.cs.ids.LoyaltyPlatform.repository.inbound;

import it.unicam.cs.ids.LoyaltyPlatform.model.GestorePiattaformaModel;

import java.util.UUID;

public interface GestorePiattaformaRepository {

    void save(GestorePiattaformaModel gestorePiattaformaModel);

    void update(GestorePiattaformaModel gestorePiattaformaModel);

    boolean delete(GestorePiattaformaModel gestorePiattaformaModel);

    GestorePiattaformaModel findById(UUID id);

}
