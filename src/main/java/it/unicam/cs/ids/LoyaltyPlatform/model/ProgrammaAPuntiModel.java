package it.unicam.cs.ids.LoyaltyPlatform.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Objects;

@Data
@EqualsAndHashCode
@Builder
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
