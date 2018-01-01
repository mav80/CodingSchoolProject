package com.github.mav80.codingschool;

import java.sql.SQLException;
import java.util.Scanner;

public class MainTestUser {

	public static void main(String[] args) {		
		
 /* dodajemy nowego użytkownika metodą saveToDb z klasy User - działa - testujemy metodę saveToDb
		
		User user1 = new User();
		
		System.out.print("Podaj nazwę użytkownika. ");
		String username = getConsoleString();
		
		System.out.print("Podaj email. ");
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
			user1.saveToDB(connection.getConnection());
			System.out.println("Użytkownika pomyślnie dodano do bazy danych.");
		} catch (SQLException e) {
			System.out.println("Wystąpił problem z bazą danych. ");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	
		//zamykamy połączenie
		connection.closeConnection();
		
		
//koniec dodawania nowego użytkownika */
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/* modyfikowanie istniejącego użytkownika - działa	- również testujemy metodę saveToDb, część po 'else'	
		
		
		//modyfikujemy istniejącego użytkownika. w tym celu należy go wczytać, wyświetlić dane na ekranie aby było wiadomo co można zmienić
		//pobrać od użytkownika nowe dane, ustawić je na obiekcie setterami i zapisać
		
		
			//Użytkownik wprowadza z klawiatury którego usera z bazy chce podejrzeć, wczytujemy go i wypisujemy na ekran - działa
			
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
			
			System.out.print("Podaj grupę. ");
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
		
	// koniec modyfikowania użytkownika */	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
/*		//Użytkownik wprowadza z klawiatury którego usera z bazy chce podejrzeć, wczytujemy go i wypisujemy na ekran - działa - testujemy metodę loadById
		
		User user2 = new User();

		System.out.print("Podaj ID użytkownika którego chcesz wyświetlić. ");
		int userid = getNumberFromConsole();

		// tworzymy polaczenie
		dbConnection connection = new dbConnection();

		try {
			user2 = User.loadUserById(connection.getConnection(), userid);
		} catch (SQLException e) {
			System.out.println("Wystąpił problem z bazą danych. ");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		// zamykamy połączenie
		connection.closeConnection();

		if (user2 != null) { // nulla dostajemy gdy user o podanym id nie istnieje

			// wypisujemy na ekran pobrane dane
			System.out.println(printUserData(user2));

		} else {
			System.out.println("Użytkownik o wybranym ID nie istnieje.");

		}
		
		//zamykamy połączenie
		connection.closeConnection();
		
// koniec wypisywania użytkownika o podanym ID*/	
		
		
		
		
		
		
		
		
		
		
  /*		// wczytujemy i wypisujemy wszystkich użytkowników z bazy - działa - testujemy metodę loadAllUsers
		
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
		
	//koniec wczytywania i wypisywania wszystkich użytkowników z bazy */
		
		
		
		
		
		
		
		
		
		
		
		/*		//usuwanie użytkownika z bazy - działa - testujemy metodę userDelete

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

	
	// koniec kasowania użytkownika z bazy */
		
		
		
		
		
		
		
		//Zadanie 5.1
			
	//	 /*	wczytujemy i wypisujemy wszystkich użytkowników należących do grupy o podanym ID z bazy - działa - testujemy metodę loadAllByGrupId
			
			User[] userListByUserGroupId = null;
			
			System.out.print("Podaj ID grupy której użytkowników chcesz wyświetlić. ");
			int person_group_id = getNumberFromConsole();
			
			//tworzymy polaczenie
			dbConnection connection = new dbConnection();
			
			try {
				userListByUserGroupId = User.loadAllByGrupId(connection.getConnection(), person_group_id);
			} catch (SQLException e) {
				System.out.println("Wystąpił problem z bazą danych. ");
				System.out.println(e.getMessage());
				e.printStackTrace();
			}

			if (userListByUserGroupId.length > 0) {
				System.out.println("\nOto lista użytkowników w grupie o danym id.\n");
				for (User user : userListByUserGroupId) {
					System.out.println(printUserData(user));
				}

			} else {
				System.out.println("Lista jest pusta.");
			}
			
			// */
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	} //koniec main
	
	
	
	
	
	
	//metody których używamy w kodzie
	
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
	
	
	static String printUserData(User user) {
		try {
			return "\nOto dane wybranego użytkownika.\nID:    " + user.getId() + "\nImię:  " + user.getUsername() + "\nemail: " + user.getEmail() + "\ngrupa do której należy: " + user.getPerson_group_id();
		} catch (Exception e) {
			return "Użytkownik o podanym id nie istnieje.";
		}
	}

	
	

} //koniec klasy
