package it.unicam.cs.ids.LoyaltyPlatform.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
@Entity
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
    @JoinColumn(name = "id_attivita_commerciale", referencedColumnName = "id", nullable = false)
    @ManyToOne(cascade = CascadeType.PERSIST)
    @Fetch(FetchMode.SELECT)
    private AttivitaCommercialeModel attivitaCommerciale;

    @Column(name = "data_attivazione")
    private LocalDateTime dataAttivazione;

    @Column(name = "flag_elimina", nullable = false)
    private boolean flagElimina;

}
