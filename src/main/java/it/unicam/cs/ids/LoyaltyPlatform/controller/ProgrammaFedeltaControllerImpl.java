package it.unicam.cs.ids.LoyaltyPlatform.controller;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.ProgrammaFedeltaController;
import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaFedeltaModel;
import it.unicam.cs.ids.LoyaltyPlatform.repository.ProgrammaFedeltaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class ProgrammaFedeltaControllerImpl implements ProgrammaFedeltaController {

    @Autowired
    private ProgrammaFedeltaRepository programmaFedeltaRepository;

    @Override
    public ProgrammaFedeltaModel createProgrammaFedelta(ProgrammaFedeltaModel programmaFedelta) {
        if(programmaFedelta == null){
            log.error("Errore durante la creazione di un ProgrammaFedeltà. Elemento nullo");
        }
        ProgrammaFedeltaModel ret= null;
        try{
            ret = this.programmaFedeltaRepository.save(programmaFedelta);
        } catch (Exception e) {
            log.debug("Errore di creazione ProgrammaFedelta {}:", programmaFedelta);
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public ProgrammaFedeltaModel updateProgrammaFedelta(ProgrammaFedeltaModel programmaFedelta) {
        if(programmaFedelta.getId() == null){
            log.error("Errore durante la modifica di un ProgrammaFedeltà. Elemento nullo");
        }
        ProgrammaFedeltaModel ret= null;
        try{
            ret = this.programmaFedeltaRepository.save(programmaFedelta);
        } catch (Exception e) {
            log.debug("Errore di modifica ProgrammaFedelta {}:", programmaFedelta);
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public boolean deleteProgrammaFedelta(ProgrammaFedeltaModel programmaFedelta) {
        if( ! this.programmaFedeltaRepository.existsByIdAndFlagEliminaIsFalse(programmaFedelta.getId())) {
            log.error("Errore durante l'eliminazione ProgrammaFedelta {} non presente a DB", programmaFedelta);
        }
        try{
            this.programmaFedeltaRepository.setFlagDelete(programmaFedelta.getId());
            return true;
        } catch(Exception e) {
            log.error("Errore durante l'eliminazione ProgrammaFedelta {}", programmaFedelta);
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public ProgrammaFedeltaModel getById(UUID id) {
        if(!this.programmaFedeltaRepository.existsByIdAndFlagEliminaIsFalse(id)){
            log.error("Errore durante il recupero ProgrammaFedelta");
        }
        ProgrammaFedeltaModel ret = null;
        try{
            ret = this.programmaFedeltaRepository.getByIdAndFlagEliminaIsFalse(id);
        } catch (Exception e) {
            log.error("Errore durante il recupero programmaFedelta");
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public List<ProgrammaFedeltaModel> findAll() {
            List<ProgrammaFedeltaModel> ret = new ArrayList<>();
            try{
                ret = this.programmaFedeltaRepository.findAll();
            } catch (Exception e) {
                log.error("Errore nel recupero della lista dei clienti");
                e.printStackTrace();
            }
            return ret;
    }

    @Override
    public ProgrammaFedeltaModel deSelectable(ProgrammaFedeltaModel programma){
        if(programma == null){
            log.error("Errore durante la deselezione di un ProgrammaFedeltà. Elemento nullo");
        } else if(!this.programmaFedeltaRepository.existsByIdAndFlagEliminaIsFalse(programma.getId())){
            log.error("Errore durante la deselezione di un ProgrammaFedeltà. Elemento non presente a DB");
        }
        if(programma.isSelezionabile()){
            programma.setSelezionabile(false);
        } else {
            log.warn("ProgrammaFedeltà già NON selezionabile");
        }
        try{
            return this.updateProgrammaFedelta(programma);
        } catch (Exception e){
            log.error("Errore durante la deselezione di un ProgrammaFedeltà");
            e.printStackTrace();
            return null;
        }
    }

}
