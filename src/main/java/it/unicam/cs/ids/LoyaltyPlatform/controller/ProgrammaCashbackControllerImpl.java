package it.unicam.cs.ids.LoyaltyPlatform.controller;

//
//@Slf4j
//@Service
public class ProgrammaCashbackControllerImpl {

//    @Autowired
//    private ProgrammaCashbackRepository programmaCashbackRepository;
//
//
//    @Override
//    public ProgrammaCashbackModel createProgrammaCashback(ProgrammaCashbackModel programmaCashbackModel) {
//        if(programmaCashbackModel.getId() != null) {
//            log.error("Tentativo di creazione di un cliente con id già presente");
//        }
//        try{
//            programmaCashbackModel.setDataAttivazione(LocalDateTime.now());
//            return programmaCashbackRepository.save(programmaCashbackModel);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            log.error("Errore durante la creazione di un programmaCashback");
//            return null;
//        }
//    }
//
//    @Override
//    public ProgrammaCashbackModel updateProgrammaCashback(ProgrammaCashbackModel programmaCashbackModel) {
//        if(programmaCashbackModel.getId() == null) {
//            log.error("Tentativo di aggiornamento di un cliente senza id");
//        }
//        try{
//            return programmaCashbackRepository.save(programmaCashbackModel);
//        } catch (Exception e) {
//            log.error("Errore durante l'aggiornamento di un cliente");
//            return null;
//        }
//    }
//
//    @Override
//    public boolean deleteProgrammaCashback(ProgrammaCashbackModel programmaCashbackModel) {
//        if(!programmaCashbackRepository.existsByIdAndFlagEliminaIsFalse(programmaCashbackModel.getId())){
//            log.error("Tentativo di eliminazione di un cliente non presente");
//            return false;
//        }
//        try{
//            programmaCashbackRepository.setFlagDelete(programmaCashbackModel.getId());
//            return true;
//        } catch (Exception e) {
//            log.error("Errore durante l'eliminazione di un cliente");
//            e.printStackTrace();
//            return false;
//        }    }
//
//    @Override
//    public ProgrammaCashbackModel getById(UUID id) {
//        ProgrammaCashbackModel ret = null;
//        try{
//            ret = programmaCashbackRepository.getByIdAndFlagEliminaIsFalse(id);
//        } catch (Exception e){
//            e.printStackTrace();
//            log.error("Errore nel recupero del cliente per Id");
//        }
//        return ret;
//    }
//
//    @Override
//    public List<ProgrammaCashbackModel> findAll() {
//        List<ProgrammaCashbackModel> ret = new ArrayList<>();
//        try{
//            ret = this.programmaCashbackRepository.findAll();
//        } catch (Exception e){
//            e.printStackTrace();
//            log.error("Errore nel recupero della lista dei clienti");
//        }
//        return ret;    }
}
