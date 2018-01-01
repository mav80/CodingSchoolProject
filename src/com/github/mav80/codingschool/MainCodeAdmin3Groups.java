package com.github.mav80.codingschool;

import java.sql.SQLException;
import java.util.Scanner;

public class MainCodeAdmin3Groups {

	public static void main(String[] args) {
		
		admin3();

	} //koniec main

	
	
	
	
	// Programy administracyjne - zadanie 3

	// metoda główna
	public static void admin3() {

		System.out.println("Program Admin3 - zarządzanie grupami.\nPoniżej znajduje się lista grup którymi możesz zarządzać:\n");

		showAllGroups();

		String userInput = "";

		while (!userInput.equals("quit")) {

			System.out.println("\n\nWybierz jedną z opcji:\n\n"
			+ "add    - dodanie grupy\n"
			+ "edit   - edycja grupy\n" 
			+ "delete - usunięcie grupy\n"
			+ "show   - wyświetla wszystkie grupy\n" 
			+ "quit   - zakończenie programu\n");

			userInput = getConsoleString();

			if (userInput.equals("add")) {
				addNewGroup();

			} else if (userInput.equals("edit")) {
				editExistingGroup();

			} else if (userInput.equals("delete")) {
				deleteGroup();

			} else if (userInput.equals("show")) {
				showAllGroups();

			} else if (userInput.equals("quit")) {
				System.out.println("\nKoniec programu.");

			} else {
				System.out.println("\nNieprawidłowe polecenie - wpisz jeszcze raz.");
			}

		} // koniec while

	} // koniec metody
	
	
	
	
	
	
	

	// metody pomocnicze do wprowadzania danych z konsoli

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

	// inne metody pomocnicze:

	static String printGroupData(UserGroup group) {
		try {
			return "\nOto dane wybranej grupy.\nID:     " + group.getId() + "\nNazwa:  " + group.getGroupName();
		} catch (Exception e) {
			return "Grupa o podanym id nie istnieje.";
		}
	}
	
	
	
	
	
	
	
	
	

	// metody obsługujące daną tabelę w bazie

	public static void showAllGroups() {

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
	}
	
	
	

	static void addNewGroup() {

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
	}
	
	
	
	
	
	

	static void editExistingGroup() {

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

	}
	
	
	

	static void deleteGroup() {

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
		

	}

	
	
} //koniec klasy
