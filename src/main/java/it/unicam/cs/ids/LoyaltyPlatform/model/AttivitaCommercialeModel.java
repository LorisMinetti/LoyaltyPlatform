package it.unicam.cs.ids.LoyaltyPlatform.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.UUID;

@Data
@Accessors(chain = true)
@Table(name = "attivita_commerciale")
@Entity
public class AttivitaCommercialeModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "nome")
    private String nome;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "partita_iva")
    private String partitaIVA;

    @Column(name = "flag_elimina")
    private boolean flagElimina;

    @Column(name = "coalizzata", nullable = false)
    private boolean coalizzata;

}
