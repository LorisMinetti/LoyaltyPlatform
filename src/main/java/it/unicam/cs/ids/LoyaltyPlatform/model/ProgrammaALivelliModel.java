package it.unicam.cs.ids.LoyaltyPlatform.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Map;
import java.util.Objects;

@Data
@Builder
@ToString
public class ProgrammaALivelliModel extends ProgrammaFedeltaModel {

    /*
    * Mappa che associa ad ogni livello la spesa totale necessari per raggiungerlo
    */
    private Map<Integer, Double> livelli;

    private int livelloAttuale;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProgrammaALivelliModel that)) return false;
        if (!super.equals(o)) return false;
        return getLivelloAttuale() == that.getLivelloAttuale() && getLivelli().equals(that.getLivelli());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getLivelli(), getLivelloAttuale());
    }
}
