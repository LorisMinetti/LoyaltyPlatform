package it.unicam.cs.ids.LoyaltyPlatform.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.unicam.cs.ids.LoyaltyPlatform.model.GestorePiattaformaModel;
import it.unicam.cs.ids.LoyaltyPlatform.repository.inbound.ClienteRepository;
import it.unicam.cs.ids.LoyaltyPlatform.repository.inbound.GestorePiattaformaRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

public class GestorePiattaformaRepositoryImpl implements GestorePiattaformaRepository {

    private static final String OUTPUT_DIR = "C:\\Users\\loris\\Desktop\\LoyaltyPlatform\\gestorePiattaforma";

    private ObjectMapper mapper;

    public GestorePiattaformaRepositoryImpl() {
        this.mapper = new ObjectMapper();
    }

    /*
     *   Singleton constructor
     */
    private static class SingletonBuilder{
        private static final GestorePiattaformaRepository INSTANCE = new GestorePiattaformaRepositoryImpl();
    }
    public static GestorePiattaformaRepository getInstance(){
        return SingletonBuilder.INSTANCE;
    }

    @Override
    public GestorePiattaformaModel save(GestorePiattaformaModel gestorePiattaformaModel) {
        try{
            String fileName = gestorePiattaformaModel.getNome() + ".json";  //usa il nome del gestore come nome del file
            String filePath = OUTPUT_DIR + "\\" + fileName;

            String json = mapper.writeValueAsString(gestorePiattaformaModel);

            Files.write((Paths.get(filePath)), json.getBytes());


        } catch (IOException e) {
            System.err.println("Errore durante il salvataggio del gestore: " + e.getMessage());
        }

        return gestorePiattaformaModel;
    }

    //TODO
    @Override
    public GestorePiattaformaModel update(GestorePiattaformaModel gestorePiattaformaModel) {
        return null;
    }

    @Override
    public boolean delete(GestorePiattaformaModel gestorePiattaformaModel) {
        try {
            String fileName = gestorePiattaformaModel.getNome() + ".json";  // Usa il nome del gestore come nome del file
            String filePath = OUTPUT_DIR + "\\" + fileName;

            File file = new File(filePath);
            if (file.exists()) {
                file.delete();
                System.out.println("Gestore eliminato con successo: " + gestorePiattaformaModel);
                return true;
            } else {
                System.out.println("Il file non esiste: " + filePath);
            }
        } catch (Exception e) {
            System.err.println("Errore durante l'eliminazione del gestore: " + e.getMessage());
        }
        return false;
    }

    //TODO
    @Override
    public GestorePiattaformaModel findById(UUID id) {
        return null;
    }
}
