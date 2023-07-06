package it.unicam.cs.ids.LoyaltyPlatform.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Data
@Accessors(chain = true)
@Table(name = "gestore_piattaforma")
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
