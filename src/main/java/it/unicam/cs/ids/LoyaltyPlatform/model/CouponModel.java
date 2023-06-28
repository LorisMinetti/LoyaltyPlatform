package it.unicam.cs.ids.LoyaltyPlatform.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Table(name = "coupon")
@Entity
@Accessors (chain = true)
public class CouponModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private ClienteModel cliente;

    @JoinColumn(name = "id_attivita_commerciale", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private AttivitaCommercialeModel attivitaCommerciale;

    @Column(name = "punti_convertiti")
    private double puntiConvertiti;

    @Column(name = "valore_coupon")
    private double valoreCouponInEuro;

    @Column(name = "data_generazione")
    private LocalDateTime dataGenerazione;

    @Column(name = "flag_elimina")
    private boolean flagElimina;

}
