package com.Bank.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.juli.logging.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Bank.Dto.AccountDto;
import com.Bank.Dto.DepositDto;
import com.Bank.Dto.WithdrawDto;
import com.Bank.Service.BankService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("accounts")
public class BankController {
	
	private BankService bankservice;
	
	public BankController(BankService bankservice) {
		super();
		this.bankservice = bankservice;
	}

	
	//Rest API for adding new account
	@PostMapping("/create")
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accDto){
		//@RequestMapping => Necessary to add the data into DB
		//Request for mapping the data into database
		return new ResponseEntity<>(bankservice.createAccount(accDto),HttpStatus.CREATED);
	}
		
	@GetMapping("/{id}")
	public AccountDto getDetails(@PathVariable int id){
		
		AccountDto accD = bankservice.getAccoutDetailsById(id);
		System.out.println(accD);
		return accD;
	}
	
	
	
	@GetMapping("/allAccounts")
	public List<AccountDto>getAllAccountsDetails(){
		
		//List<AccountDto>getAllAccountsDetails() 
		//Meaning: creating a method of type AccountDto and returning a list of type AccountDto.
		
		List<AccountDto> acc = bankservice.getAllAccounts();
		return acc;
	}
	
	@PutMapping("/deposit/{id}")
	public AccountDto deposit(@PathVariable int id,@RequestBody DepositDto depositD) {
		
		AccountDto accD = bankservice.depositAmount(id, depositD);

		return accD;
		
	}
	
	@PutMapping("/withdraw/{id}")
	public AccountDto withdraw(@PathVariable int id,@RequestBody WithdrawDto withD) {
		
		AccountDto accD = bankservice.withdrawAmount(id, withD);
		return accD;
		
	}
	
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	public class InsufficientBalanceException extends RuntimeException {
//	    public InsufficientBalanceException(String message) {
//	        super(message);
//	    }
//	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String,Boolean>> delete(@PathVariable int id) {
		
		bankservice.closeAccount(id);
		
		Map<String,Boolean>response = new HashMap<String,Boolean>();
		response.put("delete",Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
	
	//PostMapping to add data in database while GetMapping to just read data from database
	//PutMapping to update the database

}
