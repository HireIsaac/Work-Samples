package vehicle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;


public class Database {

	Connection conn;
	
	public Database(String db_file_name_prefix) throws Exception {
		try {
      
        	Class.forName("org.sqlite.JDBC");
        } catch (Exception e) {
            System.out.println("ERROR: failed to load SQLite JDBC driver.");
            e.printStackTrace();
            return;
        }
        conn = DriverManager.getConnection("jdbc:sqlite:" + db_file_name_prefix, "sa", "");   //sqlite
	}
	
	public synchronized ResultSet query(String expression) throws SQLException {
		Statement statement = null;
		ResultSet results = null;
		
		statement = conn.createStatement();
		
		results = statement.executeQuery(expression);
		
		return results;
	}
	
	public synchronized void update(String expression) throws SQLException {
		Statement statement = null;
		
		statement = conn.createStatement();
		
		try {
			int i = statement.executeUpdate(expression);
			System.out.println("executeUpdate: " + i);
		} catch (SQLException n) {

			System.out.println("db error: " + expression);
		}
		
		
		statement.close();
	}
	
	public void shutdown() throws SQLException {
		Statement statement = conn.createStatement();
		
		statement.execute("SHUTDOWN");
		conn.close();
	}
}
