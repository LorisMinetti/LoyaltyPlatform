package it.unicam.cs.ids.LoyaltyPlatform.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@ToString
public class ProgrammaAPuntiModel extends ProgrammaFedeltaModel {
    private double spesaMinima;
    private double rapportoPunti;

}
