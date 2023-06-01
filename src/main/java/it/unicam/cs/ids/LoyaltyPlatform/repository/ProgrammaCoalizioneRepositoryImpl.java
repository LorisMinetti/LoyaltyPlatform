package it.unicam.cs.ids.LoyaltyPlatform.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaCoalizioneModel;
import it.unicam.cs.ids.LoyaltyPlatform.repository.inbound.ProgrammaCoalizioneRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

public class ProgrammaCoalizioneRepositoryImpl implements ProgrammaCoalizioneRepository {

    private static final String OUTPUT_DIR = "C:\\Users\\loris\\Desktop\\LoyaltyPlatform\\programmaCoalizone";

    private final ObjectMapper mapper;

    public ProgrammaCoalizioneRepositoryImpl() { this.mapper = new ObjectMapper(); }

    /*
     *   Singleton constructor
     */
    private static class SingletonBuilder{
        private static final ProgrammaCoalizioneRepositoryImpl INSTANCE = new ProgrammaCoalizioneRepositoryImpl();
    }
    public static ProgrammaCoalizioneRepositoryImpl getInstance(){
        return SingletonBuilder.INSTANCE;
    }

    @Override
    public ProgrammaCoalizioneModel save(ProgrammaCoalizioneModel programmaCoalizioneModel) {
        try{
            String fileName = programmaCoalizioneModel.getNome() + ".json";  //usa il nome del programma come nome del file
            String filePath = OUTPUT_DIR + "\\" + fileName;

            String json = mapper.writeValueAsString(programmaCoalizioneModel);

            Files.write((Paths.get(filePath)), json.getBytes());


        } catch (IOException e) {
            System.err.println("Errore durante il salvataggio del Programma Coalizione: " + e.getMessage());
        }

        return programmaCoalizioneModel;
    }

    //TODO
    @Override
    public ProgrammaCoalizioneModel update(ProgrammaCoalizioneModel programmaCoalizioneModel) throws IOException {
        return null;
    }

    @Override
    public boolean delete(ProgrammaCoalizioneModel programmaCoalizioneModel) {
        try {
            String fileName = programmaCoalizioneModel.getNome() + ".json";  // Usa il nome del programma come nome del file
            String filePath = OUTPUT_DIR + "\\" + fileName;

            File file = new File(filePath);
            if (file.exists()) {
                file.delete();
                System.out.println("Programma Coalizione eliminato con successo: " + programmaCoalizioneModel);
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
    public ProgrammaCoalizioneModel findById(UUID id) {
        return null;
    }
}
