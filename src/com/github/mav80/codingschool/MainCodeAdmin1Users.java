package com.github.mav80.codingschool;

import java.sql.SQLException;
import java.util.Scanner;

public class MainCodeAdmin1Users {

	public static void main(String[] args) {
		
		admin1();

	} //koniec main
	
	

	
	
	// Programy administracyjne - zadanie 1
	
	
	//metoda główna
	public static void admin1() {
		
		System.out.println("Program Admin1 - zarządzanie użytkownikami.\nPoniżej znajduje się lista użytkowników którymi możesz zarządzać:\n");
		
		showAllUsers();
		
		String userInput = "";
		
		while (!userInput.equals("quit")) {
			
			System.out.println("\n\nWybierz jedną z opcji:\n\n" + 
					"add    - dodanie użytkownika\n" + 
					"edit   - edycja użytkownika\n" + 
					"delete - usunięcie użytkownika\n" +
					"show   - wyświetla wszystkich użytkowników\n" + 
					"quit   - zakończenie programu\n");
			
			userInput = getConsoleString();
			
			if (userInput.equals("add")) {
				addNewUser();
				
			} else if (userInput.equals("edit")) {
				editExistingUser();
				
			} else if (userInput.equals("delete")) {
				deleteUser();
				
			} else if (userInput.equals("show")) {
				showAllUsers();
				
			} else if (userInput.equals("quit")) {
				System.out.println("\nKoniec programu.");
				
			} else {
				System.out.println("\nNieprawidłowe polecenie - wpisz jeszcze raz.");
			}
			
		} //koniec while
		
	} //koniec metody
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	//metody pomocnicze do wprowadzania danych z konsoli
	
	static String getConsoleString() {
		Scanner myScanner = new Scanner(System.in);
		System.out.println("Wpisz odpowiedź: ");
		String string = myScanner.nextLine();
		return string;
	}
	
	
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
	
	
	
	
	
	
	
	//inne metody pomocnicze:
	
	static String printUserData(User user) {
		try {
			return "\nOto dane wybranego użytkownika.\nID:    " + user.getId() + "\nImię:  " + user.getUsername() + "\nemail: " + user.getEmail() + "\ngrupa do której należy: " + user.getPerson_group_id();
		} catch (Exception e) {
			return "Użytkownik o podanym id nie istnieje.";
		}
	}
	
	
	
	
	
	
	
	
	
	//metody obsługujące daną tabelę w bazie
	
	public static void showAllUsers() {
		User[] userList = null;
		
		//tworzymy polaczenie
		dbConnection connection = new dbConnection();
		
		try {
			userList = User.loadAllUsers(connection.getConnection());
		} catch (SQLException e) {
			System.out.println("Wystąpił problem z bazą danych. ");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		if (userList.length > 0) {
			for (User user : userList) {
				System.out.println(printUserData(user));
			}

		} else {
			System.out.println("Baza użytkowników jest pusta.");
		}
			
				
		//zamykamy połączenie
		connection.closeConnection();
	}
	
	
	
	
	
	static void addNewUser() {
		User user = new User();
		
		System.out.print("Podaj nazwę użytkownika. ");
		String username = getConsoleString();
		
		System.out.print("Podaj email (musi być unikatowy - nie może już znajdować się w bazie). ");
		String email = getConsoleString();
		
		System.out.print("Podaj hasło. ");
		String password = getConsoleString();
		
		System.out.print("Podaj grupę. ");
		int person_group_id = getNumberFromConsole();
		
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(password);
		user.setPerson_group_id(person_group_id);
		
		
		//tworzymy polaczenie
		dbConnection connection = new dbConnection();
		
		//wywołujemy odpowiednią metodę
		try {
			user.saveToDB(connection.getConnection());
			System.out.println("Użytkownika pomyślnie dodano do bazy danych.");
		} catch (SQLException e) {
			System.out.println("Wystąpił problem z bazą danych. Może taki email już istnieje w bazie?");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	
		//zamykamy połączenie
		connection.closeConnection();
	}
	
	
	
	
	
	
	
	static void editExistingUser() {
		
		User userToChange = new User();
		
		System.out.print("Podaj ID użytkownika którego chcesz zmienić. ");
		int userid = getNumberFromConsole();
		
		//tworzymy polaczenie
		dbConnection connection = new dbConnection();		
		
		try {
			userToChange = User.loadUserById(connection.getConnection(), userid);
		} catch (SQLException e) {
			System.out.println("Wystąpił problem z bazą danych. Użytkownik nie istnieje?");
			System.out.println(e.getMessage());
			e.printStackTrace();
			//zamykamy połączenie
			connection.closeConnection();
		}
		
		
		if (userToChange != null) { // działamy tylko jeśli użytkownik o podanym id istnieje

			// pobieramy dane i wypisujemy je na ekran
			System.out.println(printUserData(userToChange));

			String newUserName, newUseEmail;

			System.out.println("\nPodaj nowe dane użytkownika. Podaj imię użytkownika: ");
			newUserName = getConsoleString();
			

			System.out.println("\nPodaj email użytkownika (musi być unikatowy - nie może już znajdować się w bazie): "); // email musi być unikatowy, trzeba później dorobić sprawdzanie
			newUseEmail = getConsoleString();
			
			System.out.print("\nPodaj grupę. ");
			int person_group_id = getNumberFromConsole();
			
			userToChange.setUsername(newUserName);
			userToChange.setEmail(newUseEmail);
			userToChange.setPerson_group_id(person_group_id);
			

			// zapisujemy zmodyfikowane dane
			try {
				userToChange.saveToDB(connection.getConnection());
				System.out.println("\nDane użytkownika pomyślnie zmieniono.");
			} catch (SQLException e) {
				System.out.println(
						"Wystąpił problem z bazą, danych użytkownika nie zmieniono. Może taki email już istnieje (musi być unikatowy)?");
				System.out.println(e.getMessage());
			}

			// zamykamy połączenie
			connection.closeConnection();

		} else {
			System.out.println("Użytkownik o wybranym ID nie istnieje.");

			// zamykamy połączenie
			connection.closeConnection();
		}
		
	}
	
	static void deleteUser() {
		
		User userToDelete = new User();

		System.out.print("Podaj ID użytkownika którego chcesz usunąć. ");
		int userid = getNumberFromConsole();

		// tworzymy polaczenie
		dbConnection connection = new dbConnection();

		try {
			userToDelete = User.loadUserById(connection.getConnection(), userid);
		} catch (SQLException e) {
			System.out.println("Wystąpił problem z bazą danych. ");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		// kasujemy użytkownika o podanym id

		if (userToDelete != null) {

			try {

				userToDelete.userDelete(connection.getConnection());
				System.out.println("Użytkownika usunięto pomyślnie.");
			} catch (Exception e) {
				System.out.println("Wystąpił problem z bazą danych - użytkownik nie istnieje? ");
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		} else {
			System.out.println("Użytkownik o podanym ID nie istnieje.");
		}

		// zamykamy połączenie
		connection.closeConnection();
		
	}
	
	
	
	

} //koniec klasy
