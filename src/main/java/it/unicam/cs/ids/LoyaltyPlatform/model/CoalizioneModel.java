package it.unicam.cs.ids.LoyaltyPlatform.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.UUID;

@Data
@Table(name = "coalizione")
@Entity
@Accessors(chain = true)
public class CoalizioneModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "numero_attivita_presenti")
    private int numeroAttivita = 0;

    private int consensiAttivita = 0;

    private boolean consensoGestore;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "nome")
    private String nome;

    @JoinColumn(name = "id_attivita_commerciale", referencedColumnName = "id")
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private AttivitaCommercialeModel attivitaCommerciale1;

    @JoinColumn(name = "id_attivita_commerciale", referencedColumnName = "id")
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private AttivitaCommercialeModel attivitaCommerciale2;

    @JoinColumn(name = "id_attivita_commerciale", referencedColumnName = "id")
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private AttivitaCommercialeModel attivitaCommerciale3;

    @JoinColumn(name = "id_attivita_commerciale", referencedColumnName = "id")
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private AttivitaCommercialeModel attivitaCommerciale4;

    @JoinColumn(name = "id_attivita_commerciale", referencedColumnName = "id")
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private AttivitaCommercialeModel attivitaCommerciale5;

    @Column(name = "flag_elimina")
    private boolean flagElimina;

}
