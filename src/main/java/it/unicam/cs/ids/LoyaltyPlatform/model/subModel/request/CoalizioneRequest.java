package it.unicam.cs.ids.LoyaltyPlatform.model.subModel.request;

import lombok.Data;

import java.util.UUID;

@Data
public class CoalizioneRequest {
    UUID mittente;
    UUID destinatario;
}
