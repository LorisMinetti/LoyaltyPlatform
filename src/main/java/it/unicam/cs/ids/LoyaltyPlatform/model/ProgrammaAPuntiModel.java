package it.unicam.cs.ids.LoyaltyPlatform.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString
public class ProgrammaAPuntiModel extends ProgrammaFedelta {
    private double spesaMinima;
    private double rapportoPunti;

}
