package it.unicam.cs.ids.LoyaltyPlatform.model;

import it.unicam.cs.ids.LoyaltyPlatform.interfaces.AttivitaCommerciale;
import it.unicam.cs.ids.LoyaltyPlatform.interfaces.Cliente;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.UUID;

@Data
@EqualsAndHashCode
@ToString
public class Acquisto {
    private double valoreAcquisto;
    private UUID id;
    private Cliente cliente;
    private AttivitaCommerciale attivitaCommerciale;


}
