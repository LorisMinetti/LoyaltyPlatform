package it.unicam.cs.ids.LoyaltyPlatform.model;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class ProgrammaFedelta {
    private String nome;
    private UUID id;
    private double costo;
}
