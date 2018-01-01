package com.github.mav80.codingschool;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import sun.util.calendar.CalendarUtils;

public class MainCodeAdmin4Solutions {

	public static void main(String[] args) {

		admin4();

	} //koniec main
	
	
	// Programy administracyjne - zadanie 4

		// metoda główna
		public static void admin4() {

			System.out.println("Program Admin4 - przypisywanie zadań.");

			String userInput = "";

			while (!userInput.equals("quit")) {

				System.out.println("\n\nWybierz jedną z opcji:\n\n"
				+ "add    - przypisywanie zadań do użytkowników\n"
				+ "view   - przeglądanie rozwiązań danego użytkownika\n"  
				+ "quit   - zakończenie programu\n");

				userInput = getConsoleString();

				if (userInput.equals("add")) {
					showAllUsers();
					System.out.println("\nPodaj ID użytkownika z powyższej listy któremu chcesz przypisać zadanie. ");
					int users_id = getNumberFromConsole();
					
					showAllExercises();
					System.out.println("\nPodaj ID ćwiczenia z powyższej listy które chcesz przypisać wybranemu użytkownikowi. ");
					int exercise_id = getNumberFromConsole(); 
					
					//ustawiamy datę dla pola created
					
					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date dateObj = new Date();
					String created = dateFormat.format(dateObj);
					
					addNewSolution(created, users_id, exercise_id);

				} else if (userInput.equals("view")) {
					showAllUsers();
					allSolutionsByUserId();

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

		static String printUserData(User user) {
			try {
				return "\nOto dane wybranego użytkownika.\nID:    " + user.getId() + "\nImię:  " + user.getUsername() + "\nemail: " + user.getEmail() + "\ngrupa do której należy: " + user.getPerson_group_id();
			} catch (Exception e) {
				return "Użytkownik o podanym id nie istnieje.";
			}
		}
		
		static String printExerciseData(Exercise exercise) {
			try {
				return "\nOto dane wybranego ćwiczenia.\nID:     " + exercise.getId() + "\nNazwa:  " + exercise.getTitle()
						+ "\nOpis: " + exercise.getDescription();
			} catch (Exception e) {
				return "Ćwiczenie o podanym id nie istnieje.";
			}
		}
		
		static String printSolutionData(Solution solution) {
			try {
				return "\nOto dane wybranego rozwiązania:\nID:    " + solution.getId() + "\nData utworzenia:            " + solution.getCreated() + "\nData ostatniej modyfikacji: " + solution.getUpdated() + "\nOpis:  " + solution.getDescription() + "\nexercise_id: " + solution.getExercise_id()  + "\nusers_id:  " + solution.getUsers_id();
			} catch (Exception e) {
				return "R o podanym id nie istnieje.";
			}
		}
		
		
		
		
		
		
		
		
		

		// metody obsługujące bazę
		
		static void showAllUsers() {
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
		
		
		
		
		static void showAllExercises() {

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
		
		
		
		
		static void addNewSolution(String created, int users_id, int exercise_id) {
			Solution solutionToAdd = new Solution();
			
			solutionToAdd.setCreated(created);
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
		}
		
		
		
		static void allSolutionsByUserId() {
			Solution[] soultionListByUserId = null;
			
			System.out.print("\nPodaj ID użytkownika którego rozwiązania które chcesz wyświetlić. ");
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
		}


		
	} //koniec klasy
