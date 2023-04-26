package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Publish;

public class PublishDao {
	private String jdbcURL ="jdbc:postgresql://localhost:5432/book";
	private String jdbcUsername = "postgres";
	private String jdbcPassword = "root";
	private String jdbcDriver = "org.postgresql.Driver";
	
	private static final String INSERT_USERS_SQL = "INSERT INTO publishs" + "  (namepublish, site, add) VALUES "
			+ " (?, ?, ?);";

	private static final String SELECT_USER_BY_ID = "select id,namepublish, site, add from publishs where id =?";
	private static final String SELECT_ALL_PUBLISHS = "select * from publishs";
	private static final String DELETE_USERS_SQL = "delete from publishs where id = ?;";
	private static final String UPDATE_USERS_SQL = "update publishs set namepublish = ?,site= ?, add= ? where id = ?;";
	
	public PublishDao() {
		
	}
	
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	
	
	public void insertUser(Publish publish) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, publish.getNamePublish());
			preparedStatement.setString(2, publish.getSite());
			preparedStatement.setString(3, publish.getAdd());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	
	public Publish selectUser(long id) {
		Publish publish = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setFloat(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String namepublish = rs.getString("namepublish");
				String site = rs.getString("site");
				String add = rs.getString("add");
				
				publish = new Publish(id, namepublish, site, add);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return publish;
	}
	
	public List<Publish> selectAllPublish() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Publish> publish = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection()){

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PUBLISHS); 
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				publish.add(new Publish(
				rs.getLong("id"),
				rs.getString("namepublish"),
				rs.getString("site"),
				rs.getString("add")));
				
				
				
				
			
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return publish;
	}
	
	public boolean deleteUser(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setFloat(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
	
	
	public boolean updateUser(Publish publish) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			System.out.println("updated USer:"+statement);
			statement.setString(1, publish.getNamePublish());
			statement.setString(2, publish.getSite());
			statement.setString(3, publish.getAdd());
			statement.setFloat(4, publish.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	
	
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}
