package it.unicam.cs.ids.LoyaltyPlatform;

import it.unicam.cs.ids.LoyaltyPlatform.controller.ClienteControllerImpl;
import it.unicam.cs.ids.LoyaltyPlatform.model.ClienteModel;
import it.unicam.cs.ids.LoyaltyPlatform.repository.ClienteRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class }) // Disabilita la connessione al database
public class LoyaltyPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoyaltyPlatformApplication.class, args);

		ClienteModel cliente = new ClienteModel();
		cliente.setNome("Francesco Tasso");

		ClienteControllerImpl clienteController = new ClienteControllerImpl(cliente, new ClienteRepositoryImpl());
		clienteController.createCliente(cliente);

	}



}
