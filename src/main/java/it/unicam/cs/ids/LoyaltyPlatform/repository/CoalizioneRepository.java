package it.unicam.cs.ids.LoyaltyPlatform.repository;

import it.unicam.cs.ids.LoyaltyPlatform.model.AttivitaCommercialeModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.CoalizioneModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import java.util.stream.Stream;

@Repository
@Transactional
public interface CoalizioneRepository extends JpaRepository<CoalizioneModel, UUID>, JpaSpecificationExecutor<CoalizioneModel> {

    @Modifying
    @Query(value = "UPDATE #{#entityName} d SET d.flagElimina = true WHERE d.id = ?1")
    void setFlagDelete(UUID id);

    boolean existsByIdAndFlagEliminaIsFalse(UUID id);

    CoalizioneModel getByIdAndFlagEliminaIsFalse(UUID id);

    boolean existsByAttivitaCommerciale1AndAndAttivitaCommerciale2AndFlagEliminaIsFalse(AttivitaCommercialeModel attivita1, AttivitaCommercialeModel attivita2);

    default CoalizioneModel getByAttivitaId(UUID attivitaId) {
        return findAll().stream()
                .filter(coalizione -> isAttivitaPresente(coalizione, attivitaId))
                .findFirst()
                .orElse(null);
    }
    default boolean existsByAttivitaId(UUID attivitaId) {
        return findAll().stream()
                .anyMatch(coalizione -> isAttivitaPresente(coalizione, attivitaId));
    }
    default boolean isAttivitaPresente(CoalizioneModel coalizione, UUID attivitaId) {
        return Stream.of(
                coalizione.getAttivitaCommerciale1(),
                coalizione.getAttivitaCommerciale2(),
                coalizione.getAttivitaCommerciale3(),
                coalizione.getAttivitaCommerciale4()
        ).anyMatch(attivita -> attivita != null && attivita.getId().equals(attivitaId));
    }
}
