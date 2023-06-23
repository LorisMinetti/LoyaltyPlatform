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
@NoArgsConstructor
@Accessors(chain = true)
@ToString
@Entity(name = "programma_coalizione")
public class ProgrammaCoalizioneModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "attivta_coalizione_1")
    private AttivitaCommercialeModel attivitaCoalizione1;

    @Column(name = "attivta_coalizione_2")
    private AttivitaCommercialeModel attivitaCoalizione2;

    @Column(name = "attivta_coalizione_3")
    private AttivitaCommercialeModel attivitaCoalizione3;

    @Column(name = "attivta_coalizione_4")
    private AttivitaCommercialeModel attivitaCoalizione4;

    @Column(name = "attivta_coalizione_5")
    private AttivitaCommercialeModel attivitaCoalizione5;

    @Column(name = "data_attivazione")
    private LocalDateTime dataAttivazione;

    @Column(name = "flag_elimina", nullable = false)
    private boolean flagElimina;




}
