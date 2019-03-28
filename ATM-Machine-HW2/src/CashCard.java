
public class CashCard {
	private long cardNumber;
	private int cardExpMonth;
	private int cardExpYear;
	
	/**
	 * Sets CashCard number.
	 * @param cardNum
	 */
	public void setCardNumber(long cardNum){
		cardNumber = cardNum;
	}
	/**
	 * Returns CashCard number.
	 * @return long cardNumber
	 */
	public long getCardNumber(){
		return cardNumber;
	}
	/**
	 * Sets expiration month on CashCard.
	 * @param expMonth
	 */
	public void setExpirationMonth(int expMonth){
		cardExpMonth = expMonth;
	}
	/**
	 * Returns expiration month on CashCard
	 * @return int cardExpMonth
	 */
	public int getExpirationMonth(){
		return cardExpMonth;
	}
	/**
	 * Sets expiration year on CashCard
	 * @param expYear
	 */
	public void setExpirationYear(int expYear){
		cardExpYear = expYear;
	}
	/**
	 * Returns expiration year on CashCard
	 * @return int cardExpYear
	 */
	public int getExpirationYear(){
		return cardExpYear;
	}
	public void printState() {
		System.out.println("Card Number:" + cardNumber);
		System.out.println("Card Month Expiration:" + cardExpMonth);
		System.out.println("Card Year Expiration:" + cardExpYear);
		System.out.println();
	}
}
