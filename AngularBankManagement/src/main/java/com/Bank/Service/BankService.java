package com.Bank.Service;

import java.util.List;
import com.Bank.Dto.AccountDto;
import com.Bank.Dto.DepositDto;
import com.Bank.Dto.WithdrawDto;

public interface BankService {
	
	public AccountDto createAccount(AccountDto accountDto);
	public AccountDto getAccoutDetailsById(int id);
	public List<AccountDto> getAllAccounts();
	public AccountDto depositAmount(int id,DepositDto depoD);
	public AccountDto withdrawAmount(int id, WithdrawDto withD);
	public void closeAccount(int id);

}
