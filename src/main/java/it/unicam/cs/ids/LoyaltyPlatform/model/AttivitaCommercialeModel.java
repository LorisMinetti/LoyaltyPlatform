package it.unicam.cs.ids.LoyaltyPlatform.model;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.AttivitaCommercialeController;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@Builder
@ToString
public class AttivitaCommercialeModel {
    private String nome;
    private UUID id;
    private String partitaIVA;
    private List<ProgrammaFedeltaModel> programmiFedeltaAderiti;


}
