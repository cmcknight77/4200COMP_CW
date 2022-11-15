import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;


public class MainClass {
	Scanner write = new Scanner(System.in);	
	
	
	//Creating main array
	private static final Seats[] seats = new Seats[18];
	

	public static void main(String[] args) throws FileNotFoundException
	{
		loadSeats();
	
		do 
		{
		String selection = "";
		Scanner read = new Scanner(System.in);
		
		//Main menu page for user to view their options
		
		System.out.println("\n--Seat Booking System--");
		System.out.println("\n--MAIN MENU--");
		System.out.println("1- Reserve Seat\n"
				+ "2- Cancel Seat\n"
				+ "3- View Seat Reservations\n"
				+ "q- Quit\n"
				+ "Pick :");
		
		selection = read.next();
		
		if (selection.equals("1")) 
		{
			loadSeats();
			//displaySeats();
			reserveSeats();
			
		}
		else if (selection.equals("2")) 
		{
			System.out.println("\n--Current availability--\n");
			
		}
		else if (selection.equals("3")) 
		{
			System.out.println("\n--Current availability--\n");
			displaySeats();			
		}
		else if (selection.equals("q")) 
		{
			System.out.println("Thank you, goodbye");
			System.exit(0);
		}
		else
		{
			System.out.println("Input invalid, please restart");
					
		}
		}while(true);
				
	}
	//Extracting seat information from text file
		private static void loadSeats() throws FileNotFoundException
		{
			Scanner file = new Scanner(new FileReader("C:\\Users\\charl\\Downloads\\seats2.txt"));
			
			int index = 0;
			
			while (file.hasNext()) 
			{
			String seatNum = file.next();
			String seatClass = file.next();
			boolean aisleSeat = Boolean.parseBoolean(file.next());
			boolean midSeat = Boolean.parseBoolean(file.next());
			boolean windowSeat = Boolean.parseBoolean(file.next());
			double price = Double.parseDouble(file.next());
			String avail = file.next();			
			
			seats[index] = new Seats(seatNum, seatClass, aisleSeat, midSeat, windowSeat, price, avail);	
			index++;
			}
			file.close();		
	    }

		//Displaying seat information from text file
		private static void displaySeats () throws FileNotFoundException 
		{
			loadSeats();
			for (int i=0; i<seats.length;i++)
			{			
				System.out.printf("Option%s Seat Number:%s  Seat Type:%s  Aisle:%s  Mid:%s  Window:%s  Price:%s  Avail:%s \n",
						 i,seats[i].seatNum, seats[i].seatClass, seats[i].aisleSeat, seats[i].midSeat, seats[i].windowSeat, seats[i].price, seats[i].avail);		
			}
			while(seats.length < 18);
			//System.out.printf("Test %s", seats[3].seatNum);
		}
		
		//Altering data from text file
		private static void reserveSeats () throws FileNotFoundException 
		{
			displaySeats();
			
			Scanner write = new Scanner(System.in);
			
			System.out.print("\nEnter Option Number\n");
			int choice = write.nextInt();
			System.out.print("\nEnter email adress\n");
			String email = write.next();
			
			if (seats[choice].avail == "free") 
			{
				seats[choice].avail.replace("free", email);
				System.out.print("\nReservation saved\n");
			}
			else 
			{
				System.out.print("\nSeat is already reserved\n");
			}
			
			write.close();
		}
		
		private static void cancelSeats() throws FileNotFoundException 
		{
			Scanner write = new Scanner(System.in);
			
			System.out.print("Enter email associated with booking");
			String email = write.next();
			boolean seatFound = false;
			
			for (int i = 0; i < seats.length; i++) 
			{
				if (seats[i].getEmail() == email) 
				{
					seatFound = true;
				}
				if (!seatFound) 
				{
					System.out.print("No email is associated with a booking");			
				}
				else 
				{
					
				}
				
			}
		 }
		
		
		
		
		
		
}
