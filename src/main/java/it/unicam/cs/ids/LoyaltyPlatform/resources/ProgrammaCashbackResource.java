package it.unicam.cs.ids.LoyaltyPlatform.resources;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.ProgrammaCashbackController;
import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaCashbackModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/programma-cashback")
public class ProgrammaCashbackResource {

    @Autowired
    private ProgrammaCashbackController programmaCashbackController;


    @PostMapping("/create")
    public ResponseEntity<ProgrammaCashbackModel> createCashback(@Validated @RequestBody ProgrammaCashbackModel dto) {
        log.debug("REST request to create ProgrammaCashback: {}", dto);
        ProgrammaCashbackModel result = null;
        try {
            result = this.programmaCashbackController.createProgrammaCashback(dto);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Errore nella creazione del ProgrammaCashback in ingresso");
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ProgrammaCashbackModel> updateCashback(@Validated @RequestBody ProgrammaCashbackModel dto){
        log.debug("REST request to update Cashback: {}", dto);
        ProgrammaCashbackModel result = null;
        try {
            result = this.programmaCashbackController.updateProgrammaCashback(dto);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Errore nella modifica del CashbackDTO in ingresso");
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCashback(@PathVariable("id") UUID id) {
        log.debug("REST request to delete Cashback: {}", id);
        Boolean result = false;
        try {
            ProgrammaCashbackModel del = programmaCashbackController.getById(id);
            result = this.programmaCashbackController.deleteProgrammaCashback(del);
        } catch (Exception e) {
            log.error("Errore nell'eliminazione del Cashback");
        }
        return ResponseEntity.ok().body(result);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProgrammaCashbackModel> getCashback(@PathVariable("id") UUID id) {
        log.debug("REST request to delete ProgFedelta: {}", id);
        ProgrammaCashbackModel result = null;
        try {
            result = this.programmaCashbackController.getById(id);
        } catch (Exception e) {
            log.error("Errore nell'eliminazione del ProgFedelta");
        }
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProgrammaCashbackModel>> findAll(){
        List<ProgrammaCashbackModel> ret = new ArrayList<>();
        try{
            ret = this.programmaCashbackController.findAll();
        } catch (Exception e){
            log.error("Errore nel recupero della lista Cashback");
        }
        return new ResponseEntity<>(ret, HttpStatus.OK);
    }
}
