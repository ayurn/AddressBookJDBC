import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AddressBookConnection {
    public static final String URL = "jdbc:mysql://localhost:3306/address_bookJDBC?useSSL=false";
    public static final String USER = "root";
    public static final String PASSWORD = "ayur111";
    private static Connection connection;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}