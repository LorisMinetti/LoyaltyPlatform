package it.unicam.cs.ids.LoyaltyPlatform.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
public class ProgrammaAPuntiModel extends ProgrammaFedelta {
    private double spesaMinima;
    private double rapportoPunti;

}
