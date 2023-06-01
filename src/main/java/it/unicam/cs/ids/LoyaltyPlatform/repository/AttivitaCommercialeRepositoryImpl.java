package it.unicam.cs.ids.LoyaltyPlatform.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.unicam.cs.ids.LoyaltyPlatform.model.AttivitaCommercialeModel;
import it.unicam.cs.ids.LoyaltyPlatform.repository.inbound.AttivitaCommercialeRepository;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

public class AttivitaCommercialeRepositoryImpl implements AttivitaCommercialeRepository {

    private static final String OUTPUT_DIR = "C:\\Users\\loris\\Desktop\\LoyaltyPlatform\\attivitaCommerciale";
    private ObjectMapper mapper;

    public AttivitaCommercialeRepositoryImpl() {this.mapper = new ObjectMapper();}

    /*
     *   Singleton constructor
     */
    private static class SingletonBuilder{
        private static final AttivitaCommercialeRepositoryImpl INSTANCE = new AttivitaCommercialeRepositoryImpl();
    }
    public static AttivitaCommercialeRepositoryImpl getInstance(){
        return AttivitaCommercialeRepositoryImpl.SingletonBuilder.INSTANCE;
    }

    @Override
    public void save(AttivitaCommercialeModel attivitaCommercialeModel) {
        try{
            String fileName = attivitaCommercialeModel.getId() + ".json";
            String filePath = OUTPUT_DIR + "\\" + fileName;

            String json = mapper.writeValueAsString(attivitaCommercialeModel);

            Files.write((Paths.get(filePath)), json.getBytes());

        } catch (Exception e) {
            System.err.println("Errore durante il salvataggio dell'Attività Commerciale: " + e.getMessage());
        }
    }

    @Override
    public void update(AttivitaCommercialeModel attivitaCommercialeModel) {

    }

    @Override
    public boolean delete(AttivitaCommercialeModel attivitaCommercialeModel) {
        try {
            String fileName = attivitaCommercialeModel.getId() + ".json";  // Usa l'id del cliente come nome del file
            String filePath = OUTPUT_DIR + "\\" + fileName;

            File file = new File(filePath);
            if (file.exists()) {
                file.delete();
                System.out.println("Attività Commerciale eliminata con successo: " + attivitaCommercialeModel);
                return true;
            } else {
                System.out.println("Il file non esiste: " + filePath);
            }
        } catch (Exception e) {
            System.err.println("Errore durante l'eliminazione dell'Attività Commerciale: " + e.getMessage());
        }
        return false;
    }

    @Override
    public AttivitaCommercialeModel findById(UUID id) {
        return null;
    }
}
