package it.unicam.cs.ids.LoyaltyPlatform.resources;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.ProgrammaFedeltaController;
import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaFedeltaModel;
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
@RequestMapping("/programma-fedelta")
public class ProgrammaFedeltaResurce {

    @Autowired
    private ProgrammaFedeltaController programmaFedeltaController;

    @PostMapping("/create")
    public ResponseEntity<ProgrammaFedeltaModel> createCliente(@Validated @RequestBody ProgrammaFedeltaModel dto) {
        log.debug("REST request to create ProgrammaFedelta: {}", dto);
        ProgrammaFedeltaModel result = null;
        try {
            result = this.programmaFedeltaController.createProgrammaFedelta(dto);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Errore nella creazione del ProgrammaFedelta in ingresso");
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @PutMapping("/update")
    public ResponseEntity<ProgrammaFedeltaModel> updateCliente(@Validated @RequestBody ProgrammaFedeltaModel dto){
        log.debug("REST request to update ProgFedelta: {}", dto);
        ProgrammaFedeltaModel result = null;
        try {
            result = this.programmaFedeltaController.updateProgrammaFedelta(dto);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Errore nella modifica del ProgFedeltaDTO in ingresso");
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCliente(@PathVariable("id") UUID id) {
        log.debug("REST request to delete ProgFedelta: {}", id);
        Boolean result = false;
        try {
            ProgrammaFedeltaModel del = programmaFedeltaController.getById(id);
            result = this.programmaFedeltaController.deleteProgrammaFedelta(del);
        } catch (Exception e) {
            log.error("Errore nell'eliminazione del ProgFedelta");
        }
        return ResponseEntity.ok().body(result);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProgrammaFedeltaModel> getProgrammaFedelta(@PathVariable("id") UUID id) {
        log.debug("REST request to delete ProgFedelta: {}", id);
        ProgrammaFedeltaModel result = null;
        try {
            result = this.programmaFedeltaController.getById(id);
        } catch (Exception e) {
            log.error("Errore nell'eliminazione del ProgFedelta");
        }
        return ResponseEntity.ok().body(result);
    }


    @GetMapping("/all")
    public ResponseEntity<List<ProgrammaFedeltaModel>> findAll(){
        List<ProgrammaFedeltaModel> ret = new ArrayList<>();
        try{
            ret = this.programmaFedeltaController.findAll();
        } catch (Exception e){
            log.error("Errore nel recupero della lista ProgFedelta");
        }
        return new ResponseEntity<>(ret, HttpStatus.OK);
    }
}
