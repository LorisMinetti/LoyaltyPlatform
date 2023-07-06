package it.unicam.cs.ids.LoyaltyPlatform.resources;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.GestorePiattaformaController;
import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.ProgrammaFedeltaController;
import it.unicam.cs.ids.LoyaltyPlatform.model.GestorePiattaformaModel;
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
@RequestMapping("/gestore")
public class GestorePiattaformaResource {

    @Autowired
    private GestorePiattaformaController gestorePiattaformaController;
    @Autowired
    private ProgrammaFedeltaController programmaFedeltaController;

    @PostMapping("/create")
    public ResponseEntity<GestorePiattaformaModel> createGestorePiattaforma(@Validated @RequestBody GestorePiattaformaModel dto) {
        log.debug("REST request to create GestorePiattaforma: {}", dto);
        GestorePiattaformaModel result = null;
        try {
            result = this.gestorePiattaformaController.createGestorePiattaforma(dto);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Errore nella creazione del GestorePiattaformaDTO in ingresso");
        }
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<GestorePiattaformaModel> updateGestorePiattaforma(@Validated @RequestBody GestorePiattaformaModel dto) {
        log.debug("REST request to update GestorePiattaforma: {}", dto);
        GestorePiattaformaModel result = null;
        try {
            result = this.gestorePiattaformaController.updateGestorePiattaforma(dto);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Errore nella modifica del GestorePiattaformaDTO in ingresso");
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteGestorePiattaforma(@PathVariable("id") UUID id) {
        log.debug("REST request to delete Gestore Piattaforma: {}", id);
        Boolean result = false;
        try {
            GestorePiattaformaModel del = gestorePiattaformaController.getById(id);
            result = this.gestorePiattaformaController.deleteGestorePiattaforma(del);
        } catch (Exception e) {
            log.error("Errore nell'eliminazione del GestorePiattaforma");
        }
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GestorePiattaformaModel> getGestorePiattaforma(@PathVariable("id") UUID id) {
        log.debug("REST request to delete GestorePiattaforma: {}", id);
        GestorePiattaformaModel result = null;
        try {
            result = this.gestorePiattaformaController.getById(id);
        } catch (Exception e) {
            log.error("Errore nell'eliminazione del GestorePiattaforma");
        }
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/listaGestori")
    public ResponseEntity<List<GestorePiattaformaModel>> findAll(){
        List<GestorePiattaformaModel> ret = new ArrayList<>();
        try{
            ret = this.gestorePiattaformaController.findAll();
        } catch (Exception e) {
            log.error("Errore nel recupero della lista GestorePiattaforma");
        }
        return new ResponseEntity<>(ret, HttpStatus.OK);
    }

    @PostMapping("/aggiungi-programmaFedelta")
    public ResponseEntity<ProgrammaFedeltaModel> aggiungiProgrammaFedelta(@Validated @RequestBody ProgrammaFedeltaModel dto) {
        log.debug("REST request to create ProgrammaFedelta: {}", dto);
        ProgrammaFedeltaModel result = null;
        try {
            result = this.gestorePiattaformaController.aggiungiProgrammaFedelta(dto);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Errore nella creazione del ProgrammaFedeltaDTO in ingresso");
        }
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PutMapping("/rimuovi-programmaFedelta/{id}")
    public ResponseEntity<Boolean> rimuoviProgrammaFedelta(@PathVariable("id") UUID id){
        ProgrammaFedeltaModel dto = programmaFedeltaController.getById(id);
        Boolean result = false;
        try {
            //Se l'operazione del controller va a buon fine, restituisce true
            result = this.gestorePiattaformaController.rimuoviProgrammaFedelta(dto);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Errore nella modifica del ProgrammaFedeltaDTO in ingresso");
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/rendiDisponbibile-programmaFedelta/{id}")
    public ResponseEntity<Boolean> rendiDisponibileProgrammaFedelta(@PathVariable("id") UUID id){
        ProgrammaFedeltaModel dto = programmaFedeltaController.getById(id);
        Boolean result = null;
        try {
            //Se l'operazione del controller va a buon fine, restituisce true
            result = this.gestorePiattaformaController.rendiDisponibile(dto);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Errore nella modifica del ProgrammaFedeltaDTO in ingresso");
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/lista-programmiFedelta")
    public ResponseEntity<List<ProgrammaFedeltaModel>> getAllProgrammiFedelta(){
        List<ProgrammaFedeltaModel> ret = new ArrayList<>();
        try{
            ret = this.gestorePiattaformaController.getAllProgrammiFedelta();
        } catch (Exception e) {
            log.error("Errore nel recupero della lista ProgrammaFedelta");
        }
        return new ResponseEntity<>(ret, HttpStatus.OK);
    }



}
