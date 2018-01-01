package com.github.mav80.codingschool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class MainCode {

	public static void main(String[] args) {
		
		
System.out.println("Program glowny, znajduja sie w nim wszystkie programy do zarzadzania nasza baza danych.");
		
		int userInput = -1;
		
		while (userInput != 0) {
			
			System.out.println("\nWybierz jedną z opcji:\n\n" + 
					"1 - Program Admin1 - zarządzanie użytkownikami.\n" + 
					"2 - Program Admin2 - zarządzanie ćwiczeniami.\n" + 
					"3 - Program Admin3 - zarządzanie grupami.\n" +
					"4 - Program Admin4 - przypisywanie zadań i przeglądanie rozwiązań użytkowników\n\n" + 
					"7 - Program User1 - dodawanie rozwiązań przez użytkownika.\n\n" +
					"0 - Zakończenie programu\n");
			
			userInput = getNumberFromConsole();
			
			if (userInput == 1) {
				MainCodeAdmin1Users.admin1();
				
			} else if (userInput == 2) {
				MainCodeAdmin2Exercises.admin2();
				
			} else if (userInput == 3) {
				MainCodeAdmin3Groups.admin3();
				
			} else if (userInput == 4) {
				MainCodeAdmin4Solutions.admin4();
				
			} else if (userInput == 7) {
				MainCodeUser1.user1(-1);
				
			} else if (userInput == 0) {
				System.out.println("\nKoniec programu.");
				
			} else {
				System.out.println("\nNieprawidłowe polecenie - wpisz jeszcze raz.");
			}
			
		} //koniec while
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	} //koniec metody main
	
	
	

	
	//metody pomocnicze do wprowadzania danych z konsoli
	
	
	
	static int getNumberFromConsole() {
		 
 		@SuppressWarnings("resource")
 		Scanner myScanner = new Scanner(System.in);
 		int number;
 		System.out.println("Wpisz liczbę: ");
 
 		try {
 			number = myScanner.nextInt();
 		} catch (Exception e) {
 			System.out.println("To nie jest liczba!");
 			number = getNumberFromConsole();
 		}
 		return number;
 	}
	
	



}
