package sample.spring.chaptor01.bankapp;

public class FixedDepsoitController {
   private FixedDepositService fixedDepositService;
   
   public FixedDepsoitController(FixedDepositService fixedDepositService) {
	   this.fixedDepositService = fixedDepositService;
   }
   
   public boolean submit() {
	   fixedDepositService.save(...);
   }
   
}
