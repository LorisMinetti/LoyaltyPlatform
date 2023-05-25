package it.unicam.cs.ids.LoyaltyPlatform.model;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.AttivitaCommercialeController;
import lombok.Data;

import java.util.List;
@Data
public class ProgrammaCoalizione extends ProgrammaFedelta {
    private List<AttivitaCommercialeController> attivtaCoalizione;
}
