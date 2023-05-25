package it.unicam.cs.ids.LoyaltyPlatform.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.unicam.cs.ids.LoyaltyPlatform.model.ClienteModel;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Repository
public class ClienteModelRepository {

    private static final String OUTPUT_DIR = "C:\\Users\\loris\\Desktop\\LoyaltyPlatform\\cliente";

    private final ObjectMapper mapper;

    public ClienteModelRepository() {
        this.mapper = new ObjectMapper();
    }

    public void save(ClienteModel clienteModel) {
        try{
            String fileName = clienteModel.getNome() + ".json";  //usa l'id del cliente come nome del file
            String filePath = OUTPUT_DIR + "\\" + fileName;

            String json = mapper.writeValueAsString(clienteModel);

            Files.write((Paths.get(filePath)), json.getBytes());

        } catch (IOException e) {
            System.err.println("Errore durante il salvataggio del ClienteModel: " + e.getMessage());
        }

    }
}
