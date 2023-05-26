package it.unicam.cs.ids.LoyaltyPlatform.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.unicam.cs.ids.LoyaltyPlatform.model.GestorePiattaformaModel;
import it.unicam.cs.ids.LoyaltyPlatform.repository.inbound.GestorePiattaformaRepository;

import java.util.UUID;

public class GestorePiattaformaRepositoryImpl implements GestorePiattaformaRepository {

    private static final String OUTPUT_DIR = "C:\\Users\\loris\\Desktop\\LoyaltyPlatform\\gestorePiattaforma";

    private ObjectMapper mapper;

    public GestorePiattaformaRepositoryImpl() {}

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
