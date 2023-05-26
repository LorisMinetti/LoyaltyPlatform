package it.unicam.cs.ids.LoyaltyPlatform.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class MessaggioModel<M, D> {
    private UUID id;
    private String testo;
    private LocalDateTime time;
    private M mittente;
    private D destinatario;
}
