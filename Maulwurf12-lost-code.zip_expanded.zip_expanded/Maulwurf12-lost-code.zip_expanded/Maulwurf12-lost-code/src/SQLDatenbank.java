import java.sql.*;

public class SQLDatenbank { 
    public static void main (String[] args) {
    	//todo 2 main methods
        String url= "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "";
        Connection connection = null;
        Statement statement = null;
        ResultSet result = null;

        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS datenbankprojekt;");
            statement.executeUpdate("USE datenbankprojekt;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS highscoreliste (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255), score INT);");
            result = statement.executeQuery("SELECT * FROM highscoreliste;");
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                int score = result.getInt("score");
                System.out.println("ID: " + id + ", Name: " + name + ", Score: " + score);
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState:" + ex.getSQLState());
            System.out.println("VendorError:" + ex.getErrorCode());
        } finally {
            if (result != null) {
                try { result.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
            if (statement != null) {
                try { statement.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
            if (connection != null) {
                try { connection.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
        }
    }
}