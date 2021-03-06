package homeloancalculator.controller;


import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import homeloancalculator.dto.LoanRequest;
import homeloancalculator.dto.LoanResponse;


@RestController
public class HomeloanCalculatorController {
	private static Logger log = LoggerFactory.getLogger(HomeloanCalculatorController.class); 

	@GetMapping(path="/health")
	public String health() {
		log.info("In /health endpoint");
		return "server is up";
		/*return new ResponseEntity<>(
				"server is up", 
			      HttpStatus.OK);*/
	}
	//ResponseEntity<
	@PostMapping(path="/calcpremium")
	public LoanResponse calculatePremium(@RequestBody LoanRequest loanRequest)
	{

		log.info("{}",loanRequest);
		Integer principal=loanRequest.getLoanAmount();
		Integer roi=loanRequest.getRateOfinterest();
		Integer time=loanRequest.getTenure()*12;
		Double p= (principal * roi) / (1 - Math.pow(1 + roi, -time));
		log.info("{}",p);	
		LoanResponse loanresponse=new LoanResponse();
		loanresponse.setPrincipal(p);
		loanresponse.setInterest(50000);
		loanresponse.setRequestDate(String.valueOf(new Date()));
		return loanresponse;
	}



}
