package org.example;

import model.entities.ReservationEntity;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Room number: ");
            var number = sc.nextInt();
            System.out.print("Check-in date (dd/MM/yyyy): ");
            var checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            var checkOut = sdf.parse(sc.next());

            ReservationEntity reservation = new ReservationEntity(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.print("Do you want to update the reservation? (y/n) ");
            var ch = sc.next().charAt(0);

            if (ch == 'n'){
                System.out.println("Reservation successful: " + reservation);
            } else if (ch == 'y') {
                System.out.println("Enter data to update the reservartion: \nObs: All dates must be in future dates " +
                        "starting from today.");
                System.out.print("Check-in date (dd/MM/yyyy): ");
                checkIn = sdf.parse(sc.next());
                System.out.print("Check-out date (dd/MM/yyyy): ");
                checkOut = sdf.parse(sc.next());

                reservation.updateDates(checkIn, checkOut);
                System.out.println("Reservation updated successful: " + reservation);
            } else {
                System.out.println("Please, informe 'y' (for yes) or 'n' (for not)");
                return;
            }
        }catch (ParseException e){
            System.out.println("Invalid date Format");
        }catch (DomainException e) {
            System.out.println("Error in reservation: " + e.getMessage());
        }catch (RuntimeException e){
            System.out.println("Unexpected error");
        }

        sc.close();
    }
}