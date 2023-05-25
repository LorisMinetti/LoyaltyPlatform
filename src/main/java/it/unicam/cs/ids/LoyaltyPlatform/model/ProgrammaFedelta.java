package it.unicam.cs.ids.LoyaltyPlatform.model;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.AttivitaCommercialeController;
import lombok.Data;

import java.util.UUID;

@Data
public class ProgrammaFedelta {
    private String nome;
    private UUID id;
    private double costo;
    private AttivitaCommercialeController attivitaCommerciale;

}
