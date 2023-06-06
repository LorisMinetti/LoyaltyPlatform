package it.unicam.cs.ids.LoyaltyPlatform.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@Builder
@ToString
public class ProgrammaCashbackModel extends ProgrammaFedeltaModel {
    private double spesaMinima;
    private double percentualeCashback;
}
