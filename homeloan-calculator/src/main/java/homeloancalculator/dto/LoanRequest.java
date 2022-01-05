package homeloancalculator.dto;

public class LoanRequest {
	private Integer loanAmount;
	private Integer tenure;
	private Integer rateOfinterest;
	
	public Integer getLoanAmount() {
		return loanAmount;
	}
	
	public void setLoanAmount(Integer loanAmount) {
		this.loanAmount = loanAmount;
	}
	public Integer getTenure() {
		return tenure;
	}
	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}
	public Integer getRateOfinterest() {
		return rateOfinterest;
	}
	public void setRateOfinterest(Integer rateOfinterest) {
		this.rateOfinterest = rateOfinterest;
	}
	@Override
	public String toString() {
		return "LoanRequest [loanAmount=" + loanAmount + ", tenure=" + tenure + ", rateOfinterest=" + rateOfinterest
				+ "]";
	}
}
