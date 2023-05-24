package it.unicam.cs.ids.LoyaltyPlatform.model;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Cliente implements it.unicam.cs.ids.LoyaltyPlatform.interfaces.Cliente {
    private String nome;
    private UUID id;
    private Map<AttivitaCommerciale, Double> spesaTotalePerAttivitaCommerciale;
    private Map<ProgrammaALivelli, Integer> livelloPerAttivitaCommerciale;
    private Map<ProgrammaAPunti, Integer> puntiPerAttivitaCommerciale;
    private Map<ProgrammaCashback, Double> saldoPerAttivitaCommerciale;
    @Override
    public Acquisto effettuaAcquistoInLoco() {
        return null;
    }

    @Override
    public Acquisto effettuaAcquistoOnline() {
        return null;
    }

    @Override
    public boolean effettuaPagamento() {
        return false;
    }
}
