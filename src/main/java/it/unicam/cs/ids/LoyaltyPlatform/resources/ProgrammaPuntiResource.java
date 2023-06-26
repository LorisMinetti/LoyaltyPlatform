package it.unicam.cs.ids.LoyaltyPlatform.resources;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.ProgrammaAPuntiController;
import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaAPuntiModel;
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
@RequestMapping("/programma-punti")
public class ProgrammaPuntiResource {

    @Autowired
    private ProgrammaAPuntiController programmaAPuntiController;

    @PostMapping("/create")
    public ResponseEntity<ProgrammaAPuntiModel> createAPunti(@Validated @RequestBody ProgrammaAPuntiModel dto) {
        log.debug("REST request to create ProgrammaAPunti: {}", dto);
        ProgrammaAPuntiModel result = null;
        try {
            result = this.programmaAPuntiController.createProgrammaAPunti(dto);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Errore nella creazione del ProgrammaAPunti in ingresso");
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ProgrammaAPuntiModel> updateAPunti(@Validated @RequestBody ProgrammaAPuntiModel dto){
        log.debug("REST request to update APunti: {}", dto);
        ProgrammaAPuntiModel result = null;
        try {
            result = this.programmaAPuntiController.updateProgrammaAPunti(dto);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Errore nella modifica del APuntiDTO in ingresso");
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteAPunti(@PathVariable("id") UUID id) {
        log.debug("REST request to delete APunti: {}", id);
        Boolean result = false;
        try {
            ProgrammaAPuntiModel del = programmaAPuntiController.getById(id);
            result = this.programmaAPuntiController.deleteProgrammaAPunti(del);
        } catch (Exception e) {
            log.error("Errore nell'eliminazione del APunti");
        }
        return ResponseEntity.ok().body(result);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProgrammaAPuntiModel> getAPunti(@PathVariable("id") UUID id) {
        log.debug("REST request to delete ProgFedelta: {}", id);
        ProgrammaAPuntiModel result = null;
        try {
            result = this.programmaAPuntiController.getById(id);
        } catch (Exception e) {
            log.error("Errore nell'eliminazione del ProgFedelta");
        }
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProgrammaAPuntiModel>> findAll(){
        List<ProgrammaAPuntiModel> ret = new ArrayList<>();
        try{
            ret = this.programmaAPuntiController.findAll();
        } catch (Exception e){
            log.error("Errore nel recupero della lista APunti");
        }
        return new ResponseEntity<>(ret, HttpStatus.OK);
    }
}
