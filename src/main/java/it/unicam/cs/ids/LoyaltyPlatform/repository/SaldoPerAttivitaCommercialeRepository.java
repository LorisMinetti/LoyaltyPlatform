package it.unicam.cs.ids.LoyaltyPlatform.repository;

import it.unicam.cs.ids.LoyaltyPlatform.model.ClienteModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.subModel.SaldoPerAttivitaCommerciale;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Transactional
public interface SaldoPerAttivitaCommercialeRepository extends JpaRepository<SaldoPerAttivitaCommerciale, UUID>, JpaSpecificationExecutor<SaldoPerAttivitaCommerciale> {
    @Modifying
    @Query(value = "UPDATE #{#entityName} d SET d.flagElimina = true WHERE d.id = ?1")
    void setFlagDelete(UUID id);

    boolean existsByIdAndFlagEliminaIsFalse(UUID id);

    SaldoPerAttivitaCommerciale getByIdAndFlagEliminaIsFalse(UUID id);

    List<SaldoPerAttivitaCommerciale> findAllByCliente(ClienteModel cliente);

}