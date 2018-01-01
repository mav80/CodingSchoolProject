package com.github.mav80.codingschool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Solution {
	
	private int id;
	private String created;
	private String updated;
	private String description;
	private int exercise_id;
	private int users_id;
	
	public Solution(String created, String updated, String description) {
		this.created = created;
		this.updated = updated;
		this.description = description;
		
	}
	
	public Solution() {}

	
	
	public int getId() {
		return id;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getExercise_id() {
		return exercise_id;
	}

	public void setExercise_id(int exercise_id) {
		this.exercise_id = exercise_id;
	}

	public int getUsers_id() {
		return users_id;
	}

	public void setUsers_id(int users_id) {
		this.users_id = users_id;
	}
	
	
	//dodawanie rozwiązania do bazy - używamy na obiekcie klasy Solution
	public void saveSolutionToDB(Connection conn) throws SQLException {
		if (this.id == 0) { //jeśli id = 0 to znaczy że tworzymy nowe rozwiązanie
			String sql = "INSERT INTO solution(created, updated, description, exercise_id, users_id) VALUES (?, ?, ?, ?, ?)";
			String generatedColumns[] = { "ID" }; //dowiadujemy się jakie było ID ostatniego rzędu
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql, generatedColumns);
			preparedStatement.setString(1, this.created);
			preparedStatement.setString(2, this.updated);
			preparedStatement.setString(3, this.description);
			preparedStatement.setInt(4, this.exercise_id);
			preparedStatement.setInt(5, this.users_id);
			preparedStatement.executeUpdate();
			ResultSet rs = preparedStatement.getGeneratedKeys();
			if (rs.next()) {
				this.id = rs.getInt(1);
			}
		}else { //jeśli inne niż zero to uaktualniamy
			String sql = "UPDATE solution SET created = ?, updated = ?, description = ?, exercise_id = ?, users_id = ? WHERE id = ?";
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, this.created);
			preparedStatement.setString(2, this.updated);
			preparedStatement.setString(3, this.description);
			preparedStatement.setInt(4, this.exercise_id);
			preparedStatement.setInt(5, this.users_id);
			preparedStatement.setInt(6, this.id);
			preparedStatement.executeUpdate();
		}
	}	
		
	//wczytywanie rozwiązania po ID - metoda statyczna więc używamy już na klasie, nie na obiekcie	
	static public Solution loadSolutionById(Connection conn, int id) throws SQLException {
		String sql = "SELECT * FROM solution WHERE id = ?";
		PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			Solution loadedSolution = new Solution();
			loadedSolution.id = resultSet.getInt("id");
			loadedSolution.created = resultSet.getString("created");
			loadedSolution.updated = resultSet.getString("updated");
			loadedSolution.description = resultSet.getString("description");
			loadedSolution.exercise_id = resultSet.getInt("exercise_id");
			loadedSolution.users_id = resultSet.getInt("users_id");
			return loadedSolution;
		}
		return null;
	}
	
	
	//wczytujemy wszystkie rozwiązania
	static public Solution[] loadAllSolutions(Connection conn) throws SQLException {
		ArrayList<Solution> solutions = new ArrayList<Solution>();
		String sql = "SELECT * FROM solution"; PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			Solution loadedSolution = new Solution();
			loadedSolution.id = resultSet.getInt("id");
			loadedSolution.created = resultSet.getString("created");
			loadedSolution.updated = resultSet.getString("updated");
			loadedSolution.description = resultSet.getString("description");
			loadedSolution.exercise_id = resultSet.getInt("exercise_id");
			loadedSolution.users_id = resultSet.getInt("users_id");
			solutions.add(loadedSolution);
		}
		Solution[] sArray = new Solution[solutions.size()];
		sArray = solutions.toArray(sArray);
		return sArray;
	}
	
	
	//kasujemy rozwiązanie z bazy - musimy użyć na obiekcie z klasy Solution
	public void solutionDelete(Connection conn) throws SQLException {
		if (this.id != 0) {
			String sql = "DELETE FROM solution WHERE id = ?";
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, this.id);
			preparedStatement.executeUpdate();
			this.id=0;
		}
	}


	
	
	
	
	
	
	// zadanie 5.1
	
	
	//wczytywanie wszystkich rozwiązań po ID użytkownika - metoda statyczna więc używamy już na klasie, nie na obiekcie	
	static public Solution[] loadAllByUserId(Connection conn, int users_id) throws SQLException {
		ArrayList<Solution> solutions = new ArrayList<Solution>();
		String sql = "SELECT * FROM solution WHERE users_id = ?";
		PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setInt(1, users_id);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			Solution loadedSolution = new Solution();
			loadedSolution.id = resultSet.getInt("id");
			loadedSolution.created = resultSet.getString("created");
			loadedSolution.updated = resultSet.getString("updated");
			loadedSolution.description = resultSet.getString("description");
			loadedSolution.exercise_id = resultSet.getInt("exercise_id");
			loadedSolution.users_id = resultSet.getInt("users_id");
			solutions.add(loadedSolution);
		}
		
		Solution[] sArray = new Solution[solutions.size()];
		sArray = solutions.toArray(sArray);
		return sArray;

	}
	
	
	
	
	
	
	// zadanie 5.2
	
	//pobranie wszystkich rozwiązań danego zadania posortowanych od najnowszego do
	//	najstarszego (dopisz metodę loadAllByExerciseId do klasy Solution )
	
	
	//wczytywanie wszystkich rozwiązań o danym ID posortowanych od najnowszego - metoda statyczna więc używamy już na klasie, nie na obiekcie	
	static public Solution[] loadAllByExerciseId(Connection conn, int exercise_id) throws SQLException {
		ArrayList<Solution> solutions = new ArrayList<Solution>();
		String sql = "SELECT * FROM solution WHERE exercise_id = ? ORDER BY created ASC";
		PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setInt(1, exercise_id);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			Solution loadedSolution = new Solution();
			loadedSolution.id = resultSet.getInt("id");
			loadedSolution.created = resultSet.getString("created");
			loadedSolution.updated = resultSet.getString("updated");
			loadedSolution.description = resultSet.getString("description");
			loadedSolution.exercise_id = resultSet.getInt("exercise_id");
			loadedSolution.users_id = resultSet.getInt("users_id");
			solutions.add(loadedSolution);
		}
		
		Solution[] sArray = new Solution[solutions.size()];
		sArray = solutions.toArray(sArray);
		return sArray;

	}
	
	
	
	
	//Zadanie program użytkownika 1 - dorobiona przeze mnie metoda która sprawdza czy rozwiązanie o danym id użytkownika o danym id jest już w bazie
	
	//wczytujemy wszystkie ćwiczenia o podanym id dodane przez użytkownika o podanym id
	static public boolean isSolutionToThisExerciseByThisUserInDatabase(Connection conn, int exercise_id, int users_id) throws SQLException {
		ArrayList<Solution> solutions = new ArrayList<Solution>();
		String sql = "SELECT * FROM solution WHERE description IS NOT NULL AND exercise_id = ? AND users_id = ?"; 
		PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setInt(1, exercise_id);
		preparedStatement.setInt(2, users_id);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			Solution loadedSolution = new Solution();
			loadedSolution.id = resultSet.getInt("id");
			loadedSolution.created = resultSet.getString("created");
			loadedSolution.updated = resultSet.getString("updated");
			loadedSolution.description = resultSet.getString("description");
			loadedSolution.exercise_id = resultSet.getInt("exercise_id");
			loadedSolution.users_id = resultSet.getInt("users_id");
			solutions.add(loadedSolution);
		}
		Solution[] sArray = new Solution[solutions.size()];
		sArray = solutions.toArray(sArray);
		
		if (sArray.length > 0) {
			return true;
		} else {
			return false;
		}
	
	}
	
	
	// zadanie 5.1
	
	
	//wczytywanie wszystkich rozwiązań po ID użytkownika - metoda statyczna więc używamy już na klasie, nie na obiekcie	
	static public Solution[] loadAllMissingSolutionsByUserId(Connection conn, int users_id) throws SQLException {
		ArrayList<Solution> solutions = new ArrayList<Solution>();
		String sql = "SELECT * FROM solution WHERE description IS NULL AND users_id = ?";
		PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setInt(1, users_id);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			Solution loadedSolution = new Solution();
			loadedSolution.id = resultSet.getInt("id");
			loadedSolution.created = resultSet.getString("created");
			loadedSolution.updated = resultSet.getString("updated");
			loadedSolution.description = resultSet.getString("description");
			loadedSolution.exercise_id = resultSet.getInt("exercise_id");
			loadedSolution.users_id = resultSet.getInt("users_id");
			solutions.add(loadedSolution);
		}
		
		Solution[] sArray = new Solution[solutions.size()];
		sArray = solutions.toArray(sArray);
		return sArray;

	}
	
	
	
	//wczytywanie rozwiązania po users_ID i ExerciseId - do tego aby zmiana rozwiązania  przez ucznia modyfikowała zadanie nauczyciela a nie tworzyłą nowe - metoda statyczna więc używamy już na klasie, nie na obiekcie	
	static public Solution loadSolutionByUserIdAndExerciseId(Connection conn, int users_id, int exercise_id) throws SQLException {
		String sql = "SELECT * FROM solution WHERE users_id = ? AND exercise_id = ?";
		PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setInt(1, users_id);
		preparedStatement.setInt(2, exercise_id);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			Solution loadedSolution = new Solution();
			loadedSolution.id = resultSet.getInt("id");
			loadedSolution.created = resultSet.getString("created");
			loadedSolution.updated = resultSet.getString("updated");
			loadedSolution.description = resultSet.getString("description");
			loadedSolution.exercise_id = resultSet.getInt("exercise_id");
			loadedSolution.users_id = resultSet.getInt("users_id");
			return loadedSolution;
		}
		return null;
	}
	
	
	
	


}
