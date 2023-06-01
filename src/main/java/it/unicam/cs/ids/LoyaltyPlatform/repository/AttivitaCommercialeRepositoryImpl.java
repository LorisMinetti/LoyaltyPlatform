package it.unicam.cs.ids.LoyaltyPlatform.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.unicam.cs.ids.LoyaltyPlatform.model.AttivitaCommercialeModel;
import it.unicam.cs.ids.LoyaltyPlatform.repository.inbound.AttivitaCommercialeRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class AttivitaCommercialeRepositoryImpl implements AttivitaCommercialeRepository {

    private static final String OUTPUT_DIR = "C:\\Users\\loris\\Desktop\\LoyaltyPlatform\\attivitaCommerciale";
    private ObjectMapper mapper;

    public AttivitaCommercialeRepositoryImpl() {this.mapper = new ObjectMapper();}

    /*
     *   Singleton constructor
     */
    private static class SingletonBuilder{
        private static final AttivitaCommercialeRepository INSTANCE = new AttivitaCommercialeRepositoryImpl();
    }
    public static AttivitaCommercialeRepository getInstance(){
        return SingletonBuilder.INSTANCE;
    }

    @Override
    public AttivitaCommercialeModel save(AttivitaCommercialeModel attivitaCommercialeModel) {
        try{
            String fileName = attivitaCommercialeModel.getId() + ".json";
            String filePath = OUTPUT_DIR + "\\" + fileName;

            String json = mapper.writeValueAsString(attivitaCommercialeModel);

            Files.write((Paths.get(filePath)), json.getBytes());

        } catch (Exception e) {
            System.err.println("Errore durante il salvataggio dell'Attività Commerciale: " + e.getMessage());
        }
        return attivitaCommercialeModel;
    }

    //TODO
    @Override
    public AttivitaCommercialeModel update(AttivitaCommercialeModel attivitaCommercialeModel) {
        return null;
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

    //TODO
    @Override
    public AttivitaCommercialeModel findById(UUID id) {
        try {
            List<String> fileNames = Files.list(Paths.get(OUTPUT_DIR))
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .collect(Collectors.toList());

            for (String fileName : fileNames) {
                String filePath = OUTPUT_DIR + "\\" + fileName;
                String json = Files.readString(Paths.get(filePath));
                AttivitaCommercialeModel attivitaCommercialeModel = mapper.readValue(json, AttivitaCommercialeModel.class);
                if (attivitaCommercialeModel.getId().equals(id)) {
                    return attivitaCommercialeModel;
                }
            }
        } catch (IOException e) {
            System.err.println("Errore durante la lettura dei file dell'AttivitaCommercialeModel: " + e.getMessage());
        }
        return null;
    }
}
