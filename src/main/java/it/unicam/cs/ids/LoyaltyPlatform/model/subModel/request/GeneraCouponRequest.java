package it.unicam.cs.ids.LoyaltyPlatform.model.subModel.request;

import lombok.Data;

import java.util.UUID;

@Data
public class GeneraCouponRequest {

    UUID idCliente;
    UUID idAttivitaCommerciale;
    double puntiConvertiti;
}
