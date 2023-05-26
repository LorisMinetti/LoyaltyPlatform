package it.unicam.cs.ids.LoyaltyPlatform.repository.inbound;

import it.unicam.cs.ids.LoyaltyPlatform.model.GestorePiattaformaModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.MessaggioModel;

import java.util.UUID;

public interface MessaggioRepository {
    void save(MessaggioModel gestorePiattaformaModel);

    void update(MessaggioModel gestorePiattaformaModel);

    boolean delete(MessaggioModel gestorePiattaformaModel);

    MessaggioModel findById(UUID id);

}
