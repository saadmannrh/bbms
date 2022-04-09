import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class EditStockController {
    @FXML
    TextField bgTxtField;
    @FXML
    TextField quantityTxtField;
    @FXML
    void onAddBtn() throws SQLException {
        String query = "SELECT quantity FROM stocks WHERE bg='"+bgTxtField.getText()+"'";
        Connection con = ConnectToDatabase.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        if(!rs.next())
        {
            query = "INSERT INTO stocks(bg,quantity) VALUES ('"+bgTxtField.getText()+"',"+quantityTxtField.getText()+")";
            st.execute(query);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Added");
            alert.show();

        }
        else {
            Integer quantity = rs.getInt(1)+Integer.parseInt(quantityTxtField.getText());
            query = "UPDATE stocks SET quantity="+quantity.toString()+" WHERE bg='"+bgTxtField.getText()+"'";
            st.execute(query);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Added");
            alert.show();

        }

    }
    @FXML
    void onRemoveBtn() throws SQLException {
        String query = "SELECT quantity FROM stocks WHERE bg='"+bgTxtField.getText()+"'";
        Connection con = ConnectToDatabase.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        if(!rs.next())
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Already empty");
            alert.show();
        }
        else {
            int quantity = rs.getInt(1)-Integer.parseInt(quantityTxtField.getText());
            if(quantity<0)
            {
                Alert al = new Alert(Alert.AlertType.WARNING);
                        al.setContentText("Not enough stock");
                        al.show();
                        return;
            }
            query = "UPDATE stocks SET quantity="+quantity+""+" WHERE bg='"+bgTxtField.getText()+"'";
            st.execute(query);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Removed");
            alert.show();

        }
    }
    @FXML
    void onBackBtn() throws IOException {
        Driver.setScene("loggedIn.fxml");
    }
}
