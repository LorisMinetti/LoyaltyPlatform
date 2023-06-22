package it.unicam.cs.ids.LoyaltyPlatform.repository.inbound;

import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaCashbackModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProgrammaCashbackRepository extends JpaRepository<ProgrammaCashbackModel, UUID>, JpaSpecificationExecutor<ProgrammaCashbackModel> {

    @Modifying
    @Query(value = "UPDATE #{#entityName} d SET d.flagElimina = true WHERE d.id = ?1")
    void setFlagDelete(UUID id);

    boolean existsByIdAndFlagEliminaIsFalse(UUID id);

    ProgrammaCashbackModel getByIdAndFlagEliminaIsFalse(UUID id);


}
