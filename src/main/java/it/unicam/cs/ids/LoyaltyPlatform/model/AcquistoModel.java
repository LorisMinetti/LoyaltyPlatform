package it.unicam.cs.ids.LoyaltyPlatform.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Table(name = "acquisto")
@Entity
@Accessors(chain = true)
public class AcquistoModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "valore_acquisto")
    private double valoreAcquisto;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private ClienteModel cliente;

    @JoinColumn(name = "id_attivita_commerciale", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private AttivitaCommercialeModel attivitaCommerciale;

    @Column(name ="data_acquisto")
    private LocalDateTime dataAcquisto;

    @Column(name = "flag_elimina")
    private boolean flagElimina;

}
