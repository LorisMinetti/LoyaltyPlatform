package it.unicam.cs.ids.LoyaltyPlatform.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.unicam.cs.ids.LoyaltyPlatform.model.MessaggioModel;
import it.unicam.cs.ids.LoyaltyPlatform.repository.inbound.MessaggioRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

public class MessaggioRepositoryImpl implements MessaggioRepository {

    private static final String OUTPUT_DIR = "C:\\Users\\loris\\Desktop\\LoyaltyPlatform\\messaggio";

    private final ObjectMapper mapper;

    public MessaggioRepositoryImpl() {this.mapper = new ObjectMapper();}

    /*
     *   Singleton constructor
     */
    private static class SingletonBuilder{
        private static final MessaggioRepositoryImpl INSTANCE = new MessaggioRepositoryImpl();
    }
    public static MessaggioRepositoryImpl getInstance(){
        return SingletonBuilder.INSTANCE;
    }

    @Override
    public MessaggioModel save(MessaggioModel messaggioModel) {
        try{
            String fileName = messaggioModel.getTesto() + ".json";  //usa il testo del messaggio come nome del file
            String filePath = OUTPUT_DIR + "\\" + fileName;

            String json = mapper.writeValueAsString(messaggioModel);

            Files.write((Paths.get(filePath)), json.getBytes());


        } catch (IOException e) {
            System.err.println("Errore durante il salvataggio del MessaggioModel: " + e.getMessage());
        }

        return messaggioModel;
    }

    //TODO
    @Override
    public MessaggioModel update(MessaggioModel messaggioModel) throws IOException {
        return null;
    }

    @Override
    public boolean delete(MessaggioModel messaggioModel) {
        try {
            String fileName = messaggioModel.getTesto() + ".json";  // Usa il testo del messaggio come nome del file
            String filePath = OUTPUT_DIR + "\\" + fileName;

            File file = new File(filePath);
            if (file.exists()) {
                file.delete();
                System.out.println("MessaggioModel eliminato con successo: " + messaggioModel);
                return true;
            } else {
                System.out.println("Il file non esiste: " + filePath);
            }
        } catch (Exception e) {
            System.err.println("Errore durante l'eliminazione del Messaggio: " + e.getMessage());
        }
        return false;
    }

    //TODO
    @Override
    public MessaggioModel findById(UUID id) {
        return null;
    }
}
