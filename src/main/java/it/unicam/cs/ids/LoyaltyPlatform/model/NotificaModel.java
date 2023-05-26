package it.unicam.cs.ids.LoyaltyPlatform.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@EqualsAndHashCode
@ToString
public class NotificaModel<D> extends MessaggioModel {
    private List<D> destinatari;
}
