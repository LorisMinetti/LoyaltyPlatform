package it.unicam.cs.ids.LoyaltyPlatform.model;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.AttivitaCommercialeController;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@EqualsAndHashCode
@ToString
public class ProgrammaFedeltaModel {
    private String nome;
    private UUID id;
    private double costo;
    private LocalDateTime dataAttivazione;
    private AttivitaCommercialeModel attivitaCommercialeModel;
}
