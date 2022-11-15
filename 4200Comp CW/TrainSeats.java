import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class TrainSeats {

	public static void main(String[] args) throws FileNotFoundException
	{
	Scanner read = new Scanner(System.in);

    double discountRate = 20.0; 	
   
		System.out.println("Welcome, would you like to change original discount rate");
	
	do {
		System.out.println("Enter answer in Y/N format");
		String selection = read.next();
		
		if (selection.equalsIgnoreCase("Y"))
		{
			System.out.println("What would you like to change discount rate to?");
			System.out.println("Please enter value in double format");
			
			while (!read.hasNextDouble()) {
				System.out.println("Invalid input \nPlease re-enter value");
			    read.next();		//Reading user input
			}
			
			discountRate = read.nextDouble();
			
			if (discountRate < 100) 
			{
			System.out.println("The specified discount rate is now  " + String.format("%.1f",discountRate) + "%\n");
			break;			
			}
			else if (discountRate >=100) 
			{
				System.out.println("Discount Rate is invalid, please start again\n");
			}// validating discount value
		}
		else if (selection.equalsIgnoreCase("N")) 
		{		
			System.out.println("The new discount rate is " + String.format("%.1f",discountRate) + "%\n");
			break;
		}
		else 
		{
			System.out.println("The input was in an incorrect format");		
		}		
	}while(true); //validating user input
	
	FileReader input = new FileReader("C:\\Users\\charl\\OneDrive\\Documents\\New folder\\seats.txt");
	Scanner scan = new Scanner(input);	//scanning "seats" text file
	double totalIncome = 0;
	double totalDiscount = 0;
	
    System.out.println("Seat discount system");
    System.out.println("-----------------------");
		
	while(scan.hasNextLine()) 
	{	
	
	String seatType = scan.next();
	Double price = scan.nextDouble();
	int tickets = scan.nextInt();
	
	double total = tickets * price;
	double discount = total * (discountRate / 100);
	double finalPrice = total - discount; //calculating final totals
		
	System.out.println( "Seat type:" + seatType
			+ ", Seat Price:" + String.format("%.2f",price)
			+ ", Bookings:" + tickets
			+ ", Discount:" + String.format("%.2f",discount)
			+ ", Income:" + String.format("%.2f",finalPrice));
	
	totalIncome = totalIncome + finalPrice;
	totalDiscount = totalDiscount + discount;	
	}
	
	System.out.printf("\r" + "Total Income: £%.2f %n", totalIncome);
	System.out.printf("Total Discount: £%.2f %n", totalDiscount);
		
	scan.close();
	read.close();
	System.exit(0);
	//Program closed
	}
}
