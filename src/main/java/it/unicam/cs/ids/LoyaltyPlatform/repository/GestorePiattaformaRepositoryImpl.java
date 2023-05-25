package it.unicam.cs.ids.LoyaltyPlatform.repository;

import it.unicam.cs.ids.LoyaltyPlatform.model.GestorePiattaformaModel;
import it.unicam.cs.ids.LoyaltyPlatform.repository.inbound.GestorePiattaformaRepository;

import java.util.UUID;

public class GestorePiattaformaRepositoryImpl implements GestorePiattaformaRepository {

    @Override
    public void save(GestorePiattaformaModel gestorePiattaformaModel) {

    }

    @Override
    public void update(GestorePiattaformaModel gestorePiattaformaModel) {

    }

    @Override
    public boolean delete(GestorePiattaformaModel gestorePiattaformaModel) {
        return false;
    }

    @Override
    public GestorePiattaformaModel findById(UUID id) {
        return null;
    }
}
