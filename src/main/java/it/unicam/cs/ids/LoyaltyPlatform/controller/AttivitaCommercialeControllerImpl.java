package it.unicam.cs.ids.LoyaltyPlatform.controller;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.AdesioneProgrammaFedeltaController;
import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.AttivitaCommercialeController;
import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.CoalizioneController;
import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.ProgrammaFedeltaController;
import it.unicam.cs.ids.LoyaltyPlatform.model.AdesioneProgrammaFedeltaModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.AttivitaCommercialeModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.CoalizioneModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaFedeltaModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.subModel.request.AdesioneProgrammaFedeltaRequest;
import it.unicam.cs.ids.LoyaltyPlatform.model.subModel.request.CoalizioneRequest;
import it.unicam.cs.ids.LoyaltyPlatform.repository.AdesioneProgrammaFedeltaRepository;
import it.unicam.cs.ids.LoyaltyPlatform.repository.AttivitaCommercialeRepository;
import it.unicam.cs.ids.LoyaltyPlatform.repository.CoalizioneRepository;
import it.unicam.cs.ids.LoyaltyPlatform.repository.ProgrammaFedeltaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class AttivitaCommercialeControllerImpl implements AttivitaCommercialeController {

    @Autowired
    private AttivitaCommercialeRepository attivitaCommercialeRepository;
    @Autowired
    private AdesioneProgrammaFedeltaController adesioneProgrammaFedeltaController;
    @Autowired
    private AdesioneProgrammaFedeltaRepository adesioneProgrammaFedeltaRepository;
    @Autowired
    private ProgrammaFedeltaController programmaFedeltaController;
    @Autowired
    private ProgrammaFedeltaRepository programmaFedeltaRepository;
    @Autowired
    private CoalizioneController coalizioneController;
    @Autowired
    private CoalizioneRepository coalizioneRepository;


    @Override
    public AttivitaCommercialeModel createAttivitaCommerciale(AttivitaCommercialeModel attivitaCommerciale) {
        if (attivitaCommerciale.getId() != null) {
            log.error("Tentativo di creazione di un attivitaCommerciale con id già presente");
        }
        try {
            return attivitaCommercialeRepository.save(attivitaCommerciale);
        } catch (Exception e) {
            log.error("Errore durante la creazione di un attivitaCommerciale");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public AttivitaCommercialeModel updateAttivitaCommerciale(AttivitaCommercialeModel attivitaCommerciale) {
        if (attivitaCommerciale.getId() == null) {
            log.error("Tentativo di aggiornamento di un attivitaCommerciale senza id");
        }
        try {
            return attivitaCommercialeRepository.save(attivitaCommerciale);
        } catch (Exception e) {
            log.error("Errore durante l'aggiornamento di un attivitaCommerciale");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deleteAttivitaCommerciale(AttivitaCommercialeModel attivitaCommerciale) {
        if (!attivitaCommercialeRepository.existsByIdAndFlagEliminaIsFalse(attivitaCommerciale.getId())) {
            log.error("Tentativo di eliminazione di un attivitaCommerciale non presente");
            return false;
        }
        try {
            attivitaCommercialeRepository.setFlagDelete(attivitaCommerciale.getId());
            return true;
        } catch (Exception e) {
            log.error("Errore durante l'eliminazione di un attivitaCommerciale");
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public AttivitaCommercialeModel getById(UUID id) {
        AttivitaCommercialeModel ret = null;
        try {
            ret = attivitaCommercialeRepository.getByIdAndFlagEliminaIsFalse(id);
        } catch (Exception e) {
            log.error("Errore nel recupero del attivitaCommerciale per id");
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public List<AttivitaCommercialeModel> findAll() {
        List<AttivitaCommercialeModel> ret = new ArrayList<>();
        try {
            ret = this.attivitaCommercialeRepository.findAll();
        } catch (Exception e) {
            log.error("Errore nel recupero della lista dei clienti");
            e.printStackTrace();
        }
        return ret;
    }


    /**
     * Adesione di un'attivitaCommerciale a un programma fedeltà
     *
     * @param adesioneProgrammaFedelta
     * @return l'adesione effettuata
     */
    @Override
    public AdesioneProgrammaFedeltaModel aderisciProgrammaFedelta(AdesioneProgrammaFedeltaRequest adesioneProgrammaFedelta) {
        //Controllo se il programma fedeltà non è selezionabile per l'attività commerciale
        if (isOneSelectable(adesioneProgrammaFedelta)) return null;

        //Da qui vuol dire che il programma fedeltà è selezionabile per l'attività commerciale e quindi procedo con l'adesione
        AdesioneProgrammaFedeltaModel ret = new AdesioneProgrammaFedeltaModel();
        ret.setIdAttivitaCommerciale(adesioneProgrammaFedelta.getIdAttivitaCommerciale());
        ret.setIdProgrammaFedelta(adesioneProgrammaFedelta.getIdProgrammaFedelta());

        ProgrammaFedeltaModel programmaFedelta = programmaFedeltaController.getById(adesioneProgrammaFedelta.getIdProgrammaFedelta());

            /*
            In base a al nome del programma fedeltà devo controllare che se è cashback devono esserci solo i parametri "spesaMinma" e
            "percentualeCashback". Nel caso sia punti ci devono essere solo i parametri "spesaMinima" e
            "rapportoPunti", nel caso sia a livelli ci devono essere solo i parametri "livelli" e "livelloAttuale"
            */

        switch (programmaFedelta.getNome()) {
            case ("Cashback") -> {
                if (adesioneProgrammaFedelta.getSpesaMinima() == null
                        || adesioneProgrammaFedelta.getPercentualeCashback() == null) {
                    log.error("Inserire\"spesaMinima\" o \"percentualeCashback\" per aderire al programma fedeltà Cashback");
                    return null;
                }
                ret.setSpesaMinima(adesioneProgrammaFedelta.getSpesaMinima());
                ret.setPercentualeCashback(adesioneProgrammaFedelta.getPercentualeCashback());
            }
            case ("Punti") -> {
                if (adesioneProgrammaFedelta.getSpesaMinima() == null
                        || adesioneProgrammaFedelta.getRapportoPunti() == null) {
                    log.error("Errore durante l'adesione di un attivitaCommerciale ad un programma fedeltà a Punti");
                    return null;
                }
                ret.setSpesaMinima(adesioneProgrammaFedelta.getSpesaMinima());
                ret.setRapportoPunti(adesioneProgrammaFedelta.getRapportoPunti());
            }
            case ("Livelli") -> {
                if (adesioneProgrammaFedelta.getLivelli() == null
                        || adesioneProgrammaFedelta.getLivelloAttuale() == null) {
                    log.error("Errore durante l'adesione di un attivitaCommerciale ad un programma fedeltà a Livelli");
                    return null;
                }
                ret.setLivelli(adesioneProgrammaFedelta.getLivelli());
                ret.setLivelloAttuale(adesioneProgrammaFedelta.getLivelloAttuale());
            }
        }

        try {
            return adesioneProgrammaFedeltaController.createAdesioneProgrammaFedelta(ret);
        } catch (Exception e) {
            log.error("Errore durante l'adesione di un attivitaCommerciale ad un programma fedeltà");
            e.printStackTrace();
            throw e;
        }
    }


    /**
     * Restituisce i programmi fedeltà selezionabili per l'attività commerciale
     *
     * @param attivitaCommercialeModel
     * @return
     */
    @Override
    public Set<ProgrammaFedeltaModel> getAvailablePrograms(AttivitaCommercialeModel attivitaCommercialeModel) {
        //TODO: devo ritornare tutti i programmifedelta selezionabili al quale l'attività non ha ancora aderito
        if (!attivitaCommercialeRepository.existsByIdAndFlagEliminaIsFalse(attivitaCommercialeModel.getId())) {
            log.error("Tentativo di recupero dei programmi fedeltà disponibili per un attivitaCommerciale non presente");
            return null;
        }
        //Prendo tutte le adesioni di quest'attività commerciale
        List<AdesioneProgrammaFedeltaModel> listaAdesioni = adesioneProgrammaFedeltaRepository
                .findAllByIdAttivitaCommercialeAndFlagEliminaIsFalse(attivitaCommercialeModel.getId());

        //Prendo tutti i programmi fedeltà al momento selezionabili
        List<ProgrammaFedeltaModel> listaProgrammi = programmaFedeltaRepository
                .findAllBySelezionabileIsTrueAndFlagEliminaIsFalse();

        //Ora devo ritornare solo i programmi fedeltà che non sono già stati aderiti da quest'attività commerciale
        Set<ProgrammaFedeltaModel> ret = new HashSet<>();

        for (ProgrammaFedeltaModel programmaFedelta : listaProgrammi) {
            boolean presente = false;
            for (AdesioneProgrammaFedeltaModel adesioneProgrammaFedelta : listaAdesioni) {
                if (adesioneProgrammaFedelta.getIdProgrammaFedelta().equals(programmaFedelta.getId())) {
                    presente = true;
                    break;
                }
            }
            if (!presente) {
                ret.add(programmaFedelta);
            }
        }
        return ret;
    }

    private boolean isOneSelectable(AdesioneProgrammaFedeltaRequest adesioneProgrammaFedeltaModel) {
        Set<ProgrammaFedeltaModel> programmiAvailable = this.getAvailablePrograms(attivitaCommercialeRepository.getByIdAndFlagEliminaIsFalse(adesioneProgrammaFedeltaModel.getIdAttivitaCommerciale()));

        //Controllo se non c'è nemmeno un programma fedelta come quello al quale voglio aderire
        //controllo direttamente i due uuid come stringhe
        if (programmiAvailable
                .stream()
                .noneMatch(p -> p.getId().toString().equals(adesioneProgrammaFedeltaModel.getIdProgrammaFedelta().toString())))   //se non ne trovo nemmeno uno -> ERRORE
        {
            log.error("Tentativo di adesione ad un programma fedeltà non selezionabile per l'attività commerciale");
            return true;
        }
        return false;
    }


    /**
     * Permette di disdire un'adesione a un programma fedeltà che perdurerà fino alla fine della dataScadenza
     *
     * @param adesione
     */
    @Override
    public Boolean disdiciAdesione(AdesioneProgrammaFedeltaModel adesione) {
        if (adesione == null) {
            log.error("Tentativo di disdire un'adesione nulla");
            return false;
        } else if (!adesione.isRinnovoAutomatico()) {
            log.error("Tentativo di disdire un'adesione non rinnovabile");
            return false;
        } else if (adesione.getDataScadenza() == null) {
            log.error("Tentativo di disdire un'adesione senza data di scadenza");
            return false;
        }

        try {
            return adesioneProgrammaFedeltaController.setRinnovoFalse(adesione.getId());
        } catch (Exception e) {
            log.error("Errore durante la disdetta di un'adesione ad un programma fedeltà");
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public CoalizioneModel richiediCoalizzazione(CoalizioneRequest request) {
        // controlli su mittente e destinatario
        if (request.getMittente() == null || request.getDestinatario() == null) {
            log.error("Tentativo di richiedere una coalizione con mittente o destinatario nulli");
            return null;
        } else if(coalizioneRepository.existsByAttivitaId(request.getMittente())){
            log.error("Tentativo di richiedere una coalizione da un attivitaCommerciale già coalizzato");
            return null;
        }

        AttivitaCommercialeModel mittente = this.getById(request.getMittente());
        AttivitaCommercialeModel destinatario = this.getById(request.getDestinatario());

        CoalizioneModel coalizioneAttualeInstance = new CoalizioneModel();

            // controllo che non sia già coalizzato
            if (coalizioneRepository.existsByAttivitaId(destinatario.getId())){
                // destinatario è già in una coalizione esistente

                coalizioneAttualeInstance = coalizioneRepository.getByAttivitaId(destinatario.getId());   //così sovrascrivo direttamente l'oggetto da ritornare con l'istanza recuperata a DB
                // controllo se la coalizione è già al completo
                if(coalizioneAttualeInstance.getAttivitaCommerciale4() != null) {
                    log.error("Tentativo di accedere ad una coalizione già al completo");
                    return null;
                } else {
                    // coalizione non è al completo -> aggiungo l'attività commerciale mittente nella giusta "slot"
                    switch (coalizioneAttualeInstance.getNumeroAttivita()){
                        case 2 -> {
                           coalizioneAttualeInstance.setAttivitaCommerciale3(mittente);
                           coalizioneAttualeInstance.setNumeroAttivita(3);
                        }
                        case 3 -> {
                            coalizioneAttualeInstance.setAttivitaCommerciale4(mittente);
                            coalizioneAttualeInstance.setNumeroAttivita(4);
                        }
                    }



                    //TODO: qui dovrei inserire il meccanismo asincrono per i consensi delle altre aziende?


                    mittente.setCoalizzata(true);
                    // Ora devo aggiornare l'istanza
                    try{
                        //Modifico la coalizione a DB
                        coalizioneController.updateCoalizione(coalizioneAttualeInstance);
                        //Invio la notifica di coalizione a tutte le attività coinvolte
                        this.inviaNotificaCreazioneCoalizione(mittente, coalizioneAttualeInstance);
                        //Modifico il record dell'attività richiedente
                        this.updateAttivitaCommerciale(mittente);
                    } catch (Exception e){
                        log.error("Errore durante l'aggiornamento di una coalizione richiesta da: " + mittente.getNome() + " alla già esistente coalizione: " + coalizioneAttualeInstance.getId());
                        e.printStackTrace();
                        throw e;
                    }
                }
            } else { // coalizione non esiste -> la creo

                coalizioneAttualeInstance.setAttivitaCommerciale1(destinatario);
                coalizioneAttualeInstance.setAttivitaCommerciale2(mittente);
                coalizioneAttualeInstance.setNumeroAttivita(2);

                mittente.setCoalizzata(true);
                destinatario.setCoalizzata(true);

                // creo la coalizione
                try{
                    //così facendo sto creando una coalizione a DB ed automaticamente il valore di ritorno
                    //di questa funzione lo passo in input alla funzione che invia Notifiche
                    this.inviaNotificaCreazioneCoalizione(
                            mittente,
                            coalizioneController.createCoalizione(coalizioneAttualeInstance)
                    );
                    this.updateAttivitaCommerciale(mittente);
                } catch (Exception e){
                    log.error("Errore durante la creazione di una coalizione per l'attività commerciale: " + mittente.getNome() + " e: " + destinatario.getNome());
                    e.printStackTrace();
                    throw e;
                }
            }

        return coalizioneAttualeInstance;
    }

    @Override
    public CoalizioneModel abbandonaCoalizione(AttivitaCommercialeModel attivita) {
        if(attivita == null){
            log.error("Attivita abbandonante è null");
            return null;
        }
        CoalizioneModel coalizioneModel = this.getCoalizioneByOneAttivita(attivita);

        //Elimino quella giusta nella giusta posizione
        if (coalizioneModel.getAttivitaCommerciale1() != null && coalizioneModel.getAttivitaCommerciale1().equals(attivita)) {
            switch (coalizioneModel.getNumeroAttivita()) {
                case 2 -> {
                    coalizioneModel.setAttivitaCommerciale1(null);
                    coalizioneModel.setAttivitaCommerciale2(null);
                    coalizioneModel.setNumeroAttivita(0);
                    if (this.coalizioneController.deleteCoalizione(coalizioneModel)) {
                        return coalizioneModel;
                    }
                }  //caso in cui ci sono 2 attività coalizzate -> Se una abbandona la coalizione, la coalizione viene eliminata
                case 3 -> {
                    coalizioneModel.setAttivitaCommerciale1(coalizioneModel.getAttivitaCommerciale2());
                    coalizioneModel.setAttivitaCommerciale2(coalizioneModel.getAttivitaCommerciale3());
                    coalizioneModel.setAttivitaCommerciale3(null);
                    coalizioneModel.setNumeroAttivita(2);
                    return this.coalizioneController.updateCoalizione(coalizioneModel);
                }
                case 4 -> {
                    coalizioneModel.setAttivitaCommerciale1(coalizioneModel.getAttivitaCommerciale2());
                    coalizioneModel.setAttivitaCommerciale2(coalizioneModel.getAttivitaCommerciale3());
                    coalizioneModel.setAttivitaCommerciale3(coalizioneModel.getAttivitaCommerciale4());
                    coalizioneModel.setAttivitaCommerciale4(null);
                    coalizioneModel.setNumeroAttivita(3);
                    return this.coalizioneController.updateCoalizione(coalizioneModel);
                }
            }
        }
        if (coalizioneModel.getAttivitaCommerciale2() != null && coalizioneModel.getAttivitaCommerciale2().equals(attivita)) {
            switch (coalizioneModel.getNumeroAttivita()) {
                case 2 -> {
                    coalizioneModel.setAttivitaCommerciale1(null);
                    coalizioneModel.setAttivitaCommerciale2(null);
                    coalizioneModel.setNumeroAttivita(0);
                    if (this.coalizioneController.deleteCoalizione(coalizioneModel)) {
                        return coalizioneModel;
                    }
                }
                case 3 -> {
                    coalizioneModel.setAttivitaCommerciale2(coalizioneModel.getAttivitaCommerciale3());
                    coalizioneModel.setAttivitaCommerciale3(null);
                    coalizioneModel.setNumeroAttivita(2);
                    return this.coalizioneController.updateCoalizione(coalizioneModel);
                }
                case 4 -> {
                    coalizioneModel.setAttivitaCommerciale2(coalizioneModel.getAttivitaCommerciale3());
                    coalizioneModel.setAttivitaCommerciale3(coalizioneModel.getAttivitaCommerciale4());
                    coalizioneModel.setAttivitaCommerciale4(null);
                    coalizioneModel.setNumeroAttivita(3);
                    return this.coalizioneController.updateCoalizione(coalizioneModel);
                }
            }
        }
        if (coalizioneModel.getAttivitaCommerciale3() != null && coalizioneModel.getAttivitaCommerciale3().equals(attivita)) {
            switch (coalizioneModel.getNumeroAttivita()) {
                case 3 -> {
                    coalizioneModel.setAttivitaCommerciale3(null);
                    coalizioneModel.setNumeroAttivita(2);
                    return this.coalizioneController.updateCoalizione(coalizioneModel);
                }
                case 4 -> {
                    coalizioneModel.setAttivitaCommerciale3(coalizioneModel.getAttivitaCommerciale4());
                    coalizioneModel.setAttivitaCommerciale4(null);
                    coalizioneModel.setNumeroAttivita(3);
                    return this.coalizioneController.updateCoalizione(coalizioneModel);
                }
            }
        }

        if (coalizioneModel.getAttivitaCommerciale4() != null && coalizioneModel.getAttivitaCommerciale4().equals(attivita)) {
            coalizioneModel.setAttivitaCommerciale3(coalizioneModel.getAttivitaCommerciale4());
            coalizioneModel.setAttivitaCommerciale4(null);
            coalizioneModel.setNumeroAttivita(3);
            return this.coalizioneController.updateCoalizione(coalizioneModel);
        }


        //se non sono riuscito ad aggiornare il dato a db, o ad eliminarlo nel caso la coalizione fosse da 2 devo tornare un errore
        log.error("Tentativo di abbandonare una coalizione non andato a buon fine");
        return null;
    }


    /**
     * Da un'attività, se questa è presente in una coalizione, recupero la coalizione
     * @param attivita attivita
     * @return coalizione
     */
    @Override
    public CoalizioneModel getCoalizioneByOneAttivita (AttivitaCommercialeModel attivita) {
        List<CoalizioneModel> co = this.coalizioneController.findAll();
        CoalizioneModel coalizioneModel = this.coalizioneController.findAll()
                .stream()
                .filter(x ->
                        x.getAttivitaCommerciale1() != null && x.getAttivitaCommerciale1().equals(attivita) ||
                                x.getAttivitaCommerciale2() != null && x.getAttivitaCommerciale2().equals(attivita) ||
                                x.getAttivitaCommerciale3() != null && x.getAttivitaCommerciale3().equals(attivita) ||
                                x.getAttivitaCommerciale4() != null && x.getAttivitaCommerciale4().equals(attivita)
                )
                .findFirst()
                .orElse(null);
        return coalizioneModel;
    }


    void inviaNotificaCreazioneCoalizione(AttivitaCommercialeModel attivitaRichiedente, CoalizioneModel coalizione){
        if(coalizione == null){
            log.error("Tentativo di inviare notifiche ad una coalizione nulla");
        }
        List<AttivitaCommercialeModel> attivitaCoalizzate = new ArrayList<>();
        attivitaCoalizzate.add(coalizione.getAttivitaCommerciale1());
        attivitaCoalizzate.add(coalizione.getAttivitaCommerciale2());
        if(coalizione.getNumeroAttivita() == 3 ){
            attivitaCoalizzate.add(coalizione.getAttivitaCommerciale3());
        }else if (coalizione.getNumeroAttivita() == 4){
            attivitaCoalizzate.add(coalizione.getAttivitaCommerciale3());
            attivitaCoalizzate.add(coalizione.getAttivitaCommerciale4());
        }
        //Una volta trovate tutte le attività coalizzate rimuovo l'attività richiedente in modo da non fargli arrivare alcuna notifica
        attivitaCoalizzate.remove(attivitaRichiedente);

        //Creo l'oggetto notifica da fare arrivare a db per ogni attività coalizzata


        if(attivitaCoalizzate.size()>2){
            for(AttivitaCommercialeModel x : attivitaCoalizzate){
                NotificaModel notifica = new NotificaModel();
                notifica.setAttivitaDestinataria(x);
                notifica.setOraInvio(LocalDateTime.now());
                notifica.setTesto("Richiesta di coalizione da parte dell'attività: "+attivitaRichiedente.getNome());

                try{
                    this.notificaController.createNotifica(notifica);
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        } else if(attivitaCoalizzate.size()==2){
            NotificaModel notifica = new NotificaModel();
            //Sono sicuro che dovrà arrivare una notifica solo all'attività 1 che è l'attività destinatario in una coalizione a 2
            notifica.setAttivitaDestinataria(coalizione.getAttivitaCommerciale1());
            notifica.setOraInvio(LocalDateTime.now());
            notifica.setTesto("Richiesta di coalizione da parte dell'attività: "+attivitaRichiedente.getNome());
            try{
                this.notificaController.createNotifica(notifica);
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        log.info("Notifiche inviate con successo.");
    }

    public void inviaNotificaAbbandonoCoalizione(){};








}
