package it.unicam.cs.ids.LoyaltyPlatform.controller;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.*;
import it.unicam.cs.ids.LoyaltyPlatform.model.AdesioneProgrammaFedeltaModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.GestorePiattaformaModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.NotificaModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaFedeltaModel;
import it.unicam.cs.ids.LoyaltyPlatform.repository.GestorePiattaformaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class GestorePiattaformaControllerImpl implements GestorePiattaformaController {

    @Autowired
    private GestorePiattaformaRepository gestorePiattaformaRepository;
    @Autowired
    private ProgrammaFedeltaController programmaFedeltaController;
    @Autowired
    private AdesioneProgrammaFedeltaController adesioneProgrammaFedeltaController;
    @Autowired
    private AttivitaCommercialeController attivitaCommercialeController;
    @Autowired
    private NotificaController notificaController;
    @Override
    public GestorePiattaformaModel createGestorePiattaforma(GestorePiattaformaModel gestorePiattaforma) {
        if(gestorePiattaforma.getId() != null) {
            log.error("Tentativo di creazione di un gestorePiattaforma con id già presente");
        }
        try{
            return gestorePiattaformaRepository.save(gestorePiattaforma);
        } catch (Exception e) {
            log.error("Errore durante la creazione di un gestorePiattaforma");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public GestorePiattaformaModel updateGestorePiattaforma(GestorePiattaformaModel gestorePiattaforma) {
        if(gestorePiattaforma.getId() == null) {
            log.error("Tentativo di aggiornamento di un gestorePiattaforma senza id");
        }
        try{
            return gestorePiattaformaRepository.save(gestorePiattaforma);
        } catch (Exception e) {
            log.error("Errore durante l'aggiornamento di un gestorePiattaforma");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deleteGestorePiattaforma(GestorePiattaformaModel gestorePiattaforma) {
        if(!gestorePiattaformaRepository.existsByIdAndFlagEliminaIsFalse(gestorePiattaforma.getId())){
            log.error("Tentativo di eliminazione di un cliente non presente");
            return false;
        }
        try{
            gestorePiattaformaRepository.setFlagDelete(gestorePiattaforma.getId());
            return true;
        } catch (Exception e) {
            log.error("Errore durante l'eliminazione di un cliente");
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public GestorePiattaformaModel getById(UUID id) {
        GestorePiattaformaModel ret = null;
        try {
            ret = gestorePiattaformaRepository.getByIdAndFlagEliminaIsFalse(id);
        } catch (Exception e) {
            log.error("Errore nel recupero del gestorePiattaforma per id");
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public List<GestorePiattaformaModel> findAll() {
        List<GestorePiattaformaModel> ret = new ArrayList<>();
        try{
            ret = this.gestorePiattaformaRepository.findAll();
        } catch (Exception e){
            log.error("Errore nel recupero della lista dei clienti");
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public ProgrammaFedeltaModel aggiungiProgrammaFedelta(ProgrammaFedeltaModel programmaFedeltaModel) {
        if(programmaFedeltaModel == null){
            log.error("Tentativo di aggiunta di un programma fedeltà nullo");
            return null;
        }
        try{
            return programmaFedeltaController.createProgrammaFedelta(programmaFedeltaModel);
        } catch (Exception e) {
            log.error("Errore durante l'aggiunta di un programma fedeltà");
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public boolean rimuoviProgrammaFedelta(ProgrammaFedeltaModel programmaFedeltaModel) {
        if(programmaFedeltaModel == null){
            log.error("Tentativo di rimozione di un programma fedeltà nullo");
            return false;
        }
        boolean ret = false;
        try{
            programmaFedeltaController.deSelectable(programmaFedeltaModel);
            ret = true;

            //Una volta reso non più disposnibile il programmaFedelta posso automaticamente disdire tutte le adesioni per le attivita
            //che avevano aderito al programma fedeltà e dunque avranno una scadenza fissata e non più rinnovabile
            this.disdiciAutomaticamentePerTutti(programmaFedeltaModel);

        } catch (Exception e) {
            log.error("Errore durante la rimozione di un programma fedeltà");
            e.printStackTrace();
            return false;
        }
        return ret;
    }

    @Override
    public List<ProgrammaFedeltaModel> getAllProgrammiFedelta() {
        List<ProgrammaFedeltaModel> ret = new ArrayList<>();
        try{
            ret = programmaFedeltaController.findAll();
        } catch (Exception e) {
            log.error("Errore durante il recupero della lista dei programmi fedeltà");
            e.printStackTrace();
        }
        return ret;
    }


    private void inviaNotificaAdAttivita(ProgrammaFedeltaModel programmaFedeltaModel, String testo){
        List<AdesioneProgrammaFedeltaModel> adesioniProgramma = adesioneProgrammaFedeltaController.findAll()
                .stream()
                .filter(x -> x.getIdProgrammaFedelta().equals( programmaFedeltaModel.getId() ) )
                .distinct()
                .toList();

        adesioniProgramma.forEach( x -> {
            NotificaModel notifica = new NotificaModel();
            notifica.setAttivitaDestinataria( attivitaCommercialeController.getById( x.getIdAttivitaCommerciale() ) );
            notifica.setTesto(testo);
            notifica.setOraInvio(LocalDateTime.now());
            try{
                this.notificaController.createNotifica(notifica);
            } catch (Exception e) {
                log.error("Errore durante l'invio di una notifica per l'attivita " + notifica.getAttivitaDestinataria().getNome() + "\nSaluti, \n" +
                        "il gestore piattaforma");
                e.printStackTrace();
            }
        });
        log.info("Notifiche inviate con successo");
    }

    private void disdiciAutomaticamentePerTutti(ProgrammaFedeltaModel programmaFedeltaModel){
        String notifica = "Il programma fedeltà " + programmaFedeltaModel.getNome() + " è stato rimosso dal gestore piattaforma. Non \n" +
                "preoccuparti, potrai continuare ad usufuire dei vantaggi fino alla scadenza del programma.";

        List<AdesioneProgrammaFedeltaModel> adesioniProgramma = adesioneProgrammaFedeltaController.findAll()
                .stream()
                .filter(x -> x.getIdProgrammaFedelta().equals(programmaFedeltaModel.getId()))
                .toList();

        adesioniProgramma.forEach( x -> {
            AdesioneProgrammaFedeltaModel adesione = adesioneProgrammaFedeltaController.getById(x.getId());
            adesione.setRinnovoAutomatico(false);
            try{
                this.adesioneProgrammaFedeltaController.updateAdesioneProgrammaFedelta(adesione);
            } catch (Exception e) {
                log.error("Errore durante la disdetta automatica di un programma fedeltà per l'attivita " +
                            attivitaCommercialeController.getById( x.getIdAttivitaCommerciale() ).getNome()
                        + "\nSaluti, \n" +
                        "il gestore piattaforma");
                e.printStackTrace();
            }
        });
        this.inviaNotificaAdAttivita(programmaFedeltaModel, notifica);
        log.info("Disdette automatiche effettuate con successo");

    }

}
