package it.unicam.cs.ids.LoyaltyPlatform.model;

import it.unicam.cs.ids.LoyaltyPlatform.interfaces.GestorePiattaforma;

import java.util.List;
import java.util.UUID;

public class GestorePiattaformaImpl implements GestorePiattaforma {
    private String nome;
    private UUID id;
    private List<ClienteModel> clientiIscritti;
    private List<AttivitaCommercialeModel> attivitaCommericaliIscritte;
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
