package it.unicam.cs.ids.LoyaltyPlatform.interfaces;

import it.unicam.cs.ids.LoyaltyPlatform.model.Acquisto;

public interface Cliente {
    Acquisto effettuaAcquisto(AttivitaCommerciale attivita, double valoreAcquisto);
    boolean effettuaPagamento();

}
