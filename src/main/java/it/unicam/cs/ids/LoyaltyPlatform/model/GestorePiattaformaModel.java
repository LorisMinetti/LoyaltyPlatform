package it.unicam.cs.ids.LoyaltyPlatform.model;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.GestorePiattaformaController;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Data
@EqualsAndHashCode
@Builder
@ToString
public class GestorePiattaformaModel {
    private String nome;
    private UUID id;
    private List<ClienteModel> clientiIscritti;
    private List<AttivitaCommercialeModel> attivitaCommericaliIscritte;

}
