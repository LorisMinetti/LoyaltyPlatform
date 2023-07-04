package it.unicam.cs.ids.LoyaltyPlatform.controller.inbound;

import it.unicam.cs.ids.LoyaltyPlatform.model.NotificaModel;
import java.util.List;
import java.util.UUID;

public interface NotificaController {
    NotificaModel createNotifica(NotificaModel notifica);

    boolean deleteNotifica(NotificaModel notifica);

    NotificaModel getById(UUID id);

    List<NotificaModel> findAll();

    NotificaModel inviaNotifica(Object destinatario, String testo);

}