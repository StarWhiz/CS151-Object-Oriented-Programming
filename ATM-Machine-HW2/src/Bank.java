import java.util.HashMap;
import java.util.TreeMap;

public class Bank {
	AtmMachine machine1;
	AtmMachine machine2;
	int bank_id;
	TreeMap<Long, BankAccount> bankAccountDir;
	HashMap<Long, Long> hashBankAccNo;
	HashMap<Long, Integer> hashBankID;
	
	/**
	 * A new bank always has two ATM machines. And a directory of bank accounts.
	 */
	Bank(){
		machine1 = new AtmMachine(this);
		machine2 = new AtmMachine(this);
		bankAccountDir = new TreeMap<Long, BankAccount>();
		hashBankAccNo = new HashMap<Long, Long>();
		hashBankID = new HashMap<Long, Integer>();
	}
	
	/**
	 * Adds brand new bank account to the bankAccountDir TreeMap and loads HashMaps for
	 * card to bank associations in ATM machine1 and ATM machine2
	 * 
	 * @param account
	 * @param card
	 */
	public void setUpNewAccount(BankAccount account, CashCard card) {
		long accountNum = account.getBankAccountNum();
		bankAccountDir.put(accountNum, account);
		hashBankAccNo.put(card.getCardNumber(), account.getBankAccountNum());
		hashBankID.put(card.getCardNumber(), bank_id);
	}
	
	/**
	 * Sets the Bank ID associated with the bank account
	 * @param bankID
	 */
	public void setBankID(int bankID){
		bank_id = bankID;
	}
	/**
	 * Returns Bank ID associated with the bank account
	 * @return int bank_id
	 */
	public int getBankID(){
		return bank_id;
	}
	
	public void printState() {
		System.out.println("Bank ID: " + bank_id);
		System.out.println("card2bankAccNoHash: " + hashBankAccNo);
		System.out.println("card2bankIDHash:" + hashBankID);
		System.out.println("TreemapOfBankAccounts: " + bankAccountDir);
		System.out.println();
	}// end of printState
}
