package it.unicam.cs.ids.LoyaltyPlatform.model;

import jakarta.persistence.Column;
import lombok.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@ToString
public class GestorePiattaformaModel {
    private String nome;
    private UUID id;
    private List<ClienteModel> clientiIscritti;
    private List<AttivitaCommercialeModel> attivitaCommericaliIscritte;
    private Set<ProgrammaFedeltaModel> programmiFedelta;

    @Column(name = "flag_elimina")
    private boolean flagElimina;
}
