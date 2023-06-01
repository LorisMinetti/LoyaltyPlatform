package it.unicam.cs.ids.LoyaltyPlatform.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaCashbackModel;
import it.unicam.cs.ids.LoyaltyPlatform.repository.inbound.ProgrammaCashbackRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

public class ProgrammaCashbackRepositoryImpl implements ProgrammaCashbackRepository {

    private static final String OUTPUT_DIR = "C:\\Users\\loris\\Desktop\\LoyaltyPlatform\\programmaCashback";

    private final ObjectMapper mapper;

    public ProgrammaCashbackRepositoryImpl() { this.mapper = new ObjectMapper(); }

    /*
     *   Singleton constructor
     */
    private static class SingletonBuilder{
        private static final ProgrammaCashbackRepository INSTANCE = new ProgrammaCashbackRepositoryImpl();
    }
    public static ProgrammaCashbackRepository getInstance(){
        return SingletonBuilder.INSTANCE;
    }

    @Override
    public ProgrammaCashbackModel save(ProgrammaCashbackModel programmaCashbackModel) {
        try{
            String fileName = programmaCashbackModel.getNome() + ".json";  //usa il nome del programma come nome del file
            String filePath = OUTPUT_DIR + "\\" + fileName;

            String json = mapper.writeValueAsString(programmaCashbackModel);

            Files.write((Paths.get(filePath)), json.getBytes());


        } catch (IOException e) {
            System.err.println("Errore durante il salvataggio del Programma Cashback: " + e.getMessage());
        }

        return programmaCashbackModel;
    }

    //TODO
    @Override
    public ProgrammaCashbackModel update(ProgrammaCashbackModel programmaCashbackModel) throws IOException {
        return null;
    }

    @Override
    public boolean delete(ProgrammaCashbackModel programmaCashbackModel) {
        try {
            String fileName = programmaCashbackModel.getNome() + ".json";  // Usa il nome del programma come nome del file
            String filePath = OUTPUT_DIR + "\\" + fileName;

            File file = new File(filePath);
            if (file.exists()) {
                file.delete();
                System.out.println("ProgrammaFedeltaModel eliminato con successo: " + programmaCashbackModel);
                return true;
            } else {
                System.out.println("Il file non esiste: " + filePath);
            }
        } catch (Exception e) {
            System.err.println("Errore durante l'eliminazione del Programma: " + e.getMessage());
        }
        return false;
    }

    //TODO
    @Override
    public ProgrammaCashbackModel findById(UUID id) {
        return null;
    }
}
