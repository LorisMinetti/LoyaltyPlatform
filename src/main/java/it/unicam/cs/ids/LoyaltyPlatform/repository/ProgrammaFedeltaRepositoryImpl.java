package it.unicam.cs.ids.LoyaltyPlatform.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaFedeltaModel;
import it.unicam.cs.ids.LoyaltyPlatform.repository.inbound.ProgrammaFedeltaRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

public class ProgrammaFedeltaRepositoryImpl implements ProgrammaFedeltaRepository {

    private static final String OUTPUT_DIR = "C:\\Users\\loris\\Desktop\\LoyaltyPlatform\\programmaFedelta";

    private final ObjectMapper mapper;

    public ProgrammaFedeltaRepositoryImpl() { this.mapper = new ObjectMapper(); }

    /*
     *   Singleton constructor
     */
    private static class SingletonBuilder{
        private static final ProgrammaFedeltaRepositoryImpl INSTANCE = new ProgrammaFedeltaRepositoryImpl();
    }
    public static ProgrammaFedeltaRepositoryImpl getInstance(){
        return SingletonBuilder.INSTANCE;
    }

    @Override
    public ProgrammaFedeltaModel save(ProgrammaFedeltaModel programmaFedeltaModel) {
        try{
            String fileName = programmaFedeltaModel.getNome() + ".json";  //usa il nome del programma come nome del file
            String filePath = OUTPUT_DIR + "\\" + fileName;

            String json = mapper.writeValueAsString(programmaFedeltaModel);

            Files.write((Paths.get(filePath)), json.getBytes());


        } catch (IOException e) {
            System.err.println("Errore durante il salvataggio del ProgrammaFedeltaModel: " + e.getMessage());
        }

        return programmaFedeltaModel;
    }

    //TODO
    @Override
    public ProgrammaFedeltaModel update(ProgrammaFedeltaModel programmaFedeltaModel) throws IOException {
        return null;
    }

    @Override
    public boolean delete(ProgrammaFedeltaModel programmaFedeltaModel) {
        try {
            String fileName = programmaFedeltaModel.getNome() + ".json";  // Usa il nome del programma come nome del file
            String filePath = OUTPUT_DIR + "\\" + fileName;

            File file = new File(filePath);
            if (file.exists()) {
                file.delete();
                System.out.println("ProgrammaFedeltaModel eliminato con successo: " + programmaFedeltaModel);
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
    public ProgrammaFedeltaModel findById(UUID id) {
        return null;
    }
}
