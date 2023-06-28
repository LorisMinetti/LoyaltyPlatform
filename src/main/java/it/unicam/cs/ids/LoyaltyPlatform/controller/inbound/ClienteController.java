package it.unicam.cs.ids.LoyaltyPlatform.controller.inbound;

import it.unicam.cs.ids.LoyaltyPlatform.model.ClienteModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.CouponModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.subModel.request.AcquistoRequest;
import it.unicam.cs.ids.LoyaltyPlatform.model.subModel.request.GeneraCouponRequest;

import java.util.List;
import java.util.UUID;

public interface ClienteController {

    ClienteModel createCliente(ClienteModel cliente);

    ClienteModel updateCliente(ClienteModel cliente);

    boolean deleteCliente(ClienteModel cliente);

    ClienteModel getById(UUID id);

    List<ClienteModel> findAll();

    ClienteModel effettuaAcquisto(AcquistoRequest acquistoRequest);

    boolean effettuaPagamento();

    CouponModel generaCoupon(GeneraCouponRequest generaCouponRequest);

}
