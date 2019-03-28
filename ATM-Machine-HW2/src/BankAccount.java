public class BankAccount {
	private Long bank_accountNum;
	private long money;
	private String accountPassword;
	
	/**
	 * Sets the bank account number
	 * @param bankAccountNumber
	 */
	public void setBankAccountNum(long bankAccountNumber){
		bank_accountNum = bankAccountNumber;
	}
	
	/**
	 * Returns the bank account number
	 * @return long bank_accountNum
	 */
	public long getBankAccountNum(){
		return bank_accountNum;
	}
	
	/**
	 * Sets the bank account password
	 * @param bankPW
	 */
	public void setPassword(String bankPW){
		accountPassword = bankPW;
	}
	
	/**
	 * Returns the bank account password
	 * @return String accountPassword
	 */
	public String getPassword(){
		return accountPassword;
	}
	
	/**
	 * Sets the amount of money inside the bank account.
	 * @param moola
	 */
	public void setMoney(long moola){
		money = moola;
	}
	
	/**
	 * Returns the amount of money inside the bank account.
	 * @return long money
	 */
	public long getMoney(){
		return money;
	}
	public void printState(){
		System.out.println("bank_accountNum: " + bank_accountNum);
		System.out.println("Balance: $" + money);
		System.out.println("Password: " + accountPassword);
		System.out.println();
	}
}
