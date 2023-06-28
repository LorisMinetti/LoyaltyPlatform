package it.unicam.cs.ids.LoyaltyPlatform.resources;

//@Slf4j
//@RestController
//@RequestMapping("/programma-livelli")
public class ProgrammaLivelliResource {
//    @Autowired
//    private ProgrammaALivelliController programmaALivelliController;
//
//    @PostMapping("/create")
//    public ResponseEntity<ProgrammaALivelliModel> createALivelli(@Validated @RequestBody ProgrammaALivelliModel dto) {
//        log.debug("REST request to create ProgrammaALivelli: {}", dto);
//        ProgrammaALivelliModel result = null;
//        try {
//            result = this.programmaALivelliController.createProgrammaALivelli(dto);
//        } catch (Exception e) {
//            e.printStackTrace();
//            log.error("Errore nella creazione del ProgrammaALivelli in ingresso");
//        }
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }
//
//    @PutMapping("/update")
//    public ResponseEntity<ProgrammaALivelliModel> updateALivelli(@Validated @RequestBody ProgrammaALivelliModel dto){
//        log.debug("REST request to update ALivelli: {}", dto);
//        ProgrammaALivelliModel result = null;
//        try {
//            result = this.programmaALivelliController.updateProgrammaALivelli(dto);
//        } catch (Exception e) {
//            e.printStackTrace();
//            log.error("Errore nella modifica del ALivelliDTO in ingresso");
//        }
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Boolean> deleteALivelli(@PathVariable("id") UUID id) {
//        log.debug("REST request to delete ALivelli: {}", id);
//        Boolean result = false;
//        try {
//            ProgrammaALivelliModel del = programmaALivelliController.getById(id);
//            result = this.programmaALivelliController.deleteProgrammaALivelli(del);
//        } catch (Exception e) {
//            log.error("Errore nell'eliminazione del ALivelli");
//        }
//        return ResponseEntity.ok().body(result);
//    }
//
//
//    @GetMapping("/{id}")
//    public ResponseEntity<ProgrammaALivelliModel> getALivelli(@PathVariable("id") UUID id) {
//        log.debug("REST request to delete ProgFedelta: {}", id);
//        ProgrammaALivelliModel result = null;
//        try {
//            result = this.programmaALivelliController.getById(id);
//        } catch (Exception e) {
//            log.error("Errore nell'eliminazione del ProgFedelta");
//        }
//        return ResponseEntity.ok().body(result);
//    }
//
//    @GetMapping("/all")
//    public ResponseEntity<List<ProgrammaALivelliModel>> findAll(){
//        List<ProgrammaALivelliModel> ret = new ArrayList<>();
//        try{
//            ret = this.programmaALivelliController.findAll();
//        } catch (Exception e){
//            log.error("Errore nel recupero della lista ALivelli");
//        }
//        return new ResponseEntity<>(ret, HttpStatus.OK);
//    }
}
