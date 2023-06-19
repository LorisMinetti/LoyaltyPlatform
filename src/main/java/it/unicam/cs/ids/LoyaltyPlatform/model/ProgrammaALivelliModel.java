package it.unicam.cs.ids.LoyaltyPlatform.model;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

@Data
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
@Entity
public class ProgrammaALivelliModel extends ProgrammaFedeltaModel implements Serializable {
//
//    //ogni indice rappresenterà il livello corrispondente
//    //ogni valore corrisponderà al numero di punti necessari per raggiungere il livello corrispondente
    private double[] livelli;
//
    private int livelloAttuale;
//
//
//    }
}
