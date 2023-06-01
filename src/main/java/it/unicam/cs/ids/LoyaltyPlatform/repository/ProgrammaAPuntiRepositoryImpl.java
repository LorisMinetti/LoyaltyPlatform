package it.unicam.cs.ids.LoyaltyPlatform.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaAPuntiModel;
import it.unicam.cs.ids.LoyaltyPlatform.repository.inbound.ProgrammaAPuntiRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

public class ProgrammaAPuntiRepositoryImpl implements ProgrammaAPuntiRepository {

    private static final String OUTPUT_DIR = "C:\\Users\\loris\\Desktop\\LoyaltyPlatform\\programmaAPunti";

    private final ObjectMapper mapper;

    public ProgrammaAPuntiRepositoryImpl() { this.mapper = new ObjectMapper(); }

    /*
     *   Singleton constructor
     */
    private static class SingletonBuilder{
        private static final ProgrammaAPuntiRepositoryImpl INSTANCE = new ProgrammaAPuntiRepositoryImpl();
    }
    public static ProgrammaAPuntiRepositoryImpl getInstance(){
        return SingletonBuilder.INSTANCE;
    }

    @Override
    public ProgrammaAPuntiModel save(ProgrammaAPuntiModel programmaAPuntiModel) {
        try{
            String fileName = programmaAPuntiModel.getNome() + ".json";  //usa il nome del programma come nome del file
            String filePath = OUTPUT_DIR + "\\" + fileName;

            String json = mapper.writeValueAsString(programmaAPuntiModel);

            Files.write((Paths.get(filePath)), json.getBytes());


        } catch (IOException e) {
            System.err.println("Errore durante il salvataggio del Programma A Punti: " + e.getMessage());
        }

        return programmaAPuntiModel;
    }

    //TODO
    @Override
    public ProgrammaAPuntiModel update(ProgrammaAPuntiModel programmaAPuntiModel) {
        return null;
    }

    @Override
    public boolean delete(ProgrammaAPuntiModel programmaAPuntiModel) {
        try {
            String fileName = programmaAPuntiModel.getNome() + ".json";  // Usa il nome del programma come nome del file
            String filePath = OUTPUT_DIR + "\\" + fileName;

            File file = new File(filePath);
            if (file.exists()) {
                file.delete();
                System.out.println("ProgrammaFedeltaModel eliminato con successo: " + programmaAPuntiModel);
                return true;
            } else {
                System.out.println("Il file non esiste: " + filePath);
            }
        } catch (Exception e) {
            System.err.println("Errore durante l'eliminazione del Programma A Punti: " + e.getMessage());
        }
        return false;
    }

    //TODO
    @Override
    public ProgrammaAPuntiModel findById(UUID id) {
        return null;
    }
}
