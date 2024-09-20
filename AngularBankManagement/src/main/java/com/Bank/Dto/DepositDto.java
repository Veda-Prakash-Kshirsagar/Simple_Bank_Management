package com.Bank.Dto;

public class DepositDto {

	private AccountDto accountD;
	private long amount;

    // Getters and Setters
    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

	public AccountDto getAccountD() {
		return accountD;
	}

	public void setAccountD(AccountDto accountD) {
		this.accountD = accountD;
	}
    
    
}
