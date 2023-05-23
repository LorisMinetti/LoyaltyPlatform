package it.unicam.cs.ids.LoyaltyPlatform.interfaces;

import it.unicam.cs.ids.LoyaltyPlatform.model.Acquisto;

public interface Cliente {
    Acquisto effettuaAcquistoInLoco();
    Acquisto effettuaAcquistoOnline();
    boolean effettuaPagamento();
}
