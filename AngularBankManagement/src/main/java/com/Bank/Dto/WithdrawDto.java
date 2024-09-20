package com.Bank.Dto;

public class WithdrawDto {
	
	private AccountDto accountD;
	private long amount;
	public AccountDto getAccountD() {
		return accountD;
	}
	public void setAccountD(AccountDto accountD) {
		this.accountD = accountD;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	
	

}
