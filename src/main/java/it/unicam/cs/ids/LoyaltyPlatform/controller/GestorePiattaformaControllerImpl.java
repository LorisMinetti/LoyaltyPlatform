package it.unicam.cs.ids.LoyaltyPlatform.controller;

import it.unicam.cs.ids.LoyaltyPlatform.controller.inbound.GestorePiattaformaController;
import it.unicam.cs.ids.LoyaltyPlatform.model.GestorePiattaformaModel;
import it.unicam.cs.ids.LoyaltyPlatform.model.ProgrammaFedeltaModel;
import it.unicam.cs.ids.LoyaltyPlatform.repository.GestorePiattaformaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class GestorePiattaformaControllerImpl implements GestorePiattaformaController {

    @Autowired(required = false)
    private GestorePiattaformaRepository gestorePiattaformaRepository;



    @Override
    public ProgrammaFedeltaModel aggiungiProgrammaFedelta() {
        return null;
    }

    @Override
    public List<ProgrammaFedeltaModel> getAllProgrammiFedelta() {
        return null;
    }

    @Override
    public void selezionaProgrammaFedelta(ProgrammaFedeltaModel programmaFedeltaModel) {

    }

    @Override
    public GestorePiattaformaModel createGestorePiattaforma(GestorePiattaformaModel gestorePiattaforma) {
        return null;
    }

    @Override
    public GestorePiattaformaModel updateGestorePiattaforma(GestorePiattaformaModel gestorePiattaforma) {
        return null;
    }

    @Override
    public boolean deleteGestorePiattaforma(GestorePiattaformaModel gestorePiattaforma) {
        return false;
    }

    @Override
    public GestorePiattaformaModel getById(UUID id) {
        return null;
    }
}
