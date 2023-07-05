package it.unicam.cs.ids.LoyaltyPlatform.resources;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.AdesioneProgrammaFedeltaController;
import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.AttivitaCommercialeController;
import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.CoalizioneController;
import it.unicam.cs.ids.LoyaltyPlatform.model.AdesioneProgrammaFedeltaModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.AttivitaCommercialeModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.CoalizioneModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.subModel.request.AdesioneProgrammaFedeltaRequest;
import it.unicam.cs.ids.LoyaltyPlatform.model.subModel.request.CoalizioneRequest;
import it.unicam.cs.ids.LoyaltyPlatform.model.subModel.request.ModificaAdesioneRequest;
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
@RequestMapping("/attivita-commerciale")
public class AttivitaCommercialeResource {

    @Autowired
    private AttivitaCommercialeController attivitaCommercialeController;
    @Autowired
    private AdesioneProgrammaFedeltaController adesioneProgrammaFedeltaController;
    @Autowired
    private CoalizioneController coalizioneController;

    @PostMapping("/create")
    public ResponseEntity<AttivitaCommercialeModel> createAttivitaCommerciale(@Validated @RequestBody AttivitaCommercialeModel dto) {
        log.debug("REST request to create AttivitaCommerciale: {}", dto);
        AttivitaCommercialeModel result = null;
        try {
            result = this.attivitaCommercialeController.createAttivitaCommerciale(dto);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Errore nella creazione del AttivitaCommercialeDTO in ingresso");
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<AttivitaCommercialeModel> updateAttivitaCommerciale(@Validated @RequestBody AttivitaCommercialeModel dto){
        log.debug("REST request to update AttivitaCommerciale: {}", dto);
        AttivitaCommercialeModel result = null;
        try {
            result = this.attivitaCommercialeController.updateAttivitaCommerciale(dto);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Errore nella modifica del AttivitaCommercialeDTO in ingresso");
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteAttivitaCommerciale(@PathVariable("id") UUID id) {
        log.debug("REST request to delete AttivitaCommerciale: {}", id);
        Boolean result = false;
        try {
            AttivitaCommercialeModel del = attivitaCommercialeController.getById(id);
            result = this.attivitaCommercialeController.deleteAttivitaCommerciale(del);
        } catch (Exception e) {
            log.error("Errore nell'eliminazione del AttivitaCommerciale");
        }
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AttivitaCommercialeModel> getAttivitaCommerciale(@PathVariable("id") UUID id) {
        log.debug("REST request to delete GestorePiattaforma: {}", id);
        AttivitaCommercialeModel result = null;
        try {
            result = this.attivitaCommercialeController.getById(id);
        } catch (Exception e) {
            log.error("Errore nell'eliminazione dell'AttivitaCommerciale");
        }
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/listaClienti")
    public ResponseEntity<List<AttivitaCommercialeModel>> findAll(){
        List<AttivitaCommercialeModel> ret = new ArrayList<>();
        try{
            ret = this.attivitaCommercialeController.findAll();
        } catch (Exception e){
            log.error("Errore nel recupero della lista AttivitaCommerciali");
        }
        return new ResponseEntity<>(ret, HttpStatus.OK);
    }


    @PostMapping("/aderisci")
    public ResponseEntity<AdesioneProgrammaFedeltaModel> createAdesione(@Validated @RequestBody AdesioneProgrammaFedeltaRequest adesioneRequest) {
        log.debug("REST request to create AdesioneProgrammaFedelta");
        AdesioneProgrammaFedeltaModel result = null;
        try {
            result = this.attivitaCommercialeController.aderisciProgrammaFedelta(adesioneRequest);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Errore nella creazione del AdesioneProgrammaFedeltaDTO in ingresso");
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/modifica-adesione")
    public ResponseEntity<AdesioneProgrammaFedeltaModel> updateAdesione(@Validated @RequestBody ModificaAdesioneRequest request){
        log.debug("REST request to update AdesioneProgrammaFedelta");
        AdesioneProgrammaFedeltaModel result = null;

        try {
            result = this.attivitaCommercialeController.modificaAdesione(request);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Errore nella creazione del AdesioneProgrammaFedeltaDTO in ingresso");
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/disdici/{id}")
    public ResponseEntity<Boolean> disdiciAdesione(@PathVariable("id") UUID id){
        log.debug("REST request to disdici AdesioneProgrammaFedelta");
        AdesioneProgrammaFedeltaModel adesione = adesioneProgrammaFedeltaController.getById(id);
        Boolean result = null;
        try {
            result = attivitaCommercialeController.disdiciAdesione(adesione);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Errore nella disdetta del AdesioneProgrammaFedeltaDTO in ingresso");
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/coalizza")
    public ResponseEntity<CoalizioneModel> coalizza(@RequestBody CoalizioneRequest request){
        log.debug("REST request to coalizza");
        CoalizioneModel result = null;
        try {
            result = attivitaCommercialeController.richiediCoalizzazione(request);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Errore nella coalizione");
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/abbandona-coalizione/{id}")
    public ResponseEntity<CoalizioneModel> abbandonaCoalizione(@PathVariable("id") UUID id){
        if(id == null){
            log.error("Id nullo");
            return null;
        }
        CoalizioneModel ret = null;
        try{

            ret = this.attivitaCommercialeController.abbandonaCoalizione(
                    this.attivitaCommercialeController.getById(id)
            );
        } catch (Exception e){
            e.getMessage();
            e.printStackTrace();
        }
        return new ResponseEntity<>(ret, HttpStatus.OK);
    }

}