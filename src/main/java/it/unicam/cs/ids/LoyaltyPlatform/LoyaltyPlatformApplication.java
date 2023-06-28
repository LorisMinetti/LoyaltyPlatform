package it.unicam.cs.ids.LoyaltyPlatform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication() // Disabilita la connessione al database
@EnableScheduling
@EnableTransactionManagement
public class LoyaltyPlatformApplication {

	public static void main(String[] args) {



		SpringApplication.run(LoyaltyPlatformApplication.class, args);


	//	DBController.getInstance().connect();



//		ClienteController clienteController = new ClienteControllerImpl(clienteRepository, acquistoController);
//		AttivitaCommercialeController attivitaCommercialeController = new AttivitaCommercialeControllerImpl();
//
//
//		ProgrammaCashbackModel programmaCashback = ProgrammaCashbackModel.builder().percentualeCashback(5.0).spesaMinima(2.0).build();
//		ProgrammaAPuntiModel programmaAPunti = ProgrammaAPuntiModel.builder().rapportoPunti(2).spesaMinima(4.0).build();
//		ProgrammaCashbackController programmaCashbackController = new ProgrammaCashbackControllerImpl();
//		ProgrammaAPuntiController programmaAPuntiController = new ProgrammaAPuntiControllerImpl();
//
//		programmaCashback.setNome("Cashback");
//		programmaCashback.setCosto(60);
//		programmaCashbackController.createProgrammaCashback(programmaCashback);
//
//		programmaAPunti.setNome("Punti");
//		programmaAPunti.setCosto(40);
//
//
//
//		AttivitaCommercialeModel attivitaCommercialeModel = AttivitaCommercialeModel.builder()
//				.nome("Nirvana da Safi")
//				.partitaIVA("ABCDEGFHILMNOPQ")
//				.programmiFedeltaAderiti(List.of(
//						programmaCashback, programmaAPunti))
//				.build();
//
//		attivitaCommercialeController.createAttivitaCommerciale(attivitaCommercialeModel);
//
//
//		/*
//		cliente attributi
//		 */
//		Map<ProgrammaCashbackModel, Double> saldoPerAttivitaCommerciale = new HashMap<>();
//		saldoPerAttivitaCommerciale.put(programmaCashback, 68.0);
//
//		Map<ProgrammaAPuntiModel, Integer> puntiPerAttivitaCommerciale = new HashMap<>();
//		puntiPerAttivitaCommerciale.put(programmaAPunti, 1210);
//
//		Map<ProgrammaALivelliModel, Integer> livelloPerAttivitaCommerciale = new HashMap<>();
//		livelloPerAttivitaCommerciale.put(ProgrammaALivelliModel.builder().livelloAttuale(0).build(), 1);
//
//		Map<AttivitaCommercialeModel, Double> spesaTotalePerAttivitaCommerciale = new HashMap<>();
//		spesaTotalePerAttivitaCommerciale.put(attivitaCommercialeModel, 100.0);
//
//
//		ClienteModel cliente = ClienteModel.builder()
//				.nome("Loris Minetti")
//				.saldoPerAttivitaCommerciale(saldoPerAttivitaCommerciale)
//				.puntiPerAttivitaCommerciale(puntiPerAttivitaCommerciale)
//				.spesaTotalePerAttivitaCommerciale(spesaTotalePerAttivitaCommerciale)
//				.livelloPerAttivitaCommerciale(livelloPerAttivitaCommerciale)
//				.build();
//
//
//
//		System.out.println(cliente);
//
//		clienteController.effettuaAcquisto(cliente, attivitaCommercialeModel, 50);
//
//		System.out.println(cliente);
//
//		clienteController.createCliente(cliente);

//		Scanner scanner = new Scanner(System.in);
//		startPlatform(scanner);

	}
}



//	public static void startPlatform(Scanner scanner) {
//		AttivitaCommercialeControllerImpl attivitaCommercialeControllerImpl = new AttivitaCommercialeControllerImpl();
//
//
//		System.out.println("[INFO]: Avvio il sistema LoyaltyPlatform ...");
//		//TODO: capire se l'utente è un cliente o un'attività commerciale
//		System.out.println("[INFO]: Sei un cliente o un'attività commerciale? [C/A]");
//		String input = scanner.nextLine();
//		if (input.equalsIgnoreCase("C")) {
//			//TODO: cliente deve inserire il nome con input "Nome Cognome" affinchè non inserisce un nome corretto che venga trovato nel file system
//			ClienteModel clienteModel;  //tengo salvato il cliente
//			System.out.println("[INFO]: Inserisci il tuo nome: ");
//
//			while(true) {
//
//				input = scanner.nextLine();
//				if (input.matches("[a-zA-Z]+ [a-zA-Z]+")) {
//					//TODO: controllare che il nome inserito sia presente nel file system
//					ClienteControllerImpl clienteControllerImpl = new ClienteControllerImpl();
//					try {
//						clienteModel = clienteControllerImpl.getByName(input);
//						break;
//					} catch (Exception e) {
//						e.getMessage();
//					}
//				} else System.out.println("Inserire il nome nel formato corretto 'Nome Cognome'");
//			}   //Caricamento cliente
//
//			System.out.println("[INFO]: Avvio il sistema per il cliente: "+ clienteModel.getNome());
//
//
//			//TODO: menu a tendina he chiede se il cliente vuole modificare i suoi dati, eliminarsi o effettuare un acquisto
//			System.out.println("[INFO]: Salve "+ clienteModel.getNome() +". Seleziona un azione: " +
//					"\n - 1. Effettua un acquisto " +
//					"\n - 2. Modifica dati utente " +
//					"\n - 3. Elimina utente");
//			input = scanner.nextLine();
//			switch(Integer.parseInt(input)) {
//				case 1 -> {
//					System.out.println("[INFO]: Inserisci l'id dell'attività commerciale: ");
//					input = scanner.nextLine();
//					AttivitaCommercialeModel attivitaCommercialeModel;
//					while(true) {  //id attività commmericiale deve essere corretto
//						try {
//							attivitaCommercialeModel = attivitaCommercialeControllerImpl.getById( UUID.fromString(input) );
//							break;
//						} catch (Exception e) {
//							e.getMessage();
//						}
//					}
//
//					System.out.println("[INFO]: Inserisci il valore dell'acquisto: ");
//						input = scanner.nextLine();
//						//TODO: controllare che il valore dell'acquisto sia un numero maggiore di 0
//						if (input.matches("[0-9]+")) {
//							System.out.println("[INFO]: Confermi l'acquisto? [Y/N]");
//							input = scanner.nextLine();
//							if (input.equalsIgnoreCase("Y")) {
//								System.out.println("[INFO]: Acquisto confermato!");
//								//TODO: la conferma dell'acquisto fa si che viene creato un nuovo acquisto nel file system, aggiornati i punti del cliente e aggiornato il livello del cliente
//								AcquistoModel acquisto = new AcquistoModel();
//								acquisto.setClienteModel(clienteModel);
//							//	acquistoControllerImpl.createAcquisto(acquisto);
//
//							} else if(input.equalsIgnoreCase("N")){
//								System.out.println("Acquisto annullato");
//							}
//						} else {
//							System.out.println("[ERROR]: Input non valido!");
//						}
//					}
//
//					//Per effettuare un acquisto viene mostrata la lista dei negozi
//					//la lista degli articoli
//					//viene chiesto se si vuole proseguire
//					//acquisto effettuato -> viene mostrato lo stato punti del cliente.
//				case 2 -> {}
//					//Viene chiesto quale campo dovrà essere modificato
//					//viene inserito e controllata la correttezza
//					//viene modificato -> vengono mostrati i dati del cliente
//				case 3 -> {}
//					//viene chiesto se si vuole davvero proseguire con l'eliminazione
//					//viene eliminato -> "cliente eliminato con successo"
//					//si torna al momento iniziale.
//			}
//
//
//			//TODO: cliente può effettuare un acquisto
//
//			System.out.println("[INFO]: Vuoi effettuare un acquisto? [Y/N]");
//			input = scanner.nextLine();
//			if (input.equalsIgnoreCase("Y")) {
//
//
//
//				} else if (input.equalsIgnoreCase("A")) {
//					System.out.println("[INFO]: Avvio il sistema come attività commerciale ...");
//				} else {
//					System.out.println("[ERROR]: Input non valido!");
//				}
//			}
//		}
//	}

