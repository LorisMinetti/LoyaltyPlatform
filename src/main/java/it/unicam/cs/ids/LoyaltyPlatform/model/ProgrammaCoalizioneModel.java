package it.unicam.cs.ids.LoyaltyPlatform.model;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.AttivitaCommercialeController;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@ToString
public class ProgrammaCoalizioneModel extends ProgrammaFedeltaModel {
    private List<AttivitaCommercialeModel> attivtaCoalizione;
}
