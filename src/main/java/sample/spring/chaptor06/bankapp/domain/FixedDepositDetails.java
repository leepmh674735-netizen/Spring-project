package sample.spring.chaptor06.bankapp.domain;

public class FixedDepositDetails {
	@NotNull
	private long id;
	
	@Min(1000)
	@Max(500000)
	private float depositAmount;
	
	@Min(6)
	private int tenure;
	
	@NotBlank
	@Size(min=5, max= 100)
	private String email;
	
	public FixedDepsitDetails(long id, float depositAmount, int tenure, String email) {
		this.id = id;
		this.depositAmount = depositAmount;
		this.tenure = tenure;
		this.email = email;
	}

}
