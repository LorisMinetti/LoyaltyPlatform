package it.unicam.cs.ids.LoyaltyPlatform.model.subModel.request;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

@Data
public class ModificaAdesioneRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private UUID idAdesione;
    private Double spesaMinima;
    private ArrayList<Double> livelli;
    private Integer livelloAttuale;
    private Double percentualeCashback;
    private Double rapportoPunti;

}

