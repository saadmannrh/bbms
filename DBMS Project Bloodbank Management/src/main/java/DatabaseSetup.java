import java.sql.*;
import java.util.Locale;

public class DatabaseSetup {
    public static void createTables() throws SQLException {
        //name,email,bg,username,pw
        String query = "CREATE TABLE signUpInfo(id INT NOT NULL AUTO_INCREMENT,name VARCHAR(255),email VARCHAR(255),bg VARCHAR(255),username VARCHAR(255),pw VARCHAR (255))";
        String query2 = "CREATE TABLE stocks(bg VARCHAR(255),quantity INT)";
        //name,bg,address,phone
        String query3 = "CREATE TABLE donorReg(id INT NOT NULL AUTO_INCREMENT,name VARCHAR (255),bg VARCHAR(255),address VARCHAR(255),phone VARCHAR(255)";
        Connection con = ConnectToDatabase.getConnection();
        Statement st = con.createStatement();
        st.execute(query);
        st.execute(query2);
        st.execute(query3);
    }
    public static boolean doesTablesExist(String tableName) throws SQLException {
        DatabaseMetaData databaseMetaData = ConnectToDatabase.getConnection().getMetaData();
        ResultSet rs = databaseMetaData.getTables(null,null,tableName.toUpperCase(Locale.ROOT),null);
        if(rs.next()) return true;
        else return false;
    }
}
