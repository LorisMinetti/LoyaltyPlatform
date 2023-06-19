package it.unicam.cs.ids.LoyaltyPlatform.model;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.AttivitaCommercialeController;
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
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
@MappedSuperclass
public class ProgrammaFedeltaModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "costo", nullable = false)
    private double costo;

    @Column(name = "data_attivazione", nullable = false)
    private LocalDateTime dataAttivazione;

    @JoinColumn(name = "id_attivita_commerciale", referencedColumnName = "id", nullable = false)
    @ManyToOne(cascade = CascadeType.PERSIST)
    @Fetch(FetchMode.SELECT)
    private AttivitaCommercialeModel attivitaCommerciale;
}
