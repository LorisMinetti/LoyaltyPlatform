package it.unicam.cs.ids.LoyaltyPlatform.controller;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.NotificaController;
import it.unicam.cs.ids.LoyaltyPlatform.model.AttivitaCommercialeModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.ClienteModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.NotificaModel;
import it.unicam.cs.ids.LoyaltyPlatform.repository.NotificaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class NotificaControllerImpl implements NotificaController {

    @Autowired
    private NotificaRepository notificaRepository;

    @Override
    public NotificaModel createNotifica(NotificaModel notifica) {
        if(notifica.getId() != null) {
            log.error("Tentativo di creazione di un notifica con id già presente");
        }
        try{
            return notificaRepository.save(notifica);
        } catch (Exception e) {
            log.error("Errore durante la creazione di un notifica");
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public boolean deleteNotifica(NotificaModel notifica) {
        if(!notificaRepository.existsById(notifica.getId())){
            log.error("Tentativo di eliminazione di un notifica non presente");
            return false;
        }
        try{
            notificaRepository.delete(notifica);
            return true;
        } catch (Exception e) {
            log.error("Errore durante l'eliminazione di un notifica");
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public NotificaModel getById(UUID id) {
        NotificaModel ret = null;
        try{
            ret = notificaRepository.getById(id);
        } catch (Exception e){
            log.error("Errore nel recupero del notifica per Id");
            e.printStackTrace();
        }
        return ret;    }

    @Override
    public List<NotificaModel> findAll() {
        List<NotificaModel> ret = new ArrayList<>();
        try{
            ret = this.notificaRepository.findAll();
        } catch (Exception e){
            log.error("Errore nel recupero della lista dei notifica");
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public NotificaModel inviaNotifica(Object destinatario, String testo){
        if(destinatario == null){
            log.error("Inserire un destinatario corretto");
            return null;
        }
        NotificaModel notifica = new NotificaModel();

        if(destinatario instanceof AttivitaCommercialeModel attivitaDestinataria){
            notifica.setTesto(testo);
            notifica.setOraInvio(LocalDateTime.now());
            notifica.setAttivitaDestinataria(attivitaDestinataria);
            this.createNotifica(notifica);

        } else if (destinatario instanceof ClienteModel clienteDestinatario) {
            notifica.setTesto(testo);
            notifica.setOraInvio(LocalDateTime.now());
            notifica.setClienteDestinatario(clienteDestinatario);
            this.createNotifica(notifica);

        } else
            log.error("Destinatario non è nè un cliente nè un'attivita");
        return null;
    }
}