package it.unicam.cs.ids.LoyaltyPlatform.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class NotificaModel<D> extends MessaggioModel {
    private List<D> destinatari;
}
