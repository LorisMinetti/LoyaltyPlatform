package it.unicam.cs.ids.LoyaltyPlatform.model;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.AttivitaCommercialeController;
import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.ClienteController;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.UUID;

@Data
@EqualsAndHashCode
@ToString
public class AcquistoModel {
    private double valoreAcquisto;
    private UUID id;
    private ClienteModel clienteModel;
    private AttivitaCommercialeModel attivitaCommercialeModel;


}
