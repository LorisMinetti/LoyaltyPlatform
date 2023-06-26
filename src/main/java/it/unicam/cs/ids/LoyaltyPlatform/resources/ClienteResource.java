package it.unicam.cs.ids.LoyaltyPlatform.resources;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.ClienteController;
import it.unicam.cs.ids.LoyaltyPlatform.model.ClienteModel;
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
@RequestMapping("/cliente")
public class ClienteResource {

    @Autowired(required = false)
    private ClienteController clienteController;


    @PostMapping("/create")
    public ResponseEntity<ClienteModel> createCliente(@Validated @RequestBody ClienteModel dto) {
        log.debug("REST request to create Cliente: {}", dto);
        ClienteModel result = null;
        try {
            result = this.clienteController.createCliente(dto);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Errore nella creazione del ClienteDTO in ingresso");
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ClienteModel> updateCliente(@Validated @RequestBody ClienteModel dto){
        log.debug("REST request to update Cliente: {}", dto);
        ClienteModel result = null;
        try {
            result = this.clienteController.updateCliente(dto);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Errore nella modifica del ClienteDTO in ingresso");
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCliente(@PathVariable("id") UUID id) {
        log.debug("REST request to delete Cliente: {}", id);
        Boolean result = false;
        try {
            ClienteModel del = clienteController.getById(id);
            result = this.clienteController.deleteCliente(del);
        } catch (Exception e) {
            log.error("Errore nell'eliminazione del CLiente");
        }
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteModel> getCliente(@PathVariable("id") UUID id) {
        log.debug("REST request to delete cliente: {}", id);
        ClienteModel result = null;
        try {
            result = this.clienteController.getById(id);
        } catch (Exception e) {
            log.error("Errore nell'eliminazione del cliente");
        }
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/listaClienti")
    public ResponseEntity<List<ClienteModel>> findAll(){
        List<ClienteModel> ret = new ArrayList<>();
        try{
            ret = this.clienteController.findAll();
        } catch (Exception e){
            log.error("Errore nel recupero della lista Clienti");
        }
        return new ResponseEntity<>(ret, HttpStatus.OK);
    }
}
