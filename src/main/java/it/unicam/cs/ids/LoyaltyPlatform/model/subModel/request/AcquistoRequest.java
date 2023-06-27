package it.unicam.cs.ids.LoyaltyPlatform.model.subModel.request;

import lombok.Data;

import java.util.UUID;

@Data
public class AcquistoRequest {
    private Double valoreAcquisto;
    private UUID idCliente;
    private UUID idAttivitaCommerciale;

}
