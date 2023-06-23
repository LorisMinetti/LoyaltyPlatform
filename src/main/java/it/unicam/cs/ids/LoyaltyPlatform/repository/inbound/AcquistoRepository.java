package it.unicam.cs.ids.LoyaltyPlatform.repository.inbound;

import it.unicam.cs.ids.LoyaltyPlatform.model.AcquistoModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.ClienteModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface AcquistoRepository {

    @Modifying
    @Query(value = "UPDATE #{#entityName} d SET d.flagElimina = true WHERE d.id = ?1")
    void setFlagDelete(UUID id);

    boolean existsByIdAndFlagEliminaIsFalse(UUID id);

    ClienteModel getByIdAndFlagEliminaIsFalse(UUID id);

    List<AcquistoModel> getAllByClienteIdAndFlagEliminaIsFalse(UUID id);

}
