package it.unicam.cs.ids.LoyaltyPlatform.repository;

import it.unicam.cs.ids.LoyaltyPlatform.model.GestorePiattaformaModel;

import java.util.UUID;

public interface GestorePiattaformaRepository {

    GestorePiattaformaModel save(GestorePiattaformaModel gestorePiattaformaModel);

    GestorePiattaformaModel update(GestorePiattaformaModel gestorePiattaformaModel);

    boolean delete(GestorePiattaformaModel gestorePiattaformaModel);

    GestorePiattaformaModel findById(UUID id);

}
