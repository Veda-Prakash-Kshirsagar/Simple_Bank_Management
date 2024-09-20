package com.Bank.Dto;


public class AccountDto {
	
		private int id;
		private String AccountHolder;
		private long balance;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getAccountHolder() {
			return AccountHolder;
		}
		public void setAccountHolder(String accountHolder) {
			AccountHolder = accountHolder;
		}
		public long getBalance() {
			return balance;
		}
		public void setBalance(long balance) {
			this.balance = balance;
		}
		public AccountDto() {
			super();
			// TODO Auto-generated constructor stub
		}
		public AccountDto(int id, String accountHolder, long balance) {
			super();
			this.id = id;
			AccountHolder = accountHolder;
			this.balance = balance;
		}
		@Override
		public String toString() {
			return "Account [id=" + id + ", AccountHolder=" + AccountHolder + ", balance=" + balance + "]";
		}

}
