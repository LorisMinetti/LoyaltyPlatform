package it.unicam.cs.ids.LoyaltyPlatform.controller;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.ProgrammaCashbackController;
import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaCashbackModel;
import it.unicam.cs.ids.LoyaltyPlatform.repository.ProgrammaCashbackRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Slf4j
@Service
public class ProgrammaCashbackControllerImpl implements ProgrammaCashbackController {

    @Autowired
    private ProgrammaCashbackRepository programmaCashbackRepository;


    @Override
    public ProgrammaCashbackModel createProgrammaCashback(ProgrammaCashbackModel programmaCashbackModel) {
        if(programmaCashbackModel.getId() != null) {
            log.error("Tentativo di creazione di un cliente con id già presente");
        }
        try{
            programmaCashbackModel.setDataAttivazione(LocalDateTime.now());
            return programmaCashbackRepository.save(programmaCashbackModel);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            log.error("Errore durante la creazione di un programmaCashback");
            return null;
        }
    }

    @Override
    public ProgrammaCashbackModel updateProgrammaCashback(ProgrammaCashbackModel programmaCashbackModel) {
        if(programmaCashbackModel.getId() == null) {
            log.error("Tentativo di aggiornamento di un cliente senza id");
        }
        try{
            return programmaCashbackRepository.save(programmaCashbackModel);
        } catch (Exception e) {
            log.error("Errore durante l'aggiornamento di un cliente");
            return null;
        }
    }

    @Override
    public boolean deleteProgrammaCashback(ProgrammaCashbackModel programmaCashbackModel) {
        if(!programmaCashbackRepository.existsByIdAndFlagEliminaIsFalse(programmaCashbackModel.getId())){
            log.error("Tentativo di eliminazione di un cliente non presente");
            return false;
        }
        try{
            programmaCashbackRepository.setFlagDelete(programmaCashbackModel.getId());
            return true;
        } catch (Exception e) {
            log.error("Errore durante l'eliminazione di un cliente");
            e.printStackTrace();
            return false;
        }    }

    @Override
    public ProgrammaCashbackModel getById(UUID id) {
        ProgrammaCashbackModel ret = null;
        try{
            ret = programmaCashbackRepository.getByIdAndFlagEliminaIsFalse(id);
        } catch (Exception e){
            e.printStackTrace();
            log.error("Errore nel recupero del cliente per Id");
        }
        return ret;
    }

    @Override
    public List<ProgrammaCashbackModel> findAll() {
        List<ProgrammaCashbackModel> ret = new ArrayList<>();
        try{
            ret = this.programmaCashbackRepository.findAll();
        } catch (Exception e){
            e.printStackTrace();
            log.error("Errore nel recupero della lista dei clienti");
        }
        return ret;    }
}
