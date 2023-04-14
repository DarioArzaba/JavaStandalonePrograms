package Various;

/**
 Bill and Tip Divider.
 <p>Given a certain bill, number of friends present and tip percent, this program finds what each needs to pay so the bill is split equally.
 
 @author Dario Arzaba
 @version 1.0
 */

public class BillAndTipDivider {
	
	private int friendsNumber;
	private double bill, tipPercent;
	
	/**
	 This constructor creates a Bill divider with default values of 7 friends, 1562.49 of bill and 15 tip percent.
	 */
	public BillAndTipDivider(){
		this.friendsNumber = 7;
		this.bill = 1562.49;
		this.tipPercent = 15;
	}
	
	/**
	 This constructor creates a Bill divider with the given values.
	 @param friends Int number of friends in the restaurant.
	 @param billTotal Double number for the total bill.
	 @param tip The obligatory or agreed tip percent that is going to be applied to the bill.
	 */
	public BillAndTipDivider(int friends, double billTotal, double tip){
		this.friendsNumber = friends;
		this.bill = billTotal;
		this.tipPercent = tip;
	}
	
	
	/**
	 Prints the results from dividing the bill. This includes the initial total bill, the initial tip percent, the final cost, the final pay per friend for the bill, for the tip and for both.
	 */
	public void printBillDivider(){
		
		double tip = (bill*(tipPercent/100));		
		double billPerFriend = (bill/friendsNumber);
		double tipPerFriend = (tip/friendsNumber);
		double totalCost = bill + tip;
		double totalPerFriend = (totalCost/friendsNumber);
		
		System.out.println("\nTotal Bill: " + bill);
		System.out.println("Total Tip: " + tip);
		System.out.println("Total Cost: " + totalCost);
		System.out.println("Total Bill Per Friend: " + billPerFriend);
		System.out.println("Total Tip Per Friend: " + tipPerFriend);
		System.out.println("Total Per Friend: " + totalPerFriend);
		
	}
	
	public int getFriendsNumber() {
		return friendsNumber;
	}
	public void setFriendsNumber(int friendsNumber) {
		this.friendsNumber = friendsNumber;
	}
	public double getBill() {
		return bill;
	}
	public void setBill(double bill) {
		this.bill = bill;
	}
	public double getTipPercent() {
		return tipPercent;
	}
	public void setTipPercent(double tipPercent) {
		this.tipPercent = tipPercent;
	}
	
}

class VariousTesting11 {
	
	public static void main(String[] args) {

		BillAndTipDivider instance = new BillAndTipDivider();
		instance.printBillDivider();
		
		System.exit(0);
	
	}
}
