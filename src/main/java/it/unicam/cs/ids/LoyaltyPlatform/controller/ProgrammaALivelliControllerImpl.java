package it.unicam.cs.ids.LoyaltyPlatform.controller;

//@Slf4j
//@Service
public class ProgrammaALivelliControllerImpl {
//    @Autowired
//    private ProgrammaALivelliRepository programmaALivelliRepository;
//    @Autowired
//    private ProgrammaFedeltaRepository programmaFedeltaRepository;
//
//
//    @Override
//    public ProgrammaALivelliModel createProgrammaALivelli(ProgrammaALivelliModel programmaALivelliModel) {
//        if(programmaALivelliModel.getId() != null) {
//            log.error("Tentativo di creazione di un ProgrammaALivelli con id già presente");
//        }
//        try{
//            programmaALivelliModel.setDataAttivazione(LocalDateTime.now());
//            return programmaALivelliRepository.save(programmaALivelliModel);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            log.error("Errore durante la creazione di un programmaALivelli");
//            return null;
//        }
//    }
//
//    @Override
//    public ProgrammaALivelliModel updateProgrammaALivelli(ProgrammaALivelliModel programmaALivelliModel) {
//        if(programmaALivelliModel.getId() == null) {
//            log.error("Tentativo di aggiornamento di un ProgrammaALivelli senza id");
//        }
//        try{
//            return programmaALivelliRepository.save(programmaALivelliModel);
//        } catch (Exception e) {
//            log.error("Errore durante l'aggiornamento di un ProgrammaALivelli");
//            return null;
//        }     }
//
//    @Override
//    public boolean deleteProgrammaALivelli(ProgrammaALivelliModel programmaALivelliModel) {
//        if(!programmaALivelliRepository.existsByIdAndFlagEliminaIsFalse(programmaALivelliModel.getId())){
//            log.error("Tentativo di eliminazione di un ProgrammaALivelli non presente");
//            return false;
//        }
//        try{
//            programmaALivelliRepository.setFlagDelete(programmaALivelliModel.getId());
//            return true;
//        } catch (Exception e) {
//            log.error("Errore durante l'eliminazione di un ProgrammaALivelli");
//            e.printStackTrace();
//            return false;
//        }      }
//
//    @Override
//    public ProgrammaALivelliModel getById(UUID id) {
//        ProgrammaALivelliModel ret = null;
//        try{
//            ret = programmaALivelliRepository.getByIdAndFlagEliminaIsFalse(id);
//        } catch (Exception e){
//            e.printStackTrace();
//            log.error("Errore nel recupero del ProgrammaALivelli per Id");
//        }
//        return ret;
//    }
//
//    @Override
//    public List<ProgrammaALivelliModel> findAll() {
//        List<ProgrammaALivelliModel> ret = new ArrayList<>();
//        try{
//            ret = this.programmaALivelliRepository.findAll();
//        } catch (Exception e){
//            e.printStackTrace();
//            log.error("Errore nel recupero della lista dei ProgrammaALivelli");
//        }
//        return ret;     }
}
