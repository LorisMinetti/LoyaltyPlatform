package it.unicam.cs.ids.LoyaltyPlatform.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;
import java.util.UUID;

@Data
@Accessors(chain = true)
@Table(name = "attivita_commerciale")
@Entity
public class GestorePiattaformaModel {

    @Column(name = "name")
    private String nome;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    //private Set<ClienteModel> clientiIscritti;

    //private Set<AttivitaCommercialeModel> attivitaCommericaliIscritte;

    //private Set<ProgrammaFedeltaModel> programmiFedelta;

    @Column(name = "flag_elimina")
    private boolean flagElimina;
}
