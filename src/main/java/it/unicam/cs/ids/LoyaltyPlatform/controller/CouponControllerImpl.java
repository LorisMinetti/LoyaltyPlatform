package it.unicam.cs.ids.LoyaltyPlatform.controller;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.CouponController;
import it.unicam.cs.ids.LoyaltyPlatform.model.ClienteModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.CouponModel;
import it.unicam.cs.ids.LoyaltyPlatform.repository.CouponRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class CouponControllerImpl implements CouponController {

    @Autowired
    private CouponRepository couponRepository;

    @Override
    public CouponModel createCoupon(CouponModel coupon) {
        if(coupon.getId() != null) {
            log.error("Tentativo di creazione di un acquisto con id già presente");
        }
        try{
            coupon.setDataGenerazione(LocalDateTime.now());
            return couponRepository.save(coupon);
        } catch (Exception e) {
            log.error("Errore durante la creazione di un coupon");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public CouponModel updateCoupon(CouponModel coupon) {
        if (coupon.getId() == null) {
            log.error("Tentativo di aggiornamento di un coupon senza id");
        }
        try {
            return couponRepository.save(coupon);
        } catch (Exception e) {
            log.error("Errore durante l'aggiornamento di un coupon");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deleteCoupon(CouponModel coupon) {
        if (!couponRepository.existsByIdAndFlagEliminaIsFalse(coupon.getId())) {
            log.error("Tentativo di eliminazione di un coupon non presente");
            return false;
        }
        try {
            couponRepository.setFlagDelete(coupon.getId());
            return true;
        } catch (Exception e) {
            log.error("Errore durante l'eliminazione di un coupon");
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public CouponModel getById(UUID id) {
        CouponModel ret = null;
        try {
            ret = couponRepository.getByIdAndFlagEliminaIsFalse(id);
        } catch (Exception e) {
            log.error("Errore nel recupero del coupon per id");
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public List<CouponModel> findAll() {
        List<CouponModel> ret = new ArrayList<>();
        try {
            ret = this.couponRepository.findAll();
        } catch (Exception e) {
            log.error("Errore nel recupero della lista dei coupon");
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public List<CouponModel> findAllforCliente(ClienteModel cliente) {
        List<CouponModel> ret = new ArrayList<>();
        try {
            ret = this.couponRepository.findAllByCliente(cliente);
        } catch (Exception e) {
            log.error("Errore nel recupero della lista dei coupon");
            e.printStackTrace();
        }
        return ret;
    }
}
