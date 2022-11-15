import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;


public class Seats 
{

int Option;
String seatNum;
String seatClass;
boolean aisleSeat;
boolean midSeat;
boolean windowSeat;
double price;
String avail;
int [] seatNo;

     public Seats(String seatNum, String seatClass, boolean aisleSeat, boolean midSeat,
    		 boolean windowSeat, double price, String avail) 
     {
    	 this.seatNum = seatNum;
    	 this.seatClass = seatClass;
    	 this.aisleSeat = aisleSeat;
    	 this.midSeat = midSeat;
    	 this.windowSeat = windowSeat;
    	 this.price = price;
    	 this.avail = avail;  	
     }
     
     public String ToString()
     {
    	 String result = seatNum + " " + seatClass + " " + aisleSeat + " "+ midSeat + " "
    			 + windowSeat + " " + price + " " + avail;
    	 for (int i = 0; i<seatNo.length; i++)
    	 {
    		 result += " " + seatNo[i];
    	 }
    	 return result;
     }
     
     //Creating a reserve method
     public void reserve(int reserve) 
     {
    	for (int i=0; i<seatNo.length; i++) 
    	{ 
    		if (seatNo[i] == 0)
    		{
    			seatNo[i] = reserve;
    			return;
    		}
    	}
     }
     
     //Creating a cancel method
     public boolean cancel(int avail) 
     {
    	 for (int i= 0; i<seatNo.length; i++)
    	 {
    	 if (seatNo[i] == avail)
    	    {
    		 seatNo[i] = 0;
    	     return true;
    	    }
    	 }
    	 return false;
     }
     
     public String getEmail()   
     {
    	 return this.getEmail();
     }

}
