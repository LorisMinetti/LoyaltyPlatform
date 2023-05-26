package it.unicam.cs.ids.LoyaltyPlatform.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Map;

@Data
@EqualsAndHashCode
@ToString
public class ProgrammaALivelliModel extends ProgrammaFedelta {

    /*
    * Mappa che associa ad ogni livello la spesa totale necessari per raggiungerlo
    */
    private Map<Integer, Double> livelli;

    private int livelloAttuale;
}
