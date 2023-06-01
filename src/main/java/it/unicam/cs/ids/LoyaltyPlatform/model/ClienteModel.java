package it.unicam.cs.ids.LoyaltyPlatform.model;

import lombok.*;

import java.util.Map;
import java.util.UUID;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@Builder
@ToString
public class ClienteModel {
    private String nome;
    private UUID id;
    private Map<AttivitaCommercialeModel, Double> spesaTotalePerAttivitaCommerciale;
    private Map<ProgrammaALivelliModel, Integer> livelloPerAttivitaCommerciale;
    private Map<ProgrammaAPuntiModel, Integer> puntiPerAttivitaCommerciale;
    private Map<ProgrammaCashbackModel, Double> saldoPerAttivitaCommerciale;



}
