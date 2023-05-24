package it.unicam.cs.ids.LoyaltyPlatform.model;

import java.util.List;
import java.util.UUID;

public class AttivitaCommerciale implements it.unicam.cs.ids.LoyaltyPlatform.interfaces.AttivitaCommerciale {
    private String nome;
    private UUID id;
    private String partitaIVA;
    private List<ProgrammaFedelta> programmiFedeltaAcquisiti;
    @Override
    public ProgrammaFedelta aderisciProgrammaFedelta() {
        return null;
    }

    @Override
    public List<ProgrammaFedelta> getAvailablePrograms() {
        return null;
    }

    @Override
    public void selezionaProgrammaFedelta(ProgrammaFedelta programmaFedelta) {

    }
}
