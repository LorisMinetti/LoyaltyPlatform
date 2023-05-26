package it.unicam.cs.ids.LoyaltyPlatform.model;

import lombok.Data;

@Data
public class ProgrammaCashbackModel extends ProgrammaFedelta {
    private double spesaMinima;
    private double percentualeCashback;
}
