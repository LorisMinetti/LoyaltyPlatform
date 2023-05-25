package it.unicam.cs.ids.LoyaltyPlatform;

import it.unicam.cs.ids.LoyaltyPlatform.model.ClienteModel;
import it.unicam.cs.ids.LoyaltyPlatform.repository.ClienteModelRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.UUID;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class }) // Disabilita la connessione al database
public class LoyaltyPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoyaltyPlatformApplication.class, args);




		ClienteModel cliente = new ClienteModel();
		cliente.setId(UUID.randomUUID());
		cliente.setNome("Mario Rossi");

		ClienteModelRepository clienteModelRepository = new ClienteModelRepository();
		clienteModelRepository.save(cliente);

	}



}
