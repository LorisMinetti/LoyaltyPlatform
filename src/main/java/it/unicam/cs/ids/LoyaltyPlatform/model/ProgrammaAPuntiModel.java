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
@Table(name = "programma_punti")
public class ProgrammaAPuntiModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "spesa_minima", nullable = false)
    private double spesaMinima;

    @Column(name = "rapporto_punti", nullable = false)
    private double rapportoPunti;

    @JoinColumn(name = "id_attivitaCommerciale", referencedColumnName = "id", nullable = false)
    @OneToOne(fetch = FetchType.LAZY)
    private AttivitaCommercialeModel attivitaCommerciale;

    @Column(name = "data_attivazione")
    private LocalDateTime dataAttivazione;

    @Column(name = "flag_elimina", nullable = false)
    private boolean flagElimina;

}
