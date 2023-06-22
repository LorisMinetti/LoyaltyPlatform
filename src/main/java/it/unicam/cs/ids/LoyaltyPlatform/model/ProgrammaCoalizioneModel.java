package it.unicam.cs.ids.LoyaltyPlatform.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
@Entity
public class ProgrammaCoalizioneModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column(name = "attivta_coalizione_2")
    private AttivitaCommercialeModel attivtaCoalizione1;

    @Column(name = "attivta_coalizione_2")
    private AttivitaCommercialeModel attivtaCoalizione2;

    @Column(name = "attivta_coalizione_2")
    private AttivitaCommercialeModel attivtaCoalizione3;

    @Column(name = "attivta_coalizione_2")
    private AttivitaCommercialeModel attivtaCoalizione4;

    @Column(name = "data_attivazione")
    private LocalDateTime dataAttivazione;

    @Column(name = "flag_elimina", nullable = false)
    private boolean flagElimina;




}
