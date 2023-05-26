package it.unicam.cs.ids.LoyaltyPlatform.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.unicam.cs.ids.LoyaltyPlatform.model.ClienteModel;
import it.unicam.cs.ids.LoyaltyPlatform.repository.inbound.ClienteRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

public class ClienteRepositoryImpl implements ClienteRepository {

    private static final String OUTPUT_DIR = "C:\\Users\\loris\\Desktop\\LoyaltyPlatform\\cliente";

    private final ObjectMapper mapper;

    public ClienteRepositoryImpl(){
        this.mapper = new ObjectMapper();
    }

    /*
    *   Singleton constructor
    */
    private static class SingletonBuilder{
        private static final ClienteRepositoryImpl INSTANCE = new ClienteRepositoryImpl();
    }
    public static ClienteRepositoryImpl getInstance(){
        return SingletonBuilder.INSTANCE;
    }

    @Override
    public ClienteModel save(ClienteModel clienteModel) {
        try{
            String fileName = clienteModel.getNome() + ".json";  //usa l'id del cliente come nome del file
            String filePath = OUTPUT_DIR + "\\" + fileName;

            String json = mapper.writeValueAsString(clienteModel);

            Files.write((Paths.get(filePath)), json.getBytes());


        } catch (IOException e) {
            System.err.println("Errore durante il salvataggio del ClienteModel: " + e.getMessage());
        }

        return clienteModel;
    }

    //TODO: non considerare questo metodo, poichè con questa logica non avrebbe senso/convenienza un update
    @Override
    public ClienteModel update(ClienteModel clienteModel) throws IOException {
        if (clienteModel.getId() == null){
            throw new IllegalArgumentException("l'id non può essere null");
        }
        try{
            UUID id = clienteModel.getId();
            String fileName = clienteModel.getId() + ".json";  //usa il nome del cliente come nome del file
            String filePath = OUTPUT_DIR + "\\" + fileName;

            //Verifica che il file esista
            File file = new File(filePath);
            if(!file.exists()){
                System.err.println("Il file " + filePath + " non esiste");
                return null;
            }


            // Carica il contenuto del file come stringa JSON
            String json = new String(Files.readAllBytes(Paths.get(filePath)));

            // Deserializza il JSON in un'istanza di ClienteModel
            ClienteModel existingCliente = mapper.readValue(json, ClienteModel.class);

            // Verifica che l'ID corrisponda
            if (!existingCliente.getId().equals(id)) {
                System.err.println("L'ID del ClienteModel fornito non corrisponde all'ID del file.");
                return null;
            }

            // Aggiorna solo i campi desiderati (escludendo l'ID)
            existingCliente.setNome(clienteModel.getNome());
            existingCliente.setSpesaTotalePerAttivitaCommerciale(clienteModel.getSpesaTotalePerAttivitaCommerciale());
            existingCliente.setLivelloPerAttivitaCommerciale(clienteModel.getLivelloPerAttivitaCommerciale());
            existingCliente.setPuntiPerAttivitaCommerciale(clienteModel.getPuntiPerAttivitaCommerciale());
            existingCliente.setSaldoPerAttivitaCommerciale(clienteModel.getSaldoPerAttivitaCommerciale());

            // Serializza l'oggetto ClienteModel aggiornato in formato JSON
            String updatedJson = mapper.writeValueAsString(existingCliente);

            // Aggiorna il contenuto del file con il nuovo JSON
            Files.write(Paths.get(filePath), updatedJson.getBytes());

            System.out.println("ClienteModel aggiornato correttamente: " + filePath);

        } catch (IOException e){
            System.err.println("Errore durante l'aggiornamento del ClienteModel: " + e.getMessage());
        }

        return clienteModel;
    }

    @Override
    public boolean delete(ClienteModel clienteModel) {
        try {
            String fileName = clienteModel.getNome() + ".json";  // Usa l'id del cliente come nome del file
            String filePath = OUTPUT_DIR + "\\" + fileName;

            File file = new File(filePath);
            if (file.exists()) {
                file.delete();
                System.out.println("ClienteModel eliminato con successo: " + clienteModel);
                return true;
            } else {
                System.out.println("Il file non esiste: " + filePath);
            }
        } catch (Exception e) {
            System.err.println("Errore durante l'eliminazione del Cliente: " + e.getMessage());
        }
        return false;
    }

    //TODO
    @Override
    public ClienteModel findById(UUID id) {
        return null;
    }

    //update

}
