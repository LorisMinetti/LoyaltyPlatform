package it.unicam.cs.ids.LoyaltyPlatform.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Accessors(chain = true)
@Table(name = "notifca")
@Entity
public class NotificaModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @JoinColumn(name = "id_attivita_commerciale", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private AttivitaCommercialeModel attivitaDestinataria;

    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private ClienteModel clienteDestinatario;

    @Column(name = "testo")
    private String testo;

    @Column(name ="oraInvio")
    private LocalDateTime oraInvio;

    @Column(name = "destroy_time")
    private LocalDateTime destroyTime;

    @PrePersist
    void setDestroyTime(){
        if(this.oraInvio != null)
            this.destroyTime = oraInvio.plusMonths(3);
    }
}