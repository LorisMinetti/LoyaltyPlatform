package it.unicam.cs.ids.LoyaltyPlatform.model;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.AttivitaCommercialeController;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Map;
import java.util.UUID;

@Data
@EqualsAndHashCode
@ToString
public class ClienteModel {
    private String nome;
    private UUID id;
    private Map<AttivitaCommercialeController, Double> spesaTotalePerAttivitaCommerciale;
    private Map<ProgrammaALivelli, Integer> livelloPerAttivitaCommerciale;
    private Map<ProgrammaAPunti, Integer> puntiPerAttivitaCommerciale;
    private Map<ProgrammaCashback, Double> saldoPerAttivitaCommerciale;

}
