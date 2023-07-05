package it.unicam.cs.ids.LoyaltyPlatform.model;

import it.unicam.cs.ids.LoyaltyPlatform.model.subModel.PuntiPerAttivitaCommerciale;
import it.unicam.cs.ids.LoyaltyPlatform.model.subModel.SaldoPerAttivitaCommerciale;
import it.unicam.cs.ids.LoyaltyPlatform.model.subModel.SpesaTotalePerAttivitaCommerciale;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Data
@Table(name = "cliente")
@Entity
@Accessors(chain = true)
public class ClienteModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "nome")
    private String nome;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @OneToMany( mappedBy = "cliente")
    private Set<SpesaTotalePerAttivitaCommerciale> spesaTotalePerAttivitaCommerciale;

    //private Set<ProgrammaALivelliModel, Integer> livelloPerAttivitaCommerciale;

    @OneToMany( mappedBy = "cliente")
    private Set<PuntiPerAttivitaCommerciale> puntiPerAttivitaCommerciale;

    @OneToMany(mappedBy = "cliente")
    private Set<SaldoPerAttivitaCommerciale> saldoPerAttivitaCommerciale;

    @Column(name = "flagElimina")
    private boolean flagElimina;

}
