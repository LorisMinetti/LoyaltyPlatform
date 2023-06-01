package it.unicam.cs.ids.LoyaltyPlatform.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.unicam.cs.ids.LoyaltyPlatform.model.AcquistoModel;
import it.unicam.cs.ids.LoyaltyPlatform.repository.inbound.AcquistoRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

public class AcquistoRepositoryImpl implements AcquistoRepository {

    private static final String OUTPUT_DIR = "C:\\Users\\loris\\Desktop\\LoyaltyPlatform\\acuisto";

    private final ObjectMapper mapper;

    public AcquistoRepositoryImpl() {
        this.mapper = new ObjectMapper();
    }

    /*
     *   Singleton constructor
     */
    private static class SingletonBuilder{
        private static final AcquistoRepository INSTANCE = new AcquistoRepositoryImpl();
    }
    public static AcquistoRepository getInstance(){
        return SingletonBuilder.INSTANCE;
    }

    @Override
    public AcquistoModel save(AcquistoModel acquistoModel) {
        try{
            String fileName = acquistoModel.getValoreAcquisto() + ".json";  //usa il valore dell'acquisto come nome del file
            String filePath = OUTPUT_DIR + "\\" + fileName;

            String json = mapper.writeValueAsString(acquistoModel);

            Files.write((Paths.get(filePath)), json.getBytes());


        } catch (IOException e) {
            System.err.println("Errore durante il salvataggio dell'AcquistoModel: " + e.getMessage());
        }

        return acquistoModel;
    }

    //TODO
    @Override
    public AcquistoModel update(AcquistoModel acquistoModel) throws IOException {
        return null;
    }

    @Override
    public boolean delete(AcquistoModel acquistoModel) {
        try {
            String fileName = acquistoModel.getValoreAcquisto() + ".json";  // Usa il valore dell'Acquisto come nome del file
            String filePath = OUTPUT_DIR + "\\" + fileName;

            File file = new File(filePath);
            if (file.exists()) {
                file.delete();
                System.out.println("AcquistoModel eliminato con successo: " + acquistoModel);
                return true;
            } else {
                System.out.println("Il file non esiste: " + filePath);
            }
        } catch (Exception e) {
            System.err.println("Errore durante l'eliminazione dell'Acquisto: " + e.getMessage());
        }
        return false;
    }

    //TODO
    @Override
    public AcquistoModel findById(UUID id) {
        return null;
    }
}
