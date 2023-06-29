package it.unicam.cs.ids.LoyaltyPlatform.controller.inbound;

import it.unicam.cs.ids.LoyaltyPlatform.model.CoalizioneModel;

import java.util.List;
import java.util.UUID;

public interface CoalizioneController {

    CoalizioneModel createCoalizione(CoalizioneModel coalizioneModel);

    CoalizioneModel updateCoalizione(CoalizioneModel coalizioneModel);

    boolean deleteCoalizione(CoalizioneModel coalizioneModel);

    CoalizioneModel getById(UUID id);

    List<CoalizioneModel> findAll();

}
