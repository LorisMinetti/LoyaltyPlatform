package it.unicam.cs.ids.LoyaltyPlatform.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

@Data
@Table(name = "adesione_programma_fedelta")
@Entity
@Accessors(chain = true)
public class AdesioneProgrammaFedeltaModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "idAttivitaCommerciale")
    private UUID idAttivitaCommerciale;

    @Column(name = "idProgrammaFedelta")
    private UUID idProgrammaFedelta;

    @Column(name ="data_adesione")
    private LocalDateTime dataAdesione;

    @Column(name = "data_scadenza")
    private LocalDateTime dataScadenza;

    @Column(name = "flagElimina")
    private boolean flagElimina;


    //parametro comune per prog. punti e cashback
    @Column(name = "spesa_minima")
    private Double spesaMinima;

    //TODO
    /*in caso l'array generasse un errore, ricordati che è possibile
    che bisogna ridefinire equals and hashCode
     */
    @Column(name = "livelli")
    private ArrayList<Double> livelli;

    @Column(name = "livello_attuale")
    private Integer livelloAttuale;

    //parametri programma cashback
    @Column(name = "percentuale_cashback")
    private Double percentualeCashback;

    //parametri programma punti
    @Column(name = "rapporto_punti")
    private Double rapportoPunti;

    @Column(name = "rinnovo_automatico")
    private boolean rinnovoAutomatico = true;      //default true


    @PrePersist
    public void setScadenza() {
        if (dataAdesione != null) {
            dataScadenza = dataAdesione.plusYears(1);
        }
    }



}
