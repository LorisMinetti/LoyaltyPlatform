package it.unicam.cs.ids.LoyaltyPlatform.model;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.GestorePiattaformaController;

import java.util.List;
import java.util.UUID;

public class GestorePiattaformaModel {
    private String nome;
    private UUID id;
    private List<ClienteModel> clientiIscritti;
    private List<AttivitaCommercialeModel> attivitaCommericaliIscritte;

}
