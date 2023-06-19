package it.unicam.cs.ids.LoyaltyPlatform.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
@Entity
public class ProgrammaAPuntiModel extends ProgrammaFedeltaModel {
    @Column(name = "spesa_minima", nullable = false)
    private double spesaMinima;
    @Column(name = "rapporto_punti", nullable = false)
    private double rapportoPunti;

}
