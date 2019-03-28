import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class AtmMachine {
	Bank associatedBank; 
	static Scanner scan = new Scanner(System.in);

	/**
	 *  ATM machines are associated with their Banks and have access to the following states
	 * 	TreeMap<Long, BankAccount> bankAccountDir;
	 *	HashMap<Long, Long> hashBankAccNo;
	 *  HashMap<Long, Integer> hashBankID;
	 */
	AtmMachine(Bank b) {
		associatedBank = b;
	}
	/**
	 * Prints the main menu of the ATM Machine. Machine will accept CashCards.
	 * @param card
	 */
	public void machineMenu(CashCard card){
		boolean stillUsingATM = true; //condition for keep using ATM machine if user enters wrong number
		while (stillUsingATM){
			System.out.println("Here are the actions you can do\n");
			System.out.print("1. Insert Card #");
			System.out.print(card.getCardNumber());
			System.out.println();
			System.out.println("2. Leave the ATM Machine\n");
			System.out.print("Please insert your card to begin (Press 1 and enter to insert card): ");
			boolean validScan = scan.hasNextInt(); //condition to check for valid input
			if (validScan) {
				switch (scan.nextInt()) {
			      case 1:
			    	stillUsingATM = false;
			        System.out.println ( "Card Inserted. Reading card number...\n" );
			        checkExpiredCard(card); //checks if the card is expired
			        checkCardNumber(card, associatedBank.hashBankAccNo, associatedBank.hashBankID);
			        long bankAccountNoRetrieved = convertCardNo2BankAccNo(card, associatedBank.hashBankAccNo);
			        authorization(bankAccountNoRetrieved, associatedBank.bankAccountDir);
			        transactionDialog(bankAccountNoRetrieved, associatedBank.bankAccountDir);
			        break;
			      case 2:
			    	stillUsingATM = false;
			        System.out.println ( "Goodbye and have a nice day! :]" );
			        System.exit(0);
			        break;
			      default:
			        System.out.println ( "Unrecognized option. Please Try again.\n" );
			        break;
			    } // end of Switch
			}
			else {
				System.out.println ( "Unrecognized Option. System assumes you left the ATM.\n" );
				System.exit(0);
			}		
		}// end of while
	}// end of machine menu method
	
	/**
	 * Checks if the CashCard inserted was expired or not. If the card is expired the ATM will exit.
	 * @param card
	 */
	public void checkExpiredCard (CashCard card){
		Calendar c = Calendar.getInstance();
		int currentYear = c.get(Calendar.YEAR);
		int currentMonth = c.get(Calendar.MONTH) + 1;
		int cardMonth = card.getExpirationMonth();
		int cardYear = card.getExpirationYear();
		
		if ((currentYear > cardYear) || (currentYear >= cardYear && currentMonth > cardMonth)){
			System.out.println("This card is expired. Please take your card.");
			System.exit(0);
		}
	}
	/**
	 * Checks if the card number on the CashCard is valid or not. A valid card matches the bank ID and account
	 * number associated with it.
	 * 
	 * If it is valid the program continues.
	 * If it is not valid the program exits.
	 * 
	 * @param card
	 * @param hashBankAcc
	 * @param hashBankID
	 */
	public void checkCardNumber (CashCard card, HashMap<Long, Long> hashBankAcc, HashMap<Long, Integer> hashBankID){
		long atmCardNum = card.getCardNumber();
		
		//checking to see if associated Bank ID and Bank Account # can be found with card number
		boolean cardValidBankID = associatedBank.hashBankID.containsKey(atmCardNum);
		boolean cardValidBankAcc = hashBankAcc.containsKey(atmCardNum);
		
		if (cardValidBankID && cardValidBankAcc) {
			System.out.println("This is a valid card.");
		}
		else {
			System.out.println("This is an invalid card. Card number does not match bank ID. Please take your card.");
			System.exit(0);
		}
	}
	/**
	 * Returns the bank account number associated with the card number on the CashCard.
	 * @param card
	 * @param hashBankAcc
	 * @return long bankAccountNum
	 */
	public long convertCardNo2BankAccNo(CashCard card, HashMap<Long, Long> hashBankAcc) {
		long atmCardNum = card.getCardNumber();
		long bankAccountNum = hashBankAcc.get(atmCardNum);
		return bankAccountNum;
	}
	/**
	 * Prompts user to enter their password. If it's wrong they are given one more chance to enter in
	 * the correct password. If they get it wrong again the ATM denies access and returns the card.
	 * 
	 * If the password was correct the program continues on.
	 * 
	 * @param bankAccNo
	 * @param bankDirectory
	 */
	public void authorization(long bankAccNo, TreeMap<Long, BankAccount> bankDirectory){
		BankAccount retrievedAccount = associatedBank.bankAccountDir.get(bankAccNo); //get bankAccount object from the key bankAccNo#
		String pwOfRetrievedAccount = retrievedAccount.getPassword(); //get password for that bank account
		
		int tries = 0;
		while (tries < 2) {
			System.out.print("Please enter in your password: ");
			String passwordEntered = scan.next();
			if (passwordEntered.equals(pwOfRetrievedAccount)) {
				System.out.println("\nCard is authorized.");
				break;
			}
			else {
				tries++;
				System.out.println("Invalid password. Try Again.\n");
				if (tries == 2) {
					System.out.println("Authorization Denied. Please take your card.");
					System.exit(0);
				} // Deny Authorization after second try
			}// end if else
		}// end of while loop
	}// end of authorization method
	
	/**
	 * Prompts the transaction dialog for the user. Here they can withdraw money from their bank account.
	 * 
	 * If the number to be withdrawn exceeds the amount available in the user's bank account. The
	 * ATM will say it's invalid and allows the user to try one more time. If they fail to enter in
	 * a valid amount the second time the program exits and the ATM returns the card to the user.
	 * 
	 * If they succeed in entering a valid amount. Cash will be given to the user and the bank account
	 * will be balanced out.
	 * 
	 * @param bankAccNo
	 * @param bankDirectory
	 */
	public void transactionDialog(long bankAccNo, TreeMap<Long, BankAccount> bankDirectory) {
		BankAccount retrievedAccount = associatedBank.bankAccountDir.get(bankAccNo);
		long money = retrievedAccount.getMoney();
		long moneyLeft;
		int tries = 0;
		System.out.print("You have $");
		System.out.print(money);
		System.out.println(" USD.");
		System.out.println("\nWould you like to withdraw cash today?");
		System.out.println("1. Yes");
		System.out.println("2. No");
		System.out.println("\nEnter your choice and press enter: ");
	
		switch (scan.nextInt()) {
	      case 1:
	    	  while(tries < 2) {
		    	  System.out.println("\nPlease enter the amount of dollars you would like to withdraw: ");
		    	  String moneyRequestedStr = scan.next();
		    	  long moneyReqL = Long.parseLong(moneyRequestedStr, 10); 
		    	  
		    	  if (moneyReqL <= money){ // Cannot withdraw more than what's in balance
		    		  
		    		  if (moneyReqL <= 100){ // ATM Machine limited to $100 withdrawals per transaction
			    		  moneyLeft = money - moneyReqL;
			    		  retrievedAccount.setMoney(moneyLeft);
			    		  System.out.print("$");
			    		  System.out.print(moneyReqL);
			    		  System.out.println(" USD has been withdrawn.");  
			    		  System.out.print("$");
			    		  System.out.print(moneyLeft);
			    		  System.out.println(" USD remaining in bank account.\n");
			    		  System.out.println("Please take your money and card. Have a good day!");
			    		  System.exit(0);
		    		  }
		    		  else{
		    			  System.out.print("Amount requested exceeds transaction limit of $100.");
		    		  }
		    	  }
		    	  else {
		    		  tries++;
		    		  System.out.println("Error. Amount requested is over current balance. Try Again");
		    	  }
	    	  }// end of 2 tries while loop
    		  System.out.println("Error. Invalid amount to withdraw. Please take your card.");
    		  System.exit(0);
	      case 2:
	        System.out.println ( "Goodbye and have a nice day! :]" );
	        System.exit(0);
	        break;
	      default:
	        System.err.println ( "Unrecognized option" );
	        break;
		}//end of switch
	}// end of transactionDialog
	public void printState(){
		System.out.println(associatedBank);
		System.out.println();
	}
}// end of AtmMachine
