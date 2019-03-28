import java.util.ArrayList;
import java.util.Scanner;

/*
 * Title: CS151 HW2 AtmSystem
 * By: Tai Dao
 * Date: 09/24/2017
 * 
 * Amor's Cafe Bathroom Pin is 7296
 * 
 */

public class ATMSystem {

	private static Scanner scan;

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		Bank bank1 = new Bank(); // Creating a new Bank
		Bank bank2 = new Bank();
		ArrayList<CashCard> cardsInWallet = new ArrayList<CashCard>();
		
		//Here we are creating BankAccounts and CashCards
		
		//Example of a valid card with bank 1 $10000 preloaded
		bank1.setBankID(8043); // ID of Bank 1
		BankAccount account1 = new BankAccount();
		account1.setBankAccountNum(8708093865858L);
		account1.setPassword("trance4lyfe");
		account1.setMoney(10000L);
		
		CashCard card1 = new CashCard();
		card1.setCardNumber(8043888888881247L);
		card1.setExpirationMonth(10);
		card1.setExpirationYear(2017);
		bank1.setUpNewAccount(account1, card1); //Sets up card and bank account association
		cardsInWallet.add(card1); //Add cards to wallet.
		
		System.out.println("State of account1 which got added to bank1: ");
		account1.printState();
		System.out.println("State of card1 which got assocated with bank1: ");
		card1.printState();
		System.out.println("State of bank1: ");
		bank1.printState();
		System.out.println("State of atm1 from bank1 (atms reference bank for bank_id): ");
		bank1.machine1.printState();
		System.out.println("State of atm2 from bank1 (atms reference bank for bank_id): ");
		bank1.machine2.printState();
		
		//Example of an invalid card with no bank account associations
		CashCard card2 = new CashCard();
		card2.setCardNumber(9999111188881247L);
		card2.setExpirationMonth(10);
		card2.setExpirationYear(2018);
		cardsInWallet.add(card2);
		System.out.println("State of card2 (has no bank associations): ");
		card2.printState();
		
		//Example of an invalid card with bad expiration date and no bank account associations
		CashCard card3 = new CashCard();
		card3.setCardNumber(3333111188881247L);
		card3.setExpirationMonth(5);
		card3.setExpirationYear(2015);
		cardsInWallet.add(card3);
		System.out.println("State of card3: (has no bank associations and is expired)");
		card3.printState();
		
		//Example of a invalid card with bank 1 but card is expired
		BankAccount account4 = new BankAccount();
		account4.setBankAccountNum(8708093865811258L);
		account4.setPassword("PUBGisbae");
		account4.setMoney(10000L);
		
		CashCard card4 = new CashCard();
		card4.setCardNumber(8812886488881247L);
		card4.setExpirationMonth(10);
		card4.setExpirationYear(2017);
		bank1.setUpNewAccount(account4, card4); //Sets up card and bank account association
		cardsInWallet.add(card4);
		
		System.out.println("State of card4 (expired but associated with bank1): ");
		card4.printState();
		System.out.println("State of account4 which got added to bank1: ");
		account4.printState();
		System.out.println("State of bank1 after adding second account: ");
		bank1.printState();
		System.out.println("State of atm1 from bank1 (atms reference bank for bank_id): ");
		bank1.machine1.printState();
		System.out.println("State of atm2 from bank1 (atms reference bank for bank_id): ");
		bank1.machine2.printState();
		
		
		
		//Example of a valid card with bank 2 $10000 preloaded
		BankAccount account5 = new BankAccount();
		account5.setBankAccountNum(1337093865858L);
		bank2.setBankID(9000); // ID of Bank 2
		account5.setPassword("trance4lyfe");
		account5.setMoney(50L);

		CashCard card5 = new CashCard();
		card5.setCardNumber(1337888888881247L);
		card5.setExpirationMonth(10);
		card5.setExpirationYear(2017);
		bank2.setUpNewAccount(account5, card5); //Sets up card and bank account association
		cardsInWallet.add(card5); //Add cards to wallet.
		
		System.out.println("This is the state of card5: ");
		card5.printState();
		System.out.println("State of account5 which got added to bank2: ");
		account5.printState();
		System.out.println("State of bank2: ");
		bank2.printState();
		System.out.println("State of atm1 from bank2 (atms reference bank for bank_id): ");
		bank2.machine1.printState();
		System.out.println("State of atm2 from bank2 (atms reference bank for bank_id): ");
		bank2.machine2.printState();

		Boolean tryAgain = true;
		while (tryAgain){
			System.out.println("1. Bank 1. Machine 1");
			System.out.println("2. Bank 1. Machine 2");
			System.out.println("3. Bank 2. Machine 1");
			System.out.println("4. Bank 2. Machine 2");
			System.out.println("5. Leave.");
			System.out.print("Please choose your atm machine: ");
			
			int intScanned = 0;
			switch (scan.nextInt()) {
		      case 1:
		    	  	System.out.println();
					System.out.println("1. Card 1");
					System.out.println("2. Card 2");
					System.out.println("3. Card 3");
					System.out.println("4. Card 4");
					System.out.println("5. Card 5");
					System.out.print("Select your card: ");
					intScanned = scan.nextInt();
					System.out.println();;
					bank1.machine1.machineMenu(cardsInWallet.get(intScanned -1));
			        break;
		      case 2:
		    	  	System.out.println();
					System.out.println("1. Card 1");
					System.out.println("2. Card 2");
					System.out.println("3. Card 3");
					System.out.println("4. Card 4");
					System.out.println("5. Card 5");
					System.out.print("Select your card: ");
					intScanned = scan.nextInt();
					System.out.println();;
					bank1.machine2.machineMenu(cardsInWallet.get(intScanned -1));
			        break;
		      case 3:
		    	  	System.out.println();
					System.out.println("1. Card 1");
					System.out.println("2. Card 2");
					System.out.println("3. Card 3");
					System.out.println("4. Card 4");
					System.out.println("5. Card 5");
					System.out.print("Select your card: ");
					intScanned = scan.nextInt();
					System.out.println();;
					bank2.machine1.machineMenu(cardsInWallet.get(intScanned -1));
			        break;
		      case 4: 
		    	  	System.out.println();
					System.out.println("1. Card 1");
					System.out.println("2. Card 2");
					System.out.println("3. Card 3");
					System.out.println("4. Card 4");
					System.out.println("5. Card 5");
					System.out.print("Select your card: ");
					intScanned = scan.nextInt();
					System.out.println();;
					bank2.machine2.machineMenu(cardsInWallet.get(intScanned -1));
			        break;
		      case 5:
		    	tryAgain = false;
		        System.out.println ( "Goodbye and have a nice day! :]" );
		        System.exit(0);
		        break;
		      default:
		        System.out.println ( "Unrecognized option. Please Try again.\n" );
		        break;
		    } // end of Switch
		} // end of while
	} // end of main
}
