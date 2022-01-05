package homeloancalculator.dto;

public class LoanResponse {
	private Integer principal;
	private Integer interest;
	private String requestDate;
	
	public Integer getPrincipal() {
		return principal;
	}
	public void setPrincipal(Integer principal)
	{
		this.principal = principal;
	}
	public Integer getInterest() {
		return interest;
	}
	public void setInterest(Integer interest) {
		this.interest = interest;
	}
	public String getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}
	@Override
	public String toString() {
		return "LoanResponse [principal=" + principal + ", interest=" + interest + ", requestDate=" + requestDate + "]";
	}
	
}
