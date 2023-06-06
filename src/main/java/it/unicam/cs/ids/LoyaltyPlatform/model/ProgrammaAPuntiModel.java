package it.unicam.cs.ids.LoyaltyPlatform.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Objects;

@Data
@Builder
@ToString
public class ProgrammaAPuntiModel extends ProgrammaFedeltaModel {
    private double spesaMinima;
    private double rapportoPunti;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProgrammaAPuntiModel that)) return false;
        if (!super.equals(o)) return false;
        return Double.compare(that.getSpesaMinima(), getSpesaMinima()) == 0 && Double.compare(that.getRapportoPunti(), getRapportoPunti()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getSpesaMinima(), getRapportoPunti());
    }
}
