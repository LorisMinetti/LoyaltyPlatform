package it.unicam.cs.ids.LoyaltyPlatform.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Data
@EqualsAndHashCode
@ToString
public class AttivitaCommercialeModel {
    private String nome;
    private UUID id;
    private String partitaIVA;
    private List<ProgrammaFedeltaModel> programmiFedeltaAderiti;

}
