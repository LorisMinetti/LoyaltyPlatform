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
    private Map<ProgrammaALivelliModel, Integer> livelloPerAttivitaCommerciale;
    private Map<ProgrammaAPuntiModel, Integer> puntiPerAttivitaCommerciale;
    private Map<ProgrammaCashbackModel, Double> saldoPerAttivitaCommerciale;

}
