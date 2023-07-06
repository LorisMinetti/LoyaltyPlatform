package it.unicam.cs.ids.LoyaltyPlatform.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.Random;
import java.util.UUID;

@Data
@Table(name = "coalizione")
@Entity
@Accessors(chain = true)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CoalizioneModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "numero_attivita_presenti")
    private int numeroAttivita = 0;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "nome")
    private String nome;

    @JoinColumn(name = "id_attivita_commerciale1", referencedColumnName = "id")
    @OneToOne(cascade = CascadeType.PERSIST)
    @Fetch(value = FetchMode.SELECT)
    private AttivitaCommercialeModel attivitaCommerciale1;

    @JoinColumn(name = "id_attivita_commerciale2", referencedColumnName = "id")
    @OneToOne(cascade = CascadeType.PERSIST)
    @Fetch(value = FetchMode.SELECT)
    private AttivitaCommercialeModel attivitaCommerciale2;

    @JoinColumn(name = "id_attivita_commerciale3", referencedColumnName = "id")
    @OneToOne(cascade = CascadeType.PERSIST)
    @Fetch(value = FetchMode.SELECT)
    private AttivitaCommercialeModel attivitaCommerciale3;

    @JoinColumn(name = "id_attivita_commerciale4", referencedColumnName = "id")
    @OneToOne(cascade = CascadeType.PERSIST)
    @Fetch(value = FetchMode.SELECT)
    private AttivitaCommercialeModel attivitaCommerciale4;

    @Column(name = "flag_elimina")
    private boolean flagElimina;


    /**
     * Metodi che generano randomicamente un nome per la coalizione, seguendo un pattern preciso
     */
    @PrePersist
    private void generateRandomString() {
        String pattern = "A##-####";
        this.nome = generateRandomStringWithPattern(pattern);
    }
    private String generateRandomStringWithPattern(String pattern) {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);

            if (c == '#') {
                stringBuilder.append(random.nextInt(10)); // Genera un numero casuale tra 0 e 9
            } else if (c == 'A') {
                stringBuilder.append((char) (random.nextInt(26) + 'A')); // Genera una lettera maiuscola casuale
            } else {
                stringBuilder.append(c);
            }
        }

        return stringBuilder.toString();
    }

}