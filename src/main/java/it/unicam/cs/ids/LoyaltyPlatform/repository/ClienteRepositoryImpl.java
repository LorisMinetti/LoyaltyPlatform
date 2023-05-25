package it.unicam.cs.ids.LoyaltyPlatform.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.unicam.cs.ids.LoyaltyPlatform.model.ClienteModel;
import it.unicam.cs.ids.LoyaltyPlatform.repository.inbound.ClienteRepository;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {

    private static final String OUTPUT_DIR = "C:\\Users\\loris\\Desktop\\LoyaltyPlatform\\cliente";

    private final ObjectMapper mapper;

    public ClienteRepositoryImpl() {
        this.mapper = new ObjectMapper();
    }

    @Override
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

    @Override
    public void update(ClienteModel clienteModel) {

    }

    @Override
    public boolean delete(ClienteModel clienteModel) {
        return false;
    }

    @Override
    public ClienteModel findById(UUID id) {
        return null;
    }

    //update

}
