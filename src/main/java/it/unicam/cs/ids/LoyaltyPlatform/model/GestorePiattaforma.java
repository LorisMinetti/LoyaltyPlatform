package it.unicam.cs.ids.LoyaltyPlatform.model;

import java.util.List;
import java.util.UUID;

public class GestorePiattaforma implements it.unicam.cs.ids.LoyaltyPlatform.interfaces.GestorePiattaforma {
    private String nome;
    private UUID id;
    private List<Cliente> clientiIscritti;
    private List<AttivitaCommerciale> attivitaCommericaliIscritte;
    @Override
    public ProgrammaFedelta aggiungiProgrammaFedelta() {
        return null;
    }

    @Override
    public List<ProgrammaFedelta> getAllProgrammiFedelta() {
        return null;
    }

    @Override
    public void selezionaProgrammaFedelta(ProgrammaFedelta programmaFedelta) {

    }
}
