package it.unicam.cs.ids.LoyaltyPlatform.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.UUID;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
@Entity
public class ProgrammaFedeltaModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "costo", nullable = false)
    private double costo;

//    @JoinColumn(name = "id_attivita_commerciale", referencedColumnName = "id", nullable = false)
//    @ManyToOne(cascade = CascadeType.PERSIST)
//    @Fetch(FetchMode.SELECT)
//    private AttivitaCommercialeModel attivitaCommerciale;

    @Column(name ="selezionabile", nullable = false)
    private boolean selezionabile;

    @Column(name = "flag_elimina", nullable = false)
    private boolean flagElimina;
}
