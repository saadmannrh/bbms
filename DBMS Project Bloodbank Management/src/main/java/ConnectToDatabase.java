import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectToDatabase {
    public static Connection getConnection() throws SQLException {
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/"+Driver.DATABASE_NAME,Driver.MYSQL_USERNAME,Driver.MYSQL_PASSWORD);
        return con;
    }
    public static void createDB() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
        Connection connection = DriverManager.getConnection(url,Driver.MYSQL_USERNAME,Driver.MYSQL_PASSWORD);
        String sql = "CREATE DATABASE " + Driver.DATABASE_NAME;

        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);

    }
}
