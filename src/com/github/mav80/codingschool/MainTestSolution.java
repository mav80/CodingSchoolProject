package com.github.mav80.codingschool;

import java.sql.SQLException;
import java.util.Scanner;

public class MainTestSolution {

	public static void main(String[] args) {
		
		
  /* dodajemy nowe rozwiązanie metodą saveSolutionToDB z klasy Solution - działa - testujemy metodę saveSolutionToDB
		
		Solution solutionToAdd = new Solution();
		
		System.out.print("Podaj datę utworzenia w formacie: 2015-08-17 12:28:57. ");
		String created = getConsoleString();
		
		System.out.print("Podaj datę zmodyfikowania w formacie: 2015-08-17 12:28:57. ");
		String updated = getConsoleString();
		
		System.out.print("Podaj opis. ");
		String description = getConsoleString();
		
		System.out.print("Podaj exercise_id (id rozwiązania z bazy danych rozwiązań). ");
		int exercise_id = getNumberFromConsole();
		
		System.out.print("Podaj users_id (id użytkownika z bazy danych użytkowników). ");
		int users_id = getNumberFromConsole();
		
		solutionToAdd.setCreated(created);
		solutionToAdd.setUpdated(updated);
		solutionToAdd.setDescription(description);
		solutionToAdd.setExercise_id(exercise_id);
		solutionToAdd.setUsers_id(users_id);
		
		//tworzymy polaczenie
		dbConnection connection = new dbConnection();
		
		//wywołujemy odpowiednią metodę
		try {
			solutionToAdd.saveSolutionToDB(connection.getConnection());
			System.out.println("Rozwiązanie pomyślnie dodano do bazy danych.");
		} catch (SQLException e) {
			System.out.println("\nWystąpił problem z bazą danych - upewnij się że data jest w poprawnym formacie, a użytkownik i ćwiczenie o podanym id istnieją.\n");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	
		//zamykamy połączenie
		connection.closeConnection();
		
		
//koniec dodawania nowego rozwiązania */
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	/* modyfikowanie istniejącego rozwiązania - działa - również testujemy metodę saveSolutionToDB, część po 'else'	
	
	
	//modyfikujemy istniejące rozwiązanie. w tym celu należy je wczytać, wyświetlić dane na ekranie aby było wiadomo co można zmienić,
	//pobrać od użytkownika nowe dane, ustawić je na obiekcie setterami i zapisać
	
	
	//Użytkownik wprowadza z klawiatury które rozwiązanie z bazy chce podejrzeć, wczytujemy je i wypisujemy na ekran - działa
	
	Solution solutionToChange = new Solution();
	
	System.out.print("Podaj ID rozwiązania które chcesz zmienić. ");
	int solutionId = getNumberFromConsole();
	
	//tworzymy polaczenie
	dbConnection connection = new dbConnection();		
	
	try {
		solutionToChange = Solution.loadSolutionById(connection.getConnection(), solutionId);
	} catch (SQLException e) {
		System.out.println("Wystąpił problem z bazą danych. Rozwiązanie nie istnieje?");
		System.out.println(e.getMessage());
		e.printStackTrace();
		//zamykamy połączenie
		connection.closeConnection();
	}
	
	
	if (solutionToChange != null) { // działamy tylko jeśli użytkownik o podanym id istnieje

		// pobieramy dane i wypisujemy je na ekran
		System.out.println(printSolutionData(solutionToChange));

		System.out.print("\nPodaj dane do zmiany. Podaj datę utworzenia w formacie: 2015-08-17 12:28:57. ");
		String created = getConsoleString();
		
		System.out.print("Podaj datę zmodyfikowania w formacie: 2015-08-17 12:28:57. ");
		String updated = getConsoleString();
		
		System.out.print("Podaj opis. ");
		String description = getConsoleString();
		
		System.out.print("Podaj exercise_id (id rozwiązania z bazy danych rozwiązań). ");
		int exercise_id = getNumberFromConsole();
		
		System.out.print("Podaj users_id (id użytkownika z bazy danych użytkowników). ");
		int users_id = getNumberFromConsole();
		
		solutionToChange.setCreated(created);
		solutionToChange.setUpdated(updated);
		solutionToChange.setDescription(description);
		solutionToChange.setExercise_id(exercise_id);
		solutionToChange.setUsers_id(users_id);
		

		// zapisujemy zmodyfikowane dane
		try {
			solutionToChange.saveSolutionToDB(connection.getConnection());
			System.out.println("Rozwiązanie pomyślnie zmodyfikowano.");
		} catch (SQLException e) {
			System.out.println("\nWystąpił problem z bazą danych - upewnij się że data jest w poprawnym formacie, a użytkownik i ćwiczenie o podanym id istnieją.\n");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}	connection.closeConnection();


		// zamykamy połączenie
		connection.closeConnection();

	} else {
		System.out.println("Ćwiczenie o wybranym ID nie istnieje.");

		// zamykamy połączenie
		connection.closeConnection();
	}
	
// koniec modyfikowania rozwiązania */	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
   /*	//Użytkownik wprowadza z klawiatury które rozwiązanie z bazy chce podejrzeć, wczytujemy je i wypisujemy na ekran - działa - testujemy metodę loadSolutionById
		
		Solution solutionToShow = new Solution();

		System.out.print("Podaj ID rozwiązania które chcesz wyświetlić. ");
		int solutionId = getNumberFromConsole();

		// tworzymy polaczenie
		dbConnection connection = new dbConnection();

		try {
			solutionToShow = Solution.loadSolutionById(connection.getConnection(), solutionId);
		} catch (SQLException e) {
			System.out.println("Wystąpił problem z bazą danych. ");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		// zamykamy połączenie
		connection.closeConnection();

		if (solutionToShow != null) { // nulla dostajemy gdy rozwiązanie o podanym id nie istnieje

			// wypisujemy na ekran pobrane dane
			System.out.println(printSolutionData(solutionToShow));

		} else {
			System.out.println("Rozwiązanie o wybranym ID nie istnieje.");

		}
		
		//zamykamy połączenie
		connection.closeConnection();
		
// koniec wypisywania rozwiązania o podanym ID*/	
		
		
		
		
		
		
		
		
		
		
  /*	wczytujemy i wypisujemy wszystkie rozwiązania z bazy - działa - testujemy metodę loadAllSolutions
		
		Solution[] soultionList = null;
		
		//tworzymy polaczenie
		dbConnection connection = new dbConnection();
		
		try {
			soultionList = Solution.loadAllSolutions(connection.getConnection());
		} catch (SQLException e) {
			System.out.println("Wystąpił problem z bazą danych. ");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		if (soultionList.length > 0) {
			for (Solution solution : soultionList) {
				System.out.println(printSolutionData(solution));
			}

		} else {
			System.out.println("Baza rozwiązań jest pusta.");
		}
			
				
		//zamykamy połączenie
		connection.closeConnection();
		
	//koniec wczytywania i wypisywania wszystkich rozwiązań z bazy */
		
		
		
		
		
		
		
		
		
		
		
		/*		//usuwanie rozwiązania z bazy - działa - testujemy metodę solutionDelete

		Solution solutionToDelete = new Solution();

		System.out.print("Podaj ID rozwiązanie którego chcesz usunąć. ");
		int solutionId = getNumberFromConsole();

		// tworzymy polaczenie
		dbConnection connection = new dbConnection();

		try {
			solutionToDelete = Solution.loadSolutionById(connection.getConnection(), solutionId);
		} catch (SQLException e) {
			System.out.println("Wystąpił problem z bazą danych. ");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		// kasujemy rozwiązanie o podanym id

		if (solutionToDelete != null) {

			try {

				solutionToDelete.solutionDelete(connection.getConnection());
				System.out.println("Rozwiązanie usunięto pomyślnie.");
			} catch (Exception e) {
				System.out.println("Wystąpił problem z bazą danych - rozwiązanie nie istnieje? ");
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		} else {
			System.out.println("Rozwiązanie o podanym ID nie istnieje.");
		}

		// zamykamy połączenie
		connection.closeConnection();

	
	// koniec kasowania rozwiązania z bazy */
		
		


		
		
		//Zadanie 5.1
		
		//pobranie wszystkich rozwiązań danego użytkownika (dopisz metodę loadAllByUserId
		//do klasy Exercise )
		
		
		
  /*	wczytujemy i wypisujemy wszystkie rozwiązania użytkownika o podanym ID z bazy - działa - testujemy metodę loadAllByUserId
		
		Solution[] soultionListByUserId = null;
		
		System.out.print("Podaj ID użytkownika którego rozwiązania które chcesz wyświetlić. ");
		int users_id = getNumberFromConsole();
		
		//tworzymy polaczenie
		dbConnection connection = new dbConnection();
		
		try {
			soultionListByUserId = Solution.loadAllByUserId(connection.getConnection(), users_id);
		} catch (SQLException e) {
			System.out.println("Wystąpił problem z bazą danych. ");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		if (soultionListByUserId.length > 0) {
			System.out.println("Oto lista rozwiązań wybranego użytkownika.\n");
			for (Solution solution : soultionListByUserId) {
				System.out.println(printSolutionData(solution));
			}

		} else {
			System.out.println("Baza rozwiązań jest pusta.");
		}
			
				
		//zamykamy połączenie
		connection.closeConnection();
		
	//koniec wczytywania i wypisywania wszystkich rozwiązań użytkownika z bazy */
		
		
		
		
		
		
		
		
		
		
		
		//Zadanie 5.2
		
		//pobranie wszystkich rozwiązań danego zadania posortowanych od najnowszego do
		//najstarszego (dopisz metodę loadAllByExerciseId do klasy Solution )
		
		
		
  /*	wczytujemy i wypisujemy wszystkie rozwiązania  o podanym ID z bazy, posortowane po dacie  - działa - testujemy metodę loadAllByExerciseId
		
		Solution[] soultionListByExerciseId = null;
		
		System.out.print("Podaj ID zadania którego rozwiązania które chcesz wyświetlić. ");
		int exercise_id = getNumberFromConsole();
		
		//tworzymy polaczenie
		dbConnection connection = new dbConnection();
		
		try {
			soultionListByExerciseId = Solution.loadAllByExerciseId(connection.getConnection(), exercise_id);
		} catch (SQLException e) {
			System.out.println("Wystąpił problem z bazą danych. ");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		if (soultionListByExerciseId.length > 0) {
			System.out.println("Oto lista rozwiązań wybranego zadania.\n");
			for (Solution solution : soultionListByExerciseId) {
				System.out.println(printSolutionData(solution));
			}

		} else {
			System.out.println("Baza rozwiązań jest pusta.");
		}
		
		//zamykamy połączenie
		connection.closeConnection();
		
		//koniec wczytywania */
		
		
		
		
		
		
		
		
		 /* sprawdzamy metodę isSolutionToThisExerciseByThisUserInDatabase
		
		boolean isInDatabase = false;
		
		System.out.print("Podaj ID użytkownika. ");
		int users_id = getNumberFromConsole();
		
		System.out.print("Podaj ID zadania. ");
		int exercise_id = getNumberFromConsole();
		
		//tworzymy polaczenie
		dbConnection connection = new dbConnection();
		
		try {
			isInDatabase = Solution.isSolutionToThisExerciseByThisUserInDatabase(connection.getConnection(), exercise_id, users_id);
		} catch (SQLException e) {
			System.out.println("Wystąpił problem z bazą danych. ");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		if (isInDatabase == true) {
			System.out.println("Rozwiązanie do tego zadania już jest w bazie.");
		} else {
			System.out.println("Rozwiązania do tego zadania jeszcze nie ma w bazie.");
		}
		
		//zamykamy połączenie
		connection.closeConnection();
		
		//koniec  */
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//   /*	//Użytkownik wprowadza z klawiatury które rozwiązanie z bazy chce podejrzeć o podanym exercise_id, wczytujemy je i wypisujemy na ekran - działa - testujemy metodę loadSolutionById
		
				Solution solutionToShow = new Solution();

				System.out.print("Podaj users_id rozwiązania które chcesz wyświetlić. ");
				int users_id = getNumberFromConsole();
				
				System.out.print("Podaj exercise_id rozwiązania które chcesz wyświetlić. ");
				int exercise_id = getNumberFromConsole();

				// tworzymy polaczenie
				dbConnection connection = new dbConnection();

				try {
					solutionToShow = Solution.loadSolutionByUserIdAndExerciseId(connection.getConnection(), users_id, exercise_id);
				} catch (SQLException e) {
					System.out.println("Wystąpił problem z bazą danych. ");
					System.out.println(e.getMessage());
					e.printStackTrace();
				}

				// zamykamy połączenie
				connection.closeConnection();

				if (solutionToShow != null) { // nulla dostajemy gdy rozwiązanie o podanym id nie istnieje

					// wypisujemy na ekran pobrane dane
					System.out.println(printSolutionData(solutionToShow));

				} else {
					System.out.println("Rozwiązanie o wybranym ID nie istnieje.");

				}
				
				//zamykamy połączenie
				connection.closeConnection();
				
		// koniec wypisywania rozwiązania o podanym ID*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
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
	
	

	
	
	
	
	static String printSolutionData(Solution solution) {
		try {
			return "\nOto dane wybranego rozwiązania:\nID:    " + solution.getId() + "\nData utworzenia:            " + solution.getCreated() + "\nData ostatniej modyfikacji: " + solution.getUpdated() + "\nOpis:  " + solution.getDescription() + "\nexercise_id: " + solution.getExercise_id()  + "\nusers_id:  " + solution.getUsers_id();
		} catch (Exception e) {
			return "Użytkownik o podanym id nie istnieje.";
		}
	}

} // koniec klasy
