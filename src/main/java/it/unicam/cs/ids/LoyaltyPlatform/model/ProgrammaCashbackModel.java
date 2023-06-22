package it.unicam.cs.ids.LoyaltyPlatform.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@ToString
@Entity
@Table(name = "programma_cashback")
public class ProgrammaCashbackModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "spesa_minima", nullable = false)
    private double spesaMinima;
    @Column(name = "percentuale_cashback", nullable = false)
    private double percentualeCashback;

    @JoinColumn(name = "id_attivita_commerciale", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private AttivitaCommercialeModel attivitaCommerciale;


    @Column(name = "data_attivazione")
    private LocalDateTime dataAttivazione;

    @Column(name = "flag_elimina", nullable = false)
    private boolean flagElimina;

}
