package Aplicattion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args)  {
			Scanner sc = new Scanner(System.in);
		try {
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			System.out.print("Room Number:");
			int number = sc.nextInt();
			sc.nextLine();

			System.out.print("Check-in date (dd/MM/yyyy):");
			Date checkIn = sdf.parse(sc.next());

			System.out.print("Check-out date (dd/MM/yyyy):");
			Date checkOut = sdf.parse(sc.next());

			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation:" + reservation);
	//-----------------------------------------------------------------------------------------
			System.out.println();
			sc.nextLine();
			System.out.println("Enter date to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy):");
			checkIn = sdf.parse(sc.next());

			System.out.print("Check-out date (dd/MM/yyyy):");
			checkOut = sdf.parse(sc.next());

			reservation.updateDates(checkIn, checkOut);

			System.out.println("Reservation:" + reservation);

		}catch(ParseException e)
		{
			System.out.println("Invalid date format");
			
		}
		catch(DomainException e)
		{
			System.out.println(e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println("Unexpeted error");
		}
		sc.close();

	}

}
