import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class DonateController {
    @FXML
    TextField nameTxtField;
    @FXML
    TextField bgTxtField;
    @FXML
    TextField addressTxtField;
    @FXML
    TextField phoneTxtField;
    String q = "'";
    String c = ",";
    @FXML
    public void onSubmitBtn() throws SQLException {
            if(nameTxtField.getText().equals("")||bgTxtField.getText().equals("")||phoneTxtField.getText().equals("")||addressTxtField.getText().equals(""))
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Please fill all the fields");
                alert.show();
            }
            else {
                Connection con = ConnectToDatabase.getConnection();
                Statement st = con.createStatement();
                String query = "INSERT INTO donorReg(name,bg,address,phone) VALUES ("+q+nameTxtField.getText()+q+c+q+bgTxtField.getText()+q+c+q+addressTxtField.getText()+q+c+q+phoneTxtField.getText()+q+")";
                st.execute(query);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Thank you. We will get back to you.");
                alert.show();
            }
    }
    @FXML
    void onBackBtn() throws IOException {
        Driver.setScene("home.fxml");
    }
}
