package com.github.mav80.codingschool;

import java.sql.SQLException;
import java.util.Scanner;

public class MainCodeAdmin2Exercises {

	public static void main(String[] args) {

		admin2();

	} // koniec main
	
	
	
	

	// Programy administracyjne - zadanie 2

	// metoda główna
	public static void admin2() {

		System.out.println(
				"Program Admin2 - zarządzanie ćwiczeniami.\nPoniżej znajduje się lista ćwiczeń którymi możesz zarządzać:\n");

		showAllExercises();

		String userInput = "";

		while (!userInput.equals("quit")) {

			System.out.println("\n\nWybierz jedną z opcji:\n\n"
			+ "add    - dodanie ćwiczenia\n"
			+ "edit   - edycja ćwiczenia\n" 
			+ "delete - usunięcie ćwiczenia\n"
			+ "show   - wyświetla wszystkie ćwiczenia\n" 
			+ "quit   - zakończenie programu\n");

			userInput = getConsoleString();

			if (userInput.equals("add")) {
				addNewExercise();

			} else if (userInput.equals("edit")) {
				editExistingExercise();

			} else if (userInput.equals("delete")) {
				deleteExercise();

			} else if (userInput.equals("show")) {
				showAllExercises();

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

	static String printExerciseData(Exercise exercise) {
		try {
			return "\nOto dane wybranego ćwiczenia.\nID:     " + exercise.getId() + "\nNazwa:  " + exercise.getTitle()
					+ "\nOpis: " + exercise.getDescription();
		} catch (Exception e) {
			return "Ćwiczenie o podanym id nie istnieje.";
		}
	}
	
	
	
	
	
	
	
	
	

	// metody obsługujące daną tabelę w bazie

	public static void showAllExercises() {

		System.out.println("Poniżej znajduje się spis wszystkich obecnych w bazie ćwiczeń.");

		Exercise[] exerciseList = null;

		// tworzymy polaczenie
		dbConnection connection = new dbConnection();

		try {
			exerciseList = Exercise.loadAllExercises(connection.getConnection());
		} catch (SQLException e) {
			System.out.println("Wystąpił problem z bazą danych. ");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		if (exerciseList.length > 0) {
			for (Exercise exercise : exerciseList) {
				System.out.println(printExerciseData(exercise));
			}

		} else {
			System.out.println("Baza ćwiczeń jest pusta.");
		}

		// zamykamy połączenie
		connection.closeConnection();
	}
	
	
	

	static void addNewExercise() {

		Exercise exerciseToAdd = new Exercise();

		System.out.print("Podaj nazwę ćwiczenia. ");
		String exerciseName = getConsoleString();

		System.out.print("Podaj opis ćwiczenia. ");
		String exerciseDescription = getConsoleString();

		exerciseToAdd.setTitle(exerciseName);
		exerciseToAdd.setDescription(exerciseDescription);

		// tworzymy polaczenie
		dbConnection connection = new dbConnection();

		// wywołujemy odpowiednią metodę
		try {
			exerciseToAdd.addExerciseToDB(connection.getConnection());
			System.out.println("Ćwiczenie pomyślnie dodano do bazy danych.");
		} catch (SQLException e) {
			System.out.println("Wystąpił problem z bazą danych. ");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		// zamykamy połączenie
		connection.closeConnection();
	}
	
	
	

	static void editExistingExercise() {

		Exercise exerciseToChange = new Exercise();

		System.out.print("Podaj ID ćwiczenia które chcesz zmienić. ");
		int exerciseId = getNumberFromConsole();

		// tworzymy polaczenie
		dbConnection connection = new dbConnection();

		try {
			exerciseToChange = Exercise.loadExerciseById(connection.getConnection(), exerciseId);
		} catch (SQLException e) {
			System.out.println("Wystąpił problem z bazą danych. Ćwiczenie nie istnieje?");
			System.out.println(e.getMessage());
			e.printStackTrace();
			// zamykamy połączenie
			connection.closeConnection();
		}

		if (exerciseToChange != null) { // działamy tylko jeśli ćwiczenie o podanym id istnieje

			// pobieramy dane i wypisujemy je na ekran
			System.out.println(printExerciseData(exerciseToChange));

			String newExerciseName, newExerciseDescription;

			System.out.println("\nPodaj nowe dane ćwiczenia. Podaj nazwę ćwiczenia: ");
			newExerciseName = getConsoleString();
			exerciseToChange.setTitle(newExerciseName);

			System.out.println("\nPodaj opis ćwiczenia: ");
			newExerciseDescription = getConsoleString();
			exerciseToChange.setDescription(newExerciseDescription);

			// zapisujemy zmodyfikowane dane
			try {
				exerciseToChange.addExerciseToDB(connection.getConnection());
				System.out.println("\nDane ćwiczenia pomyślnie zmieniono.");
			} catch (SQLException e) {
				System.out.println("Wystąpił problem z bazą, danych ćwiczenia nie zmieniono.");
				System.out.println(e.getMessage());
			}

			// zamykamy połączenie
			connection.closeConnection();

		} else {
			System.out.println("Ćwiczenie o wybranym ID nie istnieje.");

			// zamykamy połączenie
			connection.closeConnection();
		}

	}
	
	
	

	static void deleteExercise() {

		Exercise exerciseToDelete = new Exercise();

		System.out.print("Podaj ID ćwiczenia które chcesz usunąć. ");
		int userid = getNumberFromConsole();

		// tworzymy polaczenie
		dbConnection connection = new dbConnection();

		try {
			exerciseToDelete = Exercise.loadExerciseById(connection.getConnection(), userid);
		} catch (SQLException e) {
			System.out.println("Wystąpił problem z bazą danych. ");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		// kasujemy użytkownika o podanym id

		if (exerciseToDelete != null) {

			try {

				exerciseToDelete.exerciseDelete(connection.getConnection());
				System.out.println("Ćwiczenie usunięto pomyślnie.");
			} catch (Exception e) {
				System.out.println("Wystąpił problem z bazą danych - ćwiczenie nie istnieje? ");
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		} else {
			System.out.println("Ćwiczenie o podanym ID nie istnieje.");
		}

		// zamykamy połączenie
		connection.closeConnection();

	}
	
	
	

} // koniec klasy
