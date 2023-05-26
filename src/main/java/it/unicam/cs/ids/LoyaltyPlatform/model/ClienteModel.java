package it.unicam.cs.ids.LoyaltyPlatform.model;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.AttivitaCommercialeController;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Map;
import java.util.UUID;

@Data
@EqualsAndHashCode
@ToString
public class ClienteModel {
    private String nome;
    private UUID id;
    private Map<AttivitaCommercialeController, Double> spesaTotalePerAttivitaCommerciale;
    private Map<ProgrammaALivelliModel, Integer> livelloPerAttivitaCommerciale;
    private Map<ProgrammaAPuntiModel, Integer> puntiPerAttivitaCommerciale;
    private Map<ProgrammaCashbackModel, Double> saldoPerAttivitaCommerciale;


    /*
    Builder Pattern
     */
    public static class Builder{
        private String nome;
        private UUID id;
        private Map<AttivitaCommercialeController, Double> spesaTotalePerAttivitaCommerciale;
        private Map<ProgrammaALivelliModel, Integer> livelloPerAttivitaCommerciale;
        private Map<ProgrammaAPuntiModel, Integer> puntiPerAttivitaCommerciale;
        private Map<ProgrammaCashbackModel, Double> saldoPerAttivitaCommerciale;


        //Metodi setter per i builder

        public Builder nome(String nome){
            this.nome = nome;
            return this;
        }
        public Builder spesaTotalePerAttivitaCommerciale(Map<AttivitaCommercialeController, Double> spesaTotalePerAttivitaCommerciale){
            this.spesaTotalePerAttivitaCommerciale = spesaTotalePerAttivitaCommerciale;
            return this;
        }
        public Builder livelloPerAttivitaCommerciale(Map<ProgrammaALivelliModel, Integer> livelloPerAttivitaCommerciale){
            this.livelloPerAttivitaCommerciale = livelloPerAttivitaCommerciale;
            return this;
        }
        public Builder puntiPerAttivitaCommerciale(Map<ProgrammaAPuntiModel, Integer> puntiPerAttivitaCommerciale){
            this.puntiPerAttivitaCommerciale = puntiPerAttivitaCommerciale;
            return this;
        }
        public Builder saldoPerAttivitaCommerciale(Map<ProgrammaCashbackModel, Double> saldoPerAttivitaCommerciale){
            this.saldoPerAttivitaCommerciale = saldoPerAttivitaCommerciale;
            return this;
        }

        //Metodo build per il builder
        public ClienteModel build(){
            ClienteModel clienteModel = new ClienteModel();
            clienteModel.nome = this.nome;
            clienteModel.spesaTotalePerAttivitaCommerciale = this.spesaTotalePerAttivitaCommerciale;
            clienteModel.livelloPerAttivitaCommerciale = this.livelloPerAttivitaCommerciale;
            clienteModel.puntiPerAttivitaCommerciale = this.puntiPerAttivitaCommerciale;
            clienteModel.saldoPerAttivitaCommerciale = this.saldoPerAttivitaCommerciale;
            return clienteModel;
        }


    }

}
