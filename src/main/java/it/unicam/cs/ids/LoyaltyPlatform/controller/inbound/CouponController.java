package it.unicam.cs.ids.LoyaltyPlatform.controller.inbound;

import it.unicam.cs.ids.LoyaltyPlatform.model.AcquistoModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.ClienteModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.CouponModel;

import java.util.List;
import java.util.UUID;

public interface CouponController {

    CouponModel createCoupon(CouponModel couponModel);

    CouponModel updateCoupon(CouponModel couponModel);

    boolean deleteCoupon(CouponModel couponModel);

    CouponModel getById(UUID id);

    List<CouponModel> findAll();

    List<CouponModel> findAllforCliente(ClienteModel cliente);

}
