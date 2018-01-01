package com.github.mav80.codingschool;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MainCodeUser1 {

	public static void main(String[] args) {
		
		//sprawdzamy czy użytkownik wprowadził jakieś parametry przy uruchamianiu programu z linii komend
		
		int userId = -1;
		
		if (args.length > 0 ) {
			try {
				userId = Integer.parseInt(args[0]);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		
		
		
		user1(userId);

	} //koniec main
	
	
	
	
	
	public static void user1(int userId) {
		
		System.out.println("Program User1 - dodawanie rozwiązań.\n");
	
		dbConnection connection = new dbConnection();

		try {
			while (userId < 1 || User.loadUserById(connection.getConnection(), userId) == null) {
				System.out.println("Podaj swoje ID. Musi być większe od 0 oraz uzytkownik o takim ID musi istnieć w bazie. ");
				userId = getNumberFromConsole();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		//zamykamy połączenie
		connection.closeConnection();
		
		String userInput = "";
		
		while (!userInput.equals("quit")) {
			
			System.out.println("\nTwoje ID to " + userId + ".");

			System.out.println("\nWybierz jedną z opcji:\n\n"
			+ "add    - dodanie rozwiązania\n"
			+ "view   - przeglądanie swoich rozwiązań\n" 
			+ "quit   - zakończenie programu\n");

			userInput = getConsoleString();

			if (userInput.equals("add")) {
				showMissingSolutions(userId);
				
				//Solution solution = new Solution();
				
				
				//trzeba tu dorobic sprawdzanie czy cwiczenie o danym id istnieje w bazie
				System.out.println("\nPodaj ID ćwiczenia (exercise_id) z powyższej listy do którego chcesz dodać rozwiązanie. ");
				int exercise_id = getNumberFromConsole();
				
				//tworzymy polaczenie
				dbConnection connection2 = new dbConnection();
				
				try {
					if (!Solution.isSolutionToThisExerciseByThisUserInDatabase(connection2.getConnection(), exercise_id, userId)) {
						
						System.out.println("\nPodaj rozwiązanie ćwiczenia. ");
						String description = getConsoleString(); 
						
						//ustawiamy datę dla pola updated
						
						DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						Date dateObj = new Date();
						String updated = dateFormat.format(dateObj);
							
						Solution solutionToModify = new Solution();
						
						try {
							solutionToModify = Solution.loadSolutionByUserIdAndExerciseId(connection.getConnection(), userId, exercise_id);
						} catch (SQLException e) {
							System.out.println("Wystąpił problem z bazą danych. ");
							System.out.println(e.getMessage());
							e.printStackTrace();
						}

						// zamykamy połączenie
						connection.closeConnection();
						
						
						solutionToModify.setDescription(description);
						solutionToModify.setUpdated(updated);
			
						addModifiedSolution(solutionToModify);

						
					} else {
						System.out.println("\nRozwiązanie już istnieje, nie możesz go dodać ponownie.");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//zamykamy połączenie
				connection2.closeConnection();
				

			} else if (userInput.equals("view")) {
				showAllUserSolutions(userId);

			} else if (userInput.equals("quit")) {
				System.out.println("\nKoniec programu.");

			} else {
				System.out.println("\nNieprawidłowe polecenie - wpisz jeszcze raz.");
			}

		} // koniec while
		
		
		
		
		
	} //koniec user1
	
	
	
	
	
	
	
	
	
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
	
	
	
	//pozostałe metody pomocnicze
	
	static String printSolutionData(Solution solution) {
		try {
			return "\nOto dane wybranego rozwiązania:\nID:    " + solution.getId() + "\nData utworzenia:            " + solution.getCreated() + "\nData ostatniej modyfikacji: " + solution.getUpdated() + "\nOpis:  " + solution.getDescription() + "\nexercise_id: " + solution.getExercise_id()  + "\nusers_id:  " + solution.getUsers_id();
		} catch (Exception e) {
			return "Użytkownik o podanym ID nie istnieje.";
		}
	}
	
	static String printExerciseData(Exercise exercise) {
		try {
			return "\nOto dane wybranego ćwiczenia.\nID:     " + exercise.getId() + "\nNazwa:  " + exercise.getTitle() + "\nOpis: " + exercise.getDescription();
		} catch (Exception e) {
			return "Ćwiczenie o podanym id nie istnieje.";
		}
	}
	
	
	
	
	//metody obsługujące bazę
	
	static void showAllUserSolutions(int users_id) {
		Solution[] soultionListByUserId = null;
	
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
	}
	
	
	
	
	
	static void showMissingSolutions(int users_id) {
		
		
		System.out.println("Poniżej znajduje się spis ćwiczeń do których użytkownik jeszcze nie dodał rozwiązania.");
		
		Solution[] soultionList = null;
		
		//tworzymy polaczenie
		dbConnection connection = new dbConnection();
		
		try {
			soultionList = Solution.loadAllMissingSolutionsByUserId(connection.getConnection(), users_id);
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
	
	}
	
	
	
	
	static void addModifiedSolution(Solution solution) {
		
		
		//tworzymy polaczenie
		dbConnection connection = new dbConnection();
		
		//wywołujemy odpowiednią metodę
		try {
			solution.saveSolutionToDB(connection.getConnection());
			System.out.println("Rozwiązanie pomyślnie dodano do bazy danych.");
		} catch (SQLException e) {
			System.out.println("\nWystąpił problem z bazą danych - upewnij się że data jest w poprawnym formacie, a użytkownik i ćwiczenie o podanym id istnieją.\n");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	
		//zamykamy połączenie
		connection.closeConnection();
	}
	
	
	

	

} //koniec klasy
