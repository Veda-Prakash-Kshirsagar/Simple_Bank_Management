package com.Bank.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="accounts")
public class Accounts {
		
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		@Column
		//Even if assign here in first letter in upper case in database it will convert first letter in lower case
		private String AccountHolder;  
		@Column
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
		public Accounts() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Accounts(int id, String accountHolder, long balance) {
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
