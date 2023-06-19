package it.unicam.cs.ids.LoyaltyPlatform.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.AbstractAuditable;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Data
@EqualsAndHashCode
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
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


    @OneToMany(mappedBy = "attivitaCommerciale", cascade = CascadeType.PERSIST)
    @Fetch(FetchMode.SELECT)
    private Set<ProgrammaFedeltaModel> programmiFedeltaAderiti;

}
