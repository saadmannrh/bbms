import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SignUpController {

    @javafx.fxml.FXML
    private TextField EmailTxtField;
    @javafx.fxml.FXML
    private TextField usernameTxtField;
    @javafx.fxml.FXML
    private AnchorPane anchorPane;
    @javafx.fxml.FXML
    private Button signUpBtn;
    @javafx.fxml.FXML
    private PasswordField signUpCodeTxtField;
    @javafx.fxml.FXML
    private ImageView imgView;
    @javafx.fxml.FXML
    private TextField NameTxtField;
    @javafx.fxml.FXML
    private PasswordField pwTxtField;
    @javafx.fxml.FXML
    private TextField bgTxtField;
    @javafx.fxml.FXML
    private Button homeBtn;
    private String q = "'";
    private String comma = ",";

    public void onHomeBtn(ActionEvent actionEvent) throws IOException {
        Driver.setScene("home.fxml");
    }

    public void onSignUpBtn(ActionEvent actionEvent) throws SQLException {
        Connection con = ConnectToDatabase.getConnection();
        Statement st = con.createStatement();
        String username = usernameTxtField.getText();
        String query = "SELECT * FROM signUpInfo where username='"+username+"'";
        ResultSet rs = st.executeQuery(query);
        if(rs.next())
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Username Already exists.");
            alert.show();
        }
        else if(NameTxtField.getText().equals("")||EmailTxtField.getText().equals("")||bgTxtField.getText().equals("")||usernameTxtField.getText().equals("")||pwTxtField.getText().equals("")||signUpCodeTxtField.getText().equals(""))
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Please fill the blank fields");
            alert.show();
        }
        else if(!signUpCodeTxtField.getText().equals(Driver.SIGNUP_CODE))
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Sign Up code doesn't match");
            alert.show();
        }
        else{
            query = "INSERT INTO signUpInfo(name,email,bg,username,pw) VALUES ("+q+NameTxtField.getText()+q+comma+q+EmailTxtField.getText()+q+comma+q+bgTxtField.getText()+q+comma+q+usernameTxtField.getText()+q+comma+q+pwTxtField.getText()+q+")";
            st.execute(query);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Account created. Please log in");
            alert.show();
        }
    }
}
