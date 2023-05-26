package it.unicam.cs.ids.LoyaltyPlatform.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@EqualsAndHashCode
@ToString
public class MessaggioModel<M, D> {
    private UUID id;
    private String testo;
    private LocalDateTime time;
    private M mittente;
    private D destinatario;
}
