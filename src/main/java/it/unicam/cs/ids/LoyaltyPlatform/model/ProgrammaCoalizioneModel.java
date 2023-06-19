package it.unicam.cs.ids.LoyaltyPlatform.model;

import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.Objects;

@Data
@ToString
public class ProgrammaCoalizioneModel extends ProgrammaFedeltaModel {
    private List<AttivitaCommercialeModel> attivtaCoalizione;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProgrammaCoalizioneModel that)) return false;
        if (!super.equals(o)) return false;
        return getAttivtaCoalizione().equals(that.getAttivtaCoalizione());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getAttivtaCoalizione());
    }
}
