import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

;import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LogInController {
    @FXML
    Button logInBtn;
    @FXML
    PasswordField pwField;
    @FXML
     Button signUpBtn;
    @FXML
     Button menuBtn;
    @FXML
   TextField userNameTxtField;

    @FXML
    void onLogIn() throws SQLException, IOException {
        Connection con = ConnectToDatabase.getConnection();
        Statement st = con.createStatement();
        String query = "SELECT * FROM signUpInfo WHERE username='"+userNameTxtField.getText()+"' AND pw='"+pwField.getText()+"'";
        ResultSet rs = st.executeQuery(query);
        if(userNameTxtField.getText().equals("")||pwField.equals(""))
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Please fill the blank fields");
            alert.show();
        }
        else if(rs.next())
        {
            Driver.setScene("loggedIn.fxml");
        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Wrong username/password");
            alert.show();
        }
    }
    @FXML
    public void onSignUp() throws IOException {
        Driver.setScene("signUpScene.fxml");
    }
    @FXML
    public void onMenuBtn() throws IOException {
        Driver.setScene("home.fxml");
    }
}
