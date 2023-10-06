package Application_Main;

import java.util.Scanner;
import java.io.IOException;
import UserManagement.user_management;
import FlightBooking.flight_booking;

public class ApplicationMain {
	public static void main(String args[]) throws IOException{
		Scanner scanner = new Scanner(System.in);
		boolean canikeeprunningprogram = true;
		System.out.println("##WELLCOME TO AIRLINE SYSTEM MANAGEMENT##");
		System.out.println("\n");
		System.out.println("Login name:");
		String loginname = scanner.nextLine();
		System.out.println("Password:");
		String password = scanner.nextLine();
		System.out.println("MOST HEARLTLY WELLCOME AS YOUE LOGINNAME AND PASSWORD ARE CONFIRMED...");
		
		if(!user_management.validateUserandPassword(loginname,password)) {
			System.out.println("Login failed..Closing the application..");
			return;
		}
			while(canikeeprunningprogram == true) {
				System.out.println("\n");
				System.out.println("###WELLCOME TO FLIGHT AND USER MANAGEMENT SYSTEM##");
				System.out.println("\n");
				System.out.println("What would you like to do?:");
				System.out.println("1. User Management (Information about User)");
				System.out.println("2 Flight Management (Information about Flight)");
				System.out.println("5. Quit");
				
				int optionselectedbyuser = scanner.nextInt();
				if(optionselectedbyuser == 1) {
					user_management.userManagement();
				}
				else if(optionselectedbyuser == 2) {
					flight_booking.flightBooking();
				}
				else if(optionselectedbyuser ==5) {
					break;
	}
			}
	}
			
	
}
