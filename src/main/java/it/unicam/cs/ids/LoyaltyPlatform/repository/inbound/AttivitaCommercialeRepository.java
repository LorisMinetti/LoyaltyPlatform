package it.unicam.cs.ids.LoyaltyPlatform.repository.inbound;

import it.unicam.cs.ids.LoyaltyPlatform.model.AttivitaCommercialeModel;

import java.util.UUID;

public interface AttivitaCommercialeRepository {

    AttivitaCommercialeModel save(AttivitaCommercialeModel attivitaCommercialeModel);

    AttivitaCommercialeModel update(AttivitaCommercialeModel attivitaCommercialeModel);

    boolean delete(AttivitaCommercialeModel attivitaCommercialeModel);

    AttivitaCommercialeModel findById(UUID id);

}
