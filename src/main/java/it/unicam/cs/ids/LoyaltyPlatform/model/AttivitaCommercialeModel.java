package it.unicam.cs.ids.LoyaltyPlatform.model;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.AttivitaCommercialeController;
import lombok.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
@ToString
public class AttivitaCommercialeModel {
    private String nome;
    private UUID id;
    private String partitaIVA;
    private List<ProgrammaFedeltaModel> programmiFedeltaAderiti;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AttivitaCommercialeModel that)) return false;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
