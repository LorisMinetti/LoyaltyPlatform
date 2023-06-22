package it.unicam.cs.ids.LoyaltyPlatform.model;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.UUID;

@Data
@EqualsAndHashCode
@Builder
@ToString
public class AcquistoModel {
    private double valoreAcquisto;
    private UUID id;
    private ClienteModel cliente;
    private AttivitaCommercialeModel attivitaCommerciale;

    @Column(name = "flag_elimina")
    private boolean flagElimina;


}
