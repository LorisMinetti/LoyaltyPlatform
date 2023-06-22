package it.unicam.cs.ids.LoyaltyPlatform.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.UUID;

@Data
@Accessors(chain = true)
@ToString
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


    //TODO: dava problemi poichè era collegato a ProgrammiFedelta che non ha più con sè l'attività commerciale
//    @OneToMany(mappedBy = "attivitaCommerciale", cascade = CascadeType.PERSIST)
//    @Fetch(FetchMode.SELECT)
//    private Set<ProgrammaCashbackModel> programmiFedeltaAderiti;


    @Column(name = "flag_elimina")
    private boolean flagElimina;

    @JsonCreator
    public AttivitaCommercialeModel (){}


}
