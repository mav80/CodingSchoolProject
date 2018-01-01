package com.github.mav80.codingschool;

import java.sql.SQLException;
import java.util.Scanner;

public class MainTestExercise {

	public static void main(String[] args) {
		
 /* dodajemy nowe ćwiczenie metodą addExerciseToDB z klasy Exercise - działa - testujemy metodę addExerciseToDB
		
		Exercise exerciseToAdd = new Exercise();
		
		System.out.print("Podaj nazwę ćwiczenia. ");
		String exerciseName = getConsoleString();
		
		System.out.print("Podaj opis ćwiczenia. ");
		String exerciseDescription = getConsoleString();
		
		exerciseToAdd.setTitle(exerciseName);
		exerciseToAdd.setDescription(exerciseDescription);
		
		//tworzymy polaczenie
		dbConnection connection = new dbConnection();
		
		//wywołujemy odpowiednią metodę
		try {
			exerciseToAdd.addExerciseToDB(connection.getConnection());
			System.out.println("Ćwiczenie pomyślnie dodano do bazy danych.");
		} catch (SQLException e) {
			System.out.println("Wystąpił problem z bazą danych. ");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	
		//zamykamy połączenie
		connection.closeConnection();
		
		
//koniec dodawania nowego ćwiczenia */
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/* modyfikowanie istniejącego ćwiczenia - działa	- również testujemy metodę addExerciseToDB, część po 'else'	
		
		
		//modyfikujemy istniejące ćwiczenie. w tym celu należy je wczytać, wyświetlić dane na ekranie aby było wiadomo co można zmienić,
		//pobrać od użytkownika nowe dane, ustawić je na obiekcie setterami i zapisać
		
	
		//Użytkownik wprowadza z klawiatury które ćwiczenie z bazy chce podejrzeć, wczytujemy je i wypisujemy na ekran - działa
		
		Exercise exerciseToChange = new Exercise();
		
		System.out.print("Podaj ID ćwiczenia które chcesz zmienić. ");
		int exerciseId = getNumberFromConsole();
		
		//tworzymy polaczenie
		dbConnection connection = new dbConnection();		
		
		try {
			exerciseToChange = Exercise.loadExerciseById(connection.getConnection(), exerciseId);
		} catch (SQLException e) {
			System.out.println("Wystąpił problem z bazą danych. Ćwiczenie nie istnieje?");
			System.out.println(e.getMessage());
			e.printStackTrace();
			//zamykamy połączenie
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
				System.out.println(
						"Wystąpił problem z bazą, danych ćwiczenia nie zmieniono.");
				System.out.println(e.getMessage());
			}

			// zamykamy połączenie
			connection.closeConnection();

		} else {
			System.out.println("Ćwiczenie o wybranym ID nie istnieje.");

			// zamykamy połączenie
			connection.closeConnection();
		}
		
	// koniec modyfikowania ćwiczenia */	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
   /*		//Użytkownik wprowadza z klawiatury które ćwiczenie z bazy chce podejrzeć, wczytujemy je i wypisujemy na ekran - działa - testujemy metodę loadExerciseById
		
		Exercise exerciseToShow = new Exercise();

		System.out.print("Podaj ID ćwiczenia które chcesz wyświetlić. ");
		int exerciseId = getNumberFromConsole();

		// tworzymy polaczenie
		dbConnection connection = new dbConnection();

		try {
			exerciseToShow = Exercise.loadExerciseById(connection.getConnection(), exerciseId);
		} catch (SQLException e) {
			System.out.println("Wystąpił problem z bazą danych. Ćwiczenie nie istnieje?");
			System.out.println(e.getMessage());
			e.printStackTrace();
			//zamykamy połączenie
			connection.closeConnection();
		}

		// zamykamy połączenie
		connection.closeConnection();

		if (exerciseToShow != null) { // nulla dostajemy gdy user o podanym id nie istnieje

			// wypisujemy na ekran pobrane dane
			System.out.println(printExerciseData(exerciseToShow));

		} else {
			System.out.println("Ćwiczenie o wybranym ID nie istnieje.");

		}
		
		//zamykamy połączenie
		connection.closeConnection();
		
// koniec wypisywania ćwiczenia o podanym ID*/	
		
		
		
		
		
		
		
		
		
		
   /*		// wczytujemy i wypisujemy wszystkie ćwiczenia z bazy - działa - testujemy metodę loadAllExercises
		
		System.out.println("Poniżej znajduje się spis wszystkich obecnych w bazie ćwiczeń.");
		
		Exercise[] exerciseList = null;
		
		//tworzymy polaczenie
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
			
				
		//zamykamy połączenie
		connection.closeConnection();
		
	//koniec wczytywania i wypisywania wszystkich ćwiczeń z bazy */
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*		//usuwanie ćwiczenia z bazy - działa - testujemy metodę exerciseDelete

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

	
	// koniec kasowania ćwiczenia z bazy */


		
		
		
		
		
		
		
		 /*	// wczytujemy i wypisujemy wszystkie ćwiczenia do których brakuje rozwiązań użytkownika o podanym id z bazy - działa - testujemy metodę loadAllMissingExercises
		
		
		System.out.print("Podaj ID użytkownika którego brakujące ćwiczenia chcesz wyświetlić. ");
		int userId = getNumberFromConsole();
		
		System.out.println("Poniżej znajduje się spis ćwiczeń do których użytkownik nie dodał rozwiązania.");
		
		Exercise[] exerciseList = null;
		
		//tworzymy polaczenie
		dbConnection connection = new dbConnection();
		
		try {
			exerciseList = Exercise.loadAllMissingExercises(connection.getConnection(), userId);
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
			
				
		//zamykamy połączenie
		connection.closeConnection();
		
	//koniec wczytywania i wypisywania ćwiczeń z brakującymi rozwiązaniami z bazy */
		
		
		
		
		
		
		
		
		
		
		
	//	 /*	// wczytujemy i wypisujemy wszystkie ćwiczenia do których istnieją rozwiązania użytkownika o podanym id z bazy - działa - testujemy metodę loadAllSolvedExercises
		
		
		System.out.print("Podaj ID użytkownika którego istniejące ćwiczenia chcesz wyświetlić. ");
		int userId = getNumberFromConsole();
		
		System.out.println("Poniżej znajduje się spis ćwiczeń do których użytkownik dodał jakieś rozwiązania.");
		
		Exercise[] exerciseList = null;
		
		//tworzymy polaczenie
		dbConnection connection = new dbConnection();
		
		try {
			exerciseList = Exercise.loadAllSolvedExercises(connection.getConnection(), userId);
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
			
				
		//zamykamy połączenie
		connection.closeConnection();
		
	//koniec wczytywania i wypisywania ćwiczeń z brakującymi rozwiązaniami z bazy */
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
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
	
	


	
	
	static String printExerciseData(Exercise exercise) {
		try {
			return "\nOto dane wybranego ćwiczenia.\nID:     " + exercise.getId() + "\nNazwa:  " + exercise.getTitle() + "\nOpis: " + exercise.getDescription();
		} catch (Exception e) {
			return "Ćwiczenie o podanym id nie istnieje.";
		}
	}

} //koniec klasy
