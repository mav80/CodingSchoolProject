package com.github.mav80.codingschool;

import java.sql.SQLException;
import java.util.Scanner;

public class MainTestUserGroup {
	
	public static void main(String[] args) {
		
 /* dodajemy nową grupę metodą addGroupToDB z klasy UserGroup - działa - testujemy metodę addGroupToDB
		
		UserGroup groupToAdd = new UserGroup();
		
		System.out.print("Podaj nazwę grupy. ");
		String groupName = getConsoleString();
		groupToAdd.setGroupName(groupName);

		
		//tworzymy polaczenie
		dbConnection connection = new dbConnection();
		
		//wywołujemy odpowiednią metodę
		try {
			groupToAdd.addGroupToDB(connection.getConnection());
			System.out.println("Grupę pomyślnie dodano do bazy danych.");
		} catch (SQLException e) {
			System.out.println("Wystąpił problem z bazą danych. ");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	
		//zamykamy połączenie
		connection.closeConnection();
		
		
//koniec dodawania nowej grupy */
		
		
		
		
		
		
		
		
		
		
		
		
		
		/* modyfikowanie istniejącej grupy - działa	- również testujemy metodę addGroupToDB, część po 'else'	
		
		
		//modyfikujemy istniejącą grupę. w tym celu należy ją wczytać, wyświetlić dane na ekranie aby było wiadomo co można zmienić,
		//pobrać od użytkownika nowe dane, ustawić je na obiekcie setterami i zapisać
		
		
		//Użytkownik wprowadza z klawiatury którą grupę z bazy chce podejrzeć, wczytujemy ją i wypisujemy na ekran - działa
			
		UserGroup groupToChange = new UserGroup();
			
		System.out.print("Podaj ID grupy którą chcesz zmienić. ");
		int groupId = getNumberFromConsole();
			
		//tworzymy polaczenie
		dbConnection connection = new dbConnection();		
		
		try {
			groupToChange = groupToChange.loadGroupById(connection.getConnection(), groupId);
		} catch (SQLException e) {
			System.out.println("Wystąpił problem z bazą danych. Grupa nie istnieje?");
			System.out.println(e.getMessage());
			e.printStackTrace();
			//zamykamy połączenie
			connection.closeConnection();
		}
			
			
		if (groupToChange != null) { // działamy tylko jeśli grupa o podanym id istnieje

			// pobieramy dane i wypisujemy je na ekran
			System.out.println(printGroupData(groupToChange));

			String newGroupName;

			System.out.println("\nPodaj nowe dane grupy. Podaj nazwę grupy: ");
			newGroupName = getConsoleString();
			groupToChange.setGroupName(newGroupName);



			// zapisujemy zmodyfikowane dane
			try {
				groupToChange.addGroupToDB(connection.getConnection());
				System.out.println("\nDane grupy pomyślnie zmieniono.");
			} catch (SQLException e) {
				System.out.println(
						"Wystąpił problem z bazą, danych grupy nie zmieniono.");
				System.out.println(e.getMessage());
			}

			// zamykamy połączenie
			connection.closeConnection();

		} else {
			System.out.println("Grupa o wybranym ID nie istnieje.");

			// zamykamy połączenie
			connection.closeConnection();
		}
	
	// koniec modyfikowania grupy */	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	/*	Użytkownik wprowadza z klawiatury którą grupę z bazy chce podejrzeć, wczytujemy ją i wypisujemy na ekran - działa - testujemy metodę loadGroupById
		
		UserGroup group2 = new UserGroup();

		System.out.print("Podaj ID grupy którą chcesz wyświetlić. ");
		int groupId = getNumberFromConsole();

		// tworzymy polaczenie
		dbConnection connection = new dbConnection();

		try {
			group2 = UserGroup.loadGroupById(connection.getConnection(), groupId);
		} catch (SQLException e) {
			System.out.println("Wystąpił problem z bazą danych. ");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		// zamykamy połączenie
		connection.closeConnection();

		if (group2 != null) { // nulla dostajemy gdy grupa o podanym id nie istnieje

			// wypisujemy na ekran pobrane dane
			System.out.println(printGroupData(group2));

		} else {
			System.out.println("Grupa o wybranym ID nie istnieje.");

		}
		
		//zamykamy połączenie
		connection.closeConnection();
		
	//	// koniec wypisywania grupy o podanym ID */	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
 // /*		// wczytujemy i wypisujemy wszystkie grupy z bazy - działa - testujemy metodę loadAllGroups
		
		System.out.println("Poniżej znajdują się wszystkie dostępne obecnie grupy:\n");
		
		UserGroup[] groupList = null;
		
		//tworzymy polaczenie
		dbConnection connection = new dbConnection();
		
		try {
			groupList = UserGroup.loadAllGroups(connection.getConnection());
		} catch (SQLException e) {
			System.out.println("Wystąpił problem z bazą danych. ");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		if (groupList.length > 0) {
			for (UserGroup group : groupList) {
				System.out.println(printGroupData(group));
			}

		} else {
			System.out.println("Baza grup jest pusta.");
		}
			
				
		//zamykamy połączenie
		connection.closeConnection();
		
	//koniec wczytywania i wypisywania wszystkich grup z bazy */
		
		
		
		
		
		
		
		
		
		
	/*		//usuwanie grupy z bazy - testujemy metodę groupDelete

		UserGroup groupToDelete = new UserGroup();

		System.out.print("Podaj ID grupy którą chcesz usunąć. ");
		int userid = getNumberFromConsole();

		// tworzymy polaczenie
		dbConnection connection = new dbConnection();

		try {
			groupToDelete = UserGroup.loadGroupById(connection.getConnection(), userid);
		} catch (SQLException e) {
			System.out.println("Wystąpił problem z bazą danych. ");
			System.out.println(e.getMessage());
		}

		// kasujemy grupę o podanym id
		if (groupToDelete != null) {
			try {

				groupToDelete.groupDelete(connection.getConnection());
				System.out.println("Grupę usunięto pomyślnie.");
			} catch (Exception e) {
				System.out.println("Wystąpił problem z bazą danych - grupa nie istnieje? ");
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		} else {
			System.out.println("Grupa o podanym ID nie istnieje.");
		}

		// zamykamy połączenie
		connection.closeConnection();
		
		
	// koniec kasowania grupy z bazy */
		
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
	} //koniec main
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Metody których używamy w kodzie
	
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
	
	

	
	
	
	static String printGroupData(UserGroup group) {
		try {
			return "\nOto dane wybranej grupy.\nID:     " + group.getId() + "\nNazwa:  " + group.getGroupName();
		} catch (Exception e) {
			return "Grupa o podanym id nie istnieje.";
		}
	}

} //koniec klasy
