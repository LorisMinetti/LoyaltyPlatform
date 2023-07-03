package it.unicam.cs.ids.LoyaltyPlatform.repository;

import it.unicam.cs.ids.LoyaltyPlatform.model.AttivitaCommercialeModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.ClienteModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.NotificaModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
@Transactional
public interface NotificaRepository extends JpaRepository<NotificaModel, UUID>, JpaSpecificationExecutor<NotificaModel> {

    boolean existsById(UUID id);

    NotificaModel getById(UUID id);

    List<NotificaModel> findAllByAttivitaDestinataria(AttivitaCommercialeModel attivita);

    List<NotificaModel> findAllByClienteDestinatario(ClienteModel cliente);

    List<NotificaModel> findAllByDestroyTimeBefore(LocalDateTime now);
}