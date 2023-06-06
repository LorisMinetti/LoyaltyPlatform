package it.unicam.cs.ids.LoyaltyPlatform.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@ToString
public class ProgrammaALivelliModel extends ProgrammaFedeltaModel {

    /*
    * Mappa che associa ad ogni livello la spesa totale necessari per raggiungerlo
    */
    private Map<Integer, Double> livelli;

    private int livelloAttuale;
}
