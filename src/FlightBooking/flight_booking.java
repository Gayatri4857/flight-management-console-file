package FlightBooking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.ArrayList;

public class flight_booking {
	static ArrayList<Flight> al = new ArrayList<> ();
	public static void flightBooking() throws IOException {
		Scanner scanner = new Scanner(System.in);
		boolean canikeeprunningprogram = true;
		while(canikeeprunningprogram == true) {
			System.out.println("### WELL-COME TO FLIGHT MANAGEMENT SYSTEM##");
			System.out.println("1. Add Flight:");
			System.out.println("2. Edit Flight:");
			System.out.println("3. Search Flight:");
			System.out.println("4. Delete Flight:");
			System.out.println("5. Quit Flight:");
			System.out.println("\n");
			
			int optionselectedbyflight = scanner.nextInt();
			if(optionselectedbyflight == flightOptions.Quit_Flight) {
				File file = new File("\\Users\\hemag\\eclipse-workspace\\FlightBookingSystem\\src\\FlightBooking\\Flight.csv");
				FileWriter fileWriter = new FileWriter(file,false);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
				for(Flight flightbooking:al) {
					bufferedWriter.write(flightbooking.flightname+","+flightbooking.payment+","+flightbooking.departurecity+","+flightbooking.arrivalcity+","+flightbooking.bookingdate+","+flightbooking.arrivaldate+","+flightbooking.timeofflight+"\n");
				}
				bufferedWriter.close();
				fileWriter.close();
				file = null;
				System.out.println("!!Program closed..");
				System.out.println("\n");
				canikeeprunningprogram = false;

			}
			if(optionselectedbyflight == flightOptions.Add_Flight) {
				addFlight();
				System.out.println("\n");
			}
			if(optionselectedbyflight == flightOptions.Search_Flight) {
				System.out.println("Enter the Flight name to Search:");
				scanner.nextLine();
				String searchflightname = scanner.nextLine();
				SearchFlight(searchflightname);
				System.out.println("\n");
			}
			if(optionselectedbyflight == flightOptions.Delete_Flight) {
				System.out.println("Enter the Flight name to Delete:");
				scanner.nextLine();
				String deleteflightname = scanner.nextLine();
				DeleteFlight(deleteflightname);
				System.out.println("\n");
		}
			if(optionselectedbyflight == flightOptions.Edit_Flight) {
				System.out.println("Enter the Flight name to Edit:");
				scanner.nextLine();
				String editflightname = scanner.nextLine();
				EditFlight(editflightname);
				System.out.println("\n");		
	}
		}
		System.out.println("After while loop....");
		for(Flight flightbooking:al) {
			System.out.println(flightbooking.flightname);
			System.out.println(flightbooking.payment);
			System.out.println(flightbooking.departurecity);
			System.out.println(flightbooking.arrivalcity);
			System.out.println(flightbooking.bookingdate);
			System.out.println(flightbooking.arrivaldate);
			System.out.println(flightbooking.timeofflight);
		}
	}
	public static void addFlight() {
		Scanner scanner = new Scanner(System.in);
		Flight flightObject = new Flight();
		System.out.println("** FLIGHT MANAGEMENT INFORMATION AS FOLLOWS**");
		
		System.out.println("Flight name is :");
		flightObject.flightname = scanner.nextLine();
		System.out.println("Payment cost is:");
		flightObject.payment = scanner.nextLine();
		System.out.println("Departure City is:");
		flightObject.departurecity = scanner.nextLine();
		System.out.println("Arrival City is:");
		flightObject.arrivalcity = scanner.nextLine();
		System.out.println("Booking Date is:");
		flightObject.bookingdate = scanner.nextLine();
		System.out.println("Arrival Date is:");
		flightObject.arrivaldate = scanner.nextLine();
		System.out.println("Time of Flight is:");
		flightObject.timeofflight = scanner.nextLine();
		
		
		System.out.println("Flight name:"+flightObject.flightname);
		System.out.println("Payment cost:"+flightObject.payment);
		System.out.println("Departue City:"+flightObject.departurecity);
		System.out.println("Arrival City:"+flightObject.arrivalcity);
		System.out.println("Booking Date:"+flightObject.bookingdate);
		System.out.println("Arrival Date:"+flightObject.arrivaldate);
		System.out.println("Time of Flight:"+flightObject.timeofflight);
		System.out.println("\n");
		System.out.println("RESERVATION FOR FLIGHT HAS BEEN DONE .....");
		al.add(flightObject);
	}
	public static void SearchFlight(String flightname) {
		for(Flight flightbooking:al) {
			if(flightbooking.flightname.equalsIgnoreCase(flightname)) {
				System.out.println("Flight name:"+flightbooking.flightname);
				System.out.println("Payment cost:"+flightbooking.payment);
				System.out.println("Departue City:"+flightbooking.departurecity);
				System.out.println("Arrival City:"+flightbooking.arrivalcity);
				System.out.println("Booking Date:"+flightbooking.bookingdate);
				System.out.println("Arrival Date:"+flightbooking.arrivaldate);
				System.out.println("Time of Flight:"+flightbooking.timeofflight);
				return;
			}
		}
		System.out.println("Flight not found..");			
}
	public static void EditFlight(String flightname) {
		for(Flight flightbooking:al) {
			if(flightbooking.flightname.equalsIgnoreCase(flightname)) {
				Scanner scanner = new Scanner(System.in);
				System.out.println("FINAL INFORMATION HAS BEEN UPDATED...");
				System.out.println("Editing username:"+flightbooking.flightname);
				System.out.println("New Flight name:");
				flightbooking.flightname = scanner.nextLine();
				System.out.println("Payment cost:");
				flightbooking.payment = scanner.nextLine();
				System.out.println("Departue City:");
				flightbooking.departurecity = scanner.nextLine();
				System.out.println("Arrival City:");
				flightbooking.arrivalcity = scanner.nextLine();
				System.out.println("Booking Date:");
				flightbooking.bookingdate = scanner.nextLine();
				System.out.println("Arrival Date:");
				flightbooking.arrivaldate = scanner.nextLine();
				System.out.println("Time of Flight:");
				flightbooking.timeofflight = scanner.nextLine();
				return;
}
		}
		System.out.println("Flight not found...");
	}
	public static void DeleteFlight(String flightname) {
		Iterator<Flight> flightIterator = al.iterator();
		while(flightIterator.hasNext()) {
			Flight flight = flightIterator.next();
			if(flight.flightname.equalsIgnoreCase(flightname)) {
				flightIterator.remove();
	    		System.out.println("Flight "+flight.flightname+" has been deleted...");
				break;
			}
		}
	}
	public static void loaddatafromfiletoArrayList() throws IOException{
		File file = new File("\\Users\\hemag\\eclipse-workspace\\FlightBookingSystem\\src\\FlightBooking\\Flight.csv");
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line = " ";
		while((line= bufferedReader.readLine())!= null) {
			Flight flight = new Flight();
			String[] flightDataArray = line.split(",");
			if(flightDataArray.length>4) {
				flight.flightname =flightDataArray[0];
				flight.payment = flightDataArray[1];
				flight.departurecity = flightDataArray[2];
				flight.arrivalcity = flightDataArray[3];
				flight.bookingdate = flightDataArray[4];
				flight.arrivaldate = flightDataArray[5];
				flight.timeofflight = flightDataArray[6];
				al.add(flight);
			}
		}
		fileReader.close();
		bufferedReader.close();
		file =null;
}
}
