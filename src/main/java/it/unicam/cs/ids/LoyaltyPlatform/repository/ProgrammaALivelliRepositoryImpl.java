package it.unicam.cs.ids.LoyaltyPlatform.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaALivelliModel;
import it.unicam.cs.ids.LoyaltyPlatform.repository.inbound.ProgrammaALivelliRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

public class ProgrammaALivelliRepositoryImpl implements ProgrammaALivelliRepository {

    private static final String OUTPUT_DIR = "C:\\Users\\loris\\Desktop\\LoyaltyPlatform\\programmaALivelli";

    private final ObjectMapper mapper;

    public ProgrammaALivelliRepositoryImpl(){
        this.mapper = new ObjectMapper();
    }

    /*
     *   Singleton constructor
     */
    private static class SingletonBuilder{
        private static final ProgrammaALivelliRepositoryImpl INSTANCE = new ProgrammaALivelliRepositoryImpl();
    }
    public static ProgrammaALivelliRepositoryImpl getInstance(){
        return ProgrammaALivelliRepositoryImpl.SingletonBuilder.INSTANCE;
    }

    @Override
    public ProgrammaALivelliModel save(ProgrammaALivelliModel programmaALivelliModel) {
        try{
            String fileName = programmaALivelliModel.getNome() + ".json";  //usa il nome del programma come nome del file
            String filePath = OUTPUT_DIR + "\\" + fileName;

            String json = mapper.writeValueAsString(programmaALivelliModel);

            Files.write((Paths.get(filePath)), json.getBytes());


        } catch (IOException e) {
            System.err.println("Errore durante il salvataggio del ProgrammaALivelliModel: " + e.getMessage());
        }

        return programmaALivelliModel;
    }

    //TODO
    @Override
    public ProgrammaALivelliModel update(ProgrammaALivelliModel programmaALivelliModel) throws IOException {
        return null;
    }

    @Override
    public boolean delete(ProgrammaALivelliModel programmaALivelliModel) {
        try {
            String fileName = programmaALivelliModel.getNome() + ".json";  // Usa il nome del programma come nome del file
            String filePath = OUTPUT_DIR + "\\" + fileName;

            File file = new File(filePath);
            if (file.exists()) {
                file.delete();
                System.out.println("Programma A Livelli eliminato con successo: " + programmaALivelliModel);
                return true;
            } else {
                System.out.println("Il file non esiste: " + filePath);
            }
        } catch (Exception e) {
            System.err.println("Errore durante l'eliminazione del Programma A Livelli: " + e.getMessage());
        }
        return false;
    }

    //TODO
    @Override
    public ProgrammaALivelliModel findById(UUID id) {
        return null;
    }
}
