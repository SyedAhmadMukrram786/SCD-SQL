import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Main {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/practice";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Successfully connected to database!");

            statement = connection.createStatement();

            String query = "SELECT * FROM users";
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                System.out.println("ID: " + id + ", Name: " + name);
            }

            resultSet.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(connection != null){
                    connection.close();
                }
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}