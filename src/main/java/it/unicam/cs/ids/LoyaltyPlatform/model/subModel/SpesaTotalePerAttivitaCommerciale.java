package it.unicam.cs.ids.LoyaltyPlatform.model.subModel;

import it.unicam.cs.ids.LoyaltyPlatform.model.AttivitaCommercialeModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.ClienteModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@Table(name = "spesa_totale_per_attivita_commerciale")
@Accessors(chain = true)
public class SpesaTotalePerAttivitaCommerciale implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.PERSIST)
    @Fetch(FetchMode.SELECT)
    private ClienteModel cliente;
    @JoinColumn(name = "id_attivita_commerciale", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.PERSIST)
    @Fetch(FetchMode.SELECT)
    private AttivitaCommercialeModel attivitaCommerciale;

    @Column(name = "spesa_totale")
    private Double spesaTotale;
}
