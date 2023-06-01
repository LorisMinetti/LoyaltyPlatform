package it.unicam.cs.ids.LoyaltyPlatform;

import it.unicam.cs.ids.LoyaltyPlatform.controller.AttivitaCommercialeControllerImpl;
import it.unicam.cs.ids.LoyaltyPlatform.controller.ClienteControllerImpl;
import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.AttivitaCommercialeController;
import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.ClienteController;
import it.unicam.cs.ids.LoyaltyPlatform.model.Acquisto;
import it.unicam.cs.ids.LoyaltyPlatform.model.AcquistoModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.ClienteModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.Scanner;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class }) // Disabilita la connessione al database
public class LoyaltyPlatformApplication {






	public static void main(String[] args) {


		SpringApplication.run(LoyaltyPlatformApplication.class, args);

		ClienteModel cliente = new ClienteModel.Builder().nome("Dilana Peci").build();


//
//
		ClienteControllerImpl clienteController = new ClienteControllerImpl();

		/**
		 * Builder pattern. Tenere in considerazione per il futuro
		 */
//		clienteController.createCliente(
//				new ClienteModel.Builder()
//						.nome("Riccardo Cantabè")
//						.build()
//				);

		Scanner scanner = new Scanner(System.in);
		startPlatform(scanner);

	}

	public static void startPlatform(Scanner scanner) {
		System.out.println("[INFO]: Avvio il sistema LoyaltyPlatform ...");
		//TODO: capire se l'utente è un cliente o un'attività commerciale
		System.out.println("[INFO]: Sei un cliente o un'attività commerciale? [C/A]");
		String input = scanner.nextLine();
		if (input.equalsIgnoreCase("C")) {
			//TODO: cliente deve inserire il nome con input "Nome Cognome" affinchè non inserisce un nome corretto che venga trovato nel file system
			while(true) {
				System.out.println("[INFO]: Inserisci il tuo nome: ");
				input = scanner.nextLine();
				if (input.matches("[a-zA-Z]+ [a-zA-Z]+")) {
					//TODO: controllare che il nome inserito sia presente nel file system
					ClienteControllerImpl clienteControllerImpl = new ClienteControllerImpl();
					ClienteModel cliente = clienteControllerImpl.getCliente(input);

					//TODO: finire di implementare metodo che restituisce il cliente dal file system (insieme a tutti gli altri metodi getById) <-> attenzione per la classe CLiente nel quale il find viene inteso per Nome

			System.out.println("[INFO]: Avvio il sistema come cliente ...");
			//TODO: cliente può effettuare un acquisto
			System.out.println("[INFO]: Vuoi effettuare un acquisto? [Y/N]");
			input = scanner.nextLine();
			if (input.equalsIgnoreCase("Y")) {
				System.out.println("[INFO]: Inserisci l'id dell'attività commerciale: ");
				input = scanner.nextLine();
				if (input.equalsIgnoreCase("1")) {
					System.out.println("[INFO]: Inserisci il valore dell'acquisto: ");
					input = scanner.nextLine();
					//TODO: controllare che il valore dell'acquisto sia un numero maggiore di 0
					if (input.matches("[0-9]+")) {
						System.out.println("[INFO]: Confermi l'acquisto? [Y/N]");
						input = scanner.nextLine();
						if (input.equalsIgnoreCase("Y")) {
							System.out.println("[INFO]: Acquisto confermato!");
							//TODO: la conferma dell'acquisto fa si che viene creato un nuovo acquisto nel file system, aggiornati i punti del cliente e aggiornato il livello del cliente
							AcquistoModel acquisto = new AcquistoModel();
							acquisto.setClienteModel(cliente);
							acquistoControllerImpl.createAcquisto(acquisto);

						}
					} else {
						System.out.println("[ERROR]: Input non valido!");
					}


				} else if (input.equalsIgnoreCase("A")) {
					System.out.println("[INFO]: Avvio il sistema come attività commerciale ...");
				} else {
					System.out.println("[ERROR]: Input non valido!");
				}
			}


		}
	}


}