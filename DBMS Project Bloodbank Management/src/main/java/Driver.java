import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.Locale;

public class Driver extends Application {
   public static final String MYSQL_USERNAME = "saadman";
    public static final String MYSQL_PASSWORD = "root";
    public static final String DATABASE_NAME = "BloodbankManagementSystem";
    public  static final String SIGNUP_CODE = "bbms";
    public static Stage stg;
    public static void main(String[] args) throws SQLException {
        Connection con = ConnectToDatabase.getConnection();
        if(con==null)
        {
            ConnectToDatabase.createDB();
            con = ConnectToDatabase.getConnection();
        }
        if(!doesTableExist("signUpInfo"))
        {
            DatabaseSetup.createTables();
        }

     launch(args);
}


    @Override
    public void start(Stage primaryStage) throws Exception {
       Parent root = FXMLLoader.load(Driver.class.getResource("home.fxml"));
       primaryStage.setScene(new Scene(root));
       stg = primaryStage;
       stg.show();

    }
    public static void setScene(String fxml) throws IOException {
        Parent root = FXMLLoader.load(Driver.class.getResource(fxml));
        stg.setScene(new Scene(root));
    }
    public static boolean doesTableExist(String tableName) throws SQLException {
        DatabaseMetaData databaseMetaData = ConnectToDatabase.getConnection().getMetaData();
        ResultSet rs = databaseMetaData.getTables(null,null,tableName.toUpperCase(Locale.ROOT),null);
        if(rs.next()) return true;
        else return false;
    }
}
