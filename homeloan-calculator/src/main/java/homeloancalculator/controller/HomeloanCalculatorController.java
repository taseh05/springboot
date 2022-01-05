package homeloancalculator.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
	@GetMapping(path="/calcpremium")
	public LoanResponse getData()
	{
		return (new LoanResponse());
	}
	
	
	
}
