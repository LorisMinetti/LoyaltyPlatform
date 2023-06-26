package it.unicam.cs.ids.LoyaltyPlatform.repository;

import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaALivelliModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProgrammaALivelliRepository extends JpaRepository<ProgrammaALivelliModel, UUID>, JpaSpecificationExecutor<ProgrammaALivelliModel> {

    @Modifying
    @Query(value = "UPDATE #{#entityName} d SET d.flagElimina = true WHERE d.id = ?1")
    void setFlagDelete(UUID id);

    boolean existsByIdAndFlagEliminaIsFalse(UUID id);

    ProgrammaALivelliModel getByIdAndFlagEliminaIsFalse(UUID id);

}
