package com.Bank.mapper;

import com.Bank.Dto.AccountDto;
import com.Bank.Entity.Accounts;

public class AccountMapper {
	
	public static Accounts mapToAccount(AccountDto accountDto) {
		
		Accounts account = new Accounts(
				accountDto.getId(),
				accountDto.getAccountHolder(),
				accountDto.getBalance()
				);
		
		return account;
		
	}
	
	public static AccountDto mapToAccountDto(Accounts account) {
			
			AccountDto accountDto = new AccountDto(
					account.getId(),
					account.getAccountHolder(),
					account.getBalance()
					);
			
			return accountDto;
			
		}

}
