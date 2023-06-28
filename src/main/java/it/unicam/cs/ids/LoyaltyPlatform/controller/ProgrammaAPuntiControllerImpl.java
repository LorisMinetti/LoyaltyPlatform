package it.unicam.cs.ids.LoyaltyPlatform.controller;

//
//@Slf4j
//@Service
public class ProgrammaAPuntiControllerImpl  {

//    @Autowired
//    private ProgrammaAPuntiRepository programmaAPuntiRepository;
//
//
//    @Override
//    public ProgrammaAPuntiModel createProgrammaAPunti(ProgrammaAPuntiModel programmaAPuntiModel) {
//        if(programmaAPuntiModel.getId() != null) {
//            log.error("Tentativo di creazione di un ProgrammaAPunti con id già presente");
//        }
//        try{
//            programmaAPuntiModel.setDataAttivazione(LocalDateTime.now());
//            return programmaAPuntiRepository.save(programmaAPuntiModel);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            log.error("Errore durante la creazione di un programmaAPunti");
//            return null;
//        }
//    }
//
//    @Override
//    public ProgrammaAPuntiModel updateProgrammaAPunti(ProgrammaAPuntiModel programmaAPuntiModel) {
//        if(programmaAPuntiModel.getId() == null) {
//            log.error("Tentativo di aggiornamento di un ProgrammaAPunti senza id");
//        }
//        try{
//            return programmaAPuntiRepository.save(programmaAPuntiModel);
//        } catch (Exception e) {
//            log.error("Errore durante l'aggiornamento di un ProgrammaAPunti");
//            return null;
//        }     }
//
//    @Override
//    public boolean deleteProgrammaAPunti(ProgrammaAPuntiModel programmaAPuntiModel) {
//        if(!programmaAPuntiRepository.existsByIdAndFlagEliminaIsFalse(programmaAPuntiModel.getId())){
//            log.error("Tentativo di eliminazione di un ProgrammaAPunti non presente");
//            return false;
//        }
//        try{
//            programmaAPuntiRepository.setFlagDelete(programmaAPuntiModel.getId());
//            return true;
//        } catch (Exception e) {
//            log.error("Errore durante l'eliminazione di un ProgrammaAPunti");
//            e.printStackTrace();
//            return false;
//        }      }
//
//    @Override
//    public ProgrammaAPuntiModel getById(UUID id) {
//        ProgrammaAPuntiModel ret = null;
//        try{
//            ret = programmaAPuntiRepository.getByIdAndFlagEliminaIsFalse(id);
//        } catch (Exception e){
//            e.printStackTrace();
//            log.error("Errore nel recupero del ProgrammaAPunti per Id");
//        }
//        return ret;
//    }
//
//    @Override
//    public List<ProgrammaAPuntiModel> findAll() {
//        List<ProgrammaAPuntiModel> ret = new ArrayList<>();
//        try{
//            ret = this.programmaAPuntiRepository.findAll();
//        } catch (Exception e){
//            e.printStackTrace();
//            log.error("Errore nel recupero della lista dei ProgrammaAPunti");
//        }
//        return ret;     }
}
