package it.unicam.cs.ids.LoyaltyPlatform.repository;

import it.unicam.cs.ids.LoyaltyPlatform.model.ClienteModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.subModel.PuntiPerAttivitaCommerciale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PuntiPerAttivitaCommercialeRepository extends JpaRepository<PuntiPerAttivitaCommerciale, UUID>, JpaSpecificationExecutor<PuntiPerAttivitaCommerciale> {
    @Modifying
    @Query(value = "UPDATE #{#entityName} d SET d.flagElimina = true WHERE d.id = ?1")
    void setFlagDelete(UUID id);

    boolean existsByIdAndFlagEliminaIsFalse(UUID id);

    PuntiPerAttivitaCommerciale getByIdAndFlagEliminaIsFalse(UUID id);

    List<PuntiPerAttivitaCommerciale> findAllByCliente(ClienteModel cliente);
}
