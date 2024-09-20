package com.Bank.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

//import com.Bank.Controller.BankController.InsufficientBalanceException;
import com.Bank.Dto.AccountDto;
import com.Bank.Dto.DepositDto;
import com.Bank.Dto.WithdrawDto;
import com.Bank.Entity.Accounts;
import com.Bank.Repo.AccountRepository;
import com.Bank.Service.BankService;
import com.Bank.mapper.AccountMapper;


@Service
public class BankServiceImpl implements BankService {
	
	
	private AccountRepository repo;

	public BankServiceImpl(AccountRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		Accounts account = AccountMapper.mapToAccount(accountDto);
		Accounts savedAcc = repo.save(account);
		
		return AccountMapper.mapToAccountDto(savedAcc); 
	}

	@Override
	public AccountDto getAccoutDetailsById(int id) {
		Optional<Accounts> acc = repo.findById(id);
		if(acc.isEmpty()) {
			throw new RuntimeException("Account is not present");
		}
		Accounts account_found = acc.get(); 
		return AccountMapper.mapToAccountDto(account_found);
	}
	

	@Override
	public List<AccountDto> getAllAccounts(){
		
		//First create a list for Accounts class.
		//Find all account present in database using findAll()
		//Add each row as an object into the list
		List<Accounts> list = repo.findAll();
		
		//Create another list for class AccountDto
		List<AccountDto> AccDtoList = new ArrayList<>();
		
		//Now using for loop create instance of AccountDto class
		//and using mapToAccountDto() map the values of one class to another class.
		//Finally, using add method one by one add the objects into to list of type AccountDto.
		for(Accounts acc : list) {
			AccountDto accD = AccountMapper.mapToAccountDto(acc);
			AccDtoList.add(accD);
		}
		 
		return AccDtoList;
	}

	@Override
	public AccountDto depositAmount(int id, DepositDto depoD) {
		
		Optional<Accounts> acc = repo.findById(id);
		if(acc.isEmpty()) {
			throw new RuntimeException("Account is not present");
		}
		Accounts account_found = acc.get();
		long new_balance = account_found.getBalance()+depoD.getAmount();
		account_found.setBalance(new_balance);
		//Till here we are just implementing logic to deposit and check if it is correct using POSTMAN
		//But when we use select query in database we see no change.
		//Now to save this change to reflect in the database as well we have to do following
		repo.save(account_found);
		AccountDto accD = AccountMapper.mapToAccountDto(account_found);
		return accD;
	}

	@Override
	public AccountDto withdrawAmount(int id, WithdrawDto withD) {
		
		Optional<Accounts> acc = repo.findById(id);
		if(acc.isEmpty()) {
			throw new RuntimeException("Account is not present");
		}
		Accounts account_found = acc.get();
		
		//Everything similar to deposit except we have to check that if we have enough balance in account or not using following logic
		if(account_found.getBalance()>=withD.getAmount()) {
			
			long new_balance = account_found.getBalance()-withD.getAmount();
			account_found.setBalance(new_balance);
			
		}else {
			
			System.out.println("Invalid Balance in Account");
			//throw new InsufficientBalanceException("Insufficient balance in account.");
			
		}
		
		repo.save(account_found);
		
		AccountDto accD = AccountMapper.mapToAccountDto(account_found);
		return accD;
	}

	@Override
	public void closeAccount(int id) {
		
		Optional<Accounts> acc = repo.findById(id);
		if(acc.isEmpty()) {
			throw new RuntimeException("Account is not present");
		}
		Accounts account_deleted = acc.get();
		repo.delete(account_deleted);
	}

}
