package it.unicam.cs.ids.LoyaltyPlatform.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
public class ProgrammaCashbackModel extends ProgrammaFedelta {
    private double spesaMinima;
    private double percentualeCashback;
}
