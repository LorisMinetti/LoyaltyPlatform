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
public class ProgrammaCashbackModel extends ProgrammaFedeltaModel{
    @Column(name = "spesa_minima", nullable = false)
    private double spesaMinima;
    @Column(name = "percentuale_cashback", nullable = false)
    private double percentualeCashback;

}
