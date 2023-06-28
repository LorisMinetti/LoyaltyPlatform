package it.unicam.cs.ids.LoyaltyPlatform.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.UUID;

@Data
@Accessors(chain = true)
@Table(name = "programma_fedelta")
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

    @Column(name ="selezionabile", nullable = false)
    private boolean selezionabile;

    @Column(name = "flag_elimina", nullable = false)
    private boolean flagElimina;

}
