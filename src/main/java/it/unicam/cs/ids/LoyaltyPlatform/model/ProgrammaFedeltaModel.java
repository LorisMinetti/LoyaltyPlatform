package it.unicam.cs.ids.LoyaltyPlatform.model;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.AttivitaCommercialeController;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.UUID;

@Data
@EqualsAndHashCode
@Builder
@ToString
public class ProgrammaFedeltaModel {
    private String nome;
    private UUID id;
    private double costo;
    private AttivitaCommercialeModel attivitaCommerciale;

}
