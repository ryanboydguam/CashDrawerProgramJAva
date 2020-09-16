package cs_315_project1;

import java.math.BigDecimal;
import java.util.Scanner;

public class CashDrawerWithGUI {
	//currency values in an array so you can pull each one one at a time
	int[] currency = {1, 5, 10, 25, 100, 500, 1000, 2000, 5000, 10000};
	//currency names in an array saves space on println
	String[] currencyNames = {"100 Dollars", "50 Dollars", "20 Dollars", "10 Dollars", "5 Dollars", "1 Dollar", "Quarter", "Dime", "Nickel", "penny"};
	//scanner to get the input values from the user
	Scanner scanner = new Scanner(System.in);
	//holds the amount, payment, and cashback values in the array
	int[] exchange = {0, 0, 0};
	//holds the array for the amount of each currency to give back
	int[] currencyBack = new int[10];
	
int changeBackForGUI = 0;
//sets the cost amount variable
public void costAmount(int itemCost) {
	this.exchange[0]=itemCost;
}
//sets the payment from the customer
public void paymentAmount(int itemCost) {
	this.exchange[1]=itemCost;
}
//gets the currency amount
public String getCurrencyAmount(int select) {
	return String.valueOf(currencyBack[select]);
}
//returns the change back in a string
//this will convert the int value to a string and will add the . before the last two values
public String getChangeBAck() {
	//saves the int value of input into a string
	String temp = String.valueOf(changeBackForGUI);
	//the return value
	String returnValue = "";
	//for the length of the string do this
	for(int a =0;a<temp.length();a++) {
		//add each character to the return value
		returnValue += temp.charAt(a);
		//when its 3 places before the return value add the . to the value
		if(3==(temp.length()-a)) {
			returnValue +=".";
		}
	}
	return returnValue;
}
//gets the costAmount from the user
public void getItemCost(String input) {
	//converts the scanner to a double then times it by 100 then math rounds it then converts it into an int
	costAmount((int)Math.round(Double.parseDouble(input)*100));
}
//gets the payment from the user
public void getCustomerPayment(String input) {
	//converts the scanner to a double then times it by 100 then math rounds it then converts it into an int
	paymentAmount((int)Math.round(Double.parseDouble(input)*100));
}
//prints out the change back
public void getChangeBack() {
	//the money given by the customer subtracted by the cost saved into the changeback value
	exchange[2]=(exchange[1]-exchange[0]);
	//prints out the change back
	System.out.println("Change Back"+exchange[2]);
	//sets the change back for the GUI
	changeBackForGUI = exchange[2];
}
//Calculates the change back
public void getChangeBackInCurrency() {
	//while changeback is not 0
	while(exchange[2]!=0) {
		//while change back is grater than or equal to 100
		while(exchange[2]>=currency[9]) {
			//add 1 to the 100 bills that you need to give back
			currencyBack[0]++;
			//subtract 100 dollars from the change back
			exchange[2]-=currency[9];
		}//while change back is grater than or equal to 50
		while(exchange[2]>=currency[8]) {
			//add 1 to the 50 bills that you need to give back
			currencyBack[1]++;
			//subtract 50 dollars from the change back
			exchange[2]-=currency[8];
		}//while change back is grater than or equal to 20
		while(exchange[2]>=currency[7]) {
			//add 1 to the 20 bills that you need to give back
			currencyBack[2]++;
			//subtract 20 dollars from the change back
			exchange[2]-=currency[7];
		}//while change back is grater than or equal to 10
		while(exchange[2]>=currency[6]) {
			//add 1 to the 10 bills that you need to give back
			currencyBack[3]++;
			//subtract 10 dollars from the change back
			exchange[2]-=currency[6];
		}//while change back is grater than or equal to 5
		while(exchange[2]>=currency[5]) {
			//add 1 to the 5 bills that you need to give back
			currencyBack[4]++;
			//subtract 5 dollars from the change back
			exchange[2]-=currency[5];
		}//while change back is grater than or equal to 1
		while(exchange[2]>=currency[4]) {
			//add 1 to the 1 bills that you need to give back
			currencyBack[5]++;
			//subtract 1 dollars from the change back
			exchange[2]-=currency[4];
		}//while change back is grater than or equal to 0.25
		while(exchange[2]>=currency[3]) {
			//add 1 to the 0.25 coins that you need to give back
			currencyBack[6]++;
			//subtract 0.25 coins from the change back
			exchange[2]-=currency[3];
		}//while change back is grater than or equal to 0.10
		while(exchange[2]>=currency[2]) {
			//add 1 to the 0.10 coins that you need to give back
			currencyBack[7]++;
			//subtract 0.10 coins from the change back
			exchange[2]-=currency[2];
		}//while change back is grater than or equal to 0.05
		while(exchange[2]>=currency[1]) {
			//add 1 to the 0.05 coins that you need to give back
			currencyBack[8]++;
			//subtract 0.0.05 coins from the change back
			exchange[2]-=currency[1];
		}//while change back is grater than or equal to 0.01
		while(exchange[2]>=currency[0]) {
			//add 1 to the 0.01 coins that you need to give back
			currencyBack[9]++;
			//subtract 0.01 coins from the change back
			exchange[2]-=currency[0];
		}
	}
}
//println the bills and the number of them
public void billPrinter() {
	//for each bill print out the amount to give back
	for(int a = 0; a<currency.length;a++) {
		System.out.println(currencyNames[a]+":"+currencyBack[a]);
	}
}
//runs all the methods of the program
public void program() {
	getChangeBack();
	getChangeBackInCurrency();
	billPrinter();
}
//the main class of the file to make it runnable
public static void main(String[] args) {
	CashDrawerWithGUI object = new CashDrawerWithGUI();
	object.program();
}
}
