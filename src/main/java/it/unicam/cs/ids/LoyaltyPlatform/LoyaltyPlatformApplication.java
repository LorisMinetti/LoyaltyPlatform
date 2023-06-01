package it.unicam.cs.ids.LoyaltyPlatform;

import it.unicam.cs.ids.LoyaltyPlatform.controller.AttivitaCommercialeControllerImpl;
import it.unicam.cs.ids.LoyaltyPlatform.controller.ClienteControllerImpl;
import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.AttivitaCommercialeController;
import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.ClienteController;
import it.unicam.cs.ids.LoyaltyPlatform.model.AcquistoModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.AttivitaCommercialeModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.ClienteModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaCashbackModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.*;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class }) // Disabilita la connessione al database
public class LoyaltyPlatformApplication {

	public static void main(String[] args) {


		SpringApplication.run(LoyaltyPlatformApplication.class, args);





		ClienteController clienteController = new ClienteControllerImpl();
		AttivitaCommercialeController attivitaCommercialeController = new AttivitaCommercialeControllerImpl();


		/**
		 * Builder pattern. Tenere in considerazione per il futuro
		 */
//		clienteController.createCliente(
//				new ClienteModel.Builder()
//						.nome("Riccardo Cantabè")
//						.build()
//				);
		ProgrammaCashbackModel programmaCashbackModel = new ProgrammaCashbackModel();



		programmaCashbackModel.setNome("Cashback");
		programmaCashbackModel.setSpesaMinima(0.0);
		programmaCashbackModel.setPercentualeCashback(10);
		programmaCashbackModel.setCosto(60);

		Map<ProgrammaCashbackModel, Double> saldoPerAttivitaCommerciale = new HashMap<>();
		saldoPerAttivitaCommerciale.put(programmaCashbackModel, 10.5);

		ClienteModel cliente = ClienteModel.builder()
				.nome("Loris Minetti")
				.saldoPerAttivitaCommerciale(saldoPerAttivitaCommerciale)
				.build();

		AttivitaCommercialeModel attivitaCommercialeModel = AttivitaCommercialeModel.builder()
				.nome("Nirvana da Safi")
				.partitaIVA("")
				.programmiFedeltaAderiti( List.of( programmaCashbackModel ))
				.build();

		programmaCashbackModel.setAttivitaCommerciale(attivitaCommercialeModel);

		clienteController.effettuaAcquisto(cliente, attivitaCommercialeModel, 50);

		System.out.println(cliente);







//		Scanner scanner = new Scanner(System.in);
//		startPlatform(scanner);

	}



	public static void startPlatform(Scanner scanner) {
		AttivitaCommercialeControllerImpl attivitaCommercialeControllerImpl = new AttivitaCommercialeControllerImpl();


		System.out.println("[INFO]: Avvio il sistema LoyaltyPlatform ...");
		//TODO: capire se l'utente è un cliente o un'attività commerciale
		System.out.println("[INFO]: Sei un cliente o un'attività commerciale? [C/A]");
		String input = scanner.nextLine();
		if (input.equalsIgnoreCase("C")) {
			//TODO: cliente deve inserire il nome con input "Nome Cognome" affinchè non inserisce un nome corretto che venga trovato nel file system
			ClienteModel clienteModel;  //tengo salvato il cliente
			System.out.println("[INFO]: Inserisci il tuo nome: ");

			while(true) {

				input = scanner.nextLine();
				if (input.matches("[a-zA-Z]+ [a-zA-Z]+")) {
					//TODO: controllare che il nome inserito sia presente nel file system
					ClienteControllerImpl clienteControllerImpl = new ClienteControllerImpl();
					try {
						clienteModel = clienteControllerImpl.getByName(input);
						break;
					} catch (Exception e) {
						e.getMessage();
					}
				} else System.out.println("Inserire il nome nel formato corretto 'Nome Cognome'");
			}   //Caricamento cliente

			System.out.println("[INFO]: Avvio il sistema per il cliente: "+ clienteModel.getNome());


			//TODO: menu a tendina he chiede se il cliente vuole modificare i suoi dati, eliminarsi o effettuare un acquisto
			System.out.println("[INFO]: Salve "+ clienteModel.getNome() +". Seleziona un azione: " +
					"\n - 1. Effettua un acquisto " +
					"\n - 2. Modifica dati utente " +
					"\n - 3. Elimina utente");
			input = scanner.nextLine();
			switch(Integer.parseInt(input)) {
				case 1 -> {
					System.out.println("[INFO]: Inserisci l'id dell'attività commerciale: ");
					input = scanner.nextLine();
					AttivitaCommercialeModel attivitaCommercialeModel;
					while(true) {  //id attività commmericiale deve essere corretto
						try {
							attivitaCommercialeModel = attivitaCommercialeControllerImpl.getById( UUID.fromString(input) );
							break;
						} catch (Exception e) {
							e.getMessage();
						}
					}

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
								acquisto.setClienteModel(clienteModel);
							//	acquistoControllerImpl.createAcquisto(acquisto);

							} else if(input.equalsIgnoreCase("N")){
								System.out.println("Acquisto annullato");
							}
						} else {
							System.out.println("[ERROR]: Input non valido!");
						}
					}

					//Per effettuare un acquisto viene mostrata la lista dei negozi
					//la lista degli articoli
					//viene chiesto se si vuole proseguire
					//acquisto effettuato -> viene mostrato lo stato punti del cliente.
				case 2 -> {}
					//Viene chiesto quale campo dovrà essere modificato
					//viene inserito e controllata la correttezza
					//viene modificato -> vengono mostrati i dati del cliente
				case 3 -> {}
					//viene chiesto se si vuole davvero proseguire con l'eliminazione
					//viene eliminato -> "cliente eliminato con successo"
					//si torna al momento iniziale.
			}


			//TODO: cliente può effettuare un acquisto

			System.out.println("[INFO]: Vuoi effettuare un acquisto? [Y/N]");
			input = scanner.nextLine();
			if (input.equalsIgnoreCase("Y")) {



				} else if (input.equalsIgnoreCase("A")) {
					System.out.println("[INFO]: Avvio il sistema come attività commerciale ...");
				} else {
					System.out.println("[ERROR]: Input non valido!");
				}
			}
		}
	}

