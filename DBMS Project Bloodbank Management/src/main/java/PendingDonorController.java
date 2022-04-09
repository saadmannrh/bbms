import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class PendingDonorController implements Initializable {
    @FXML
    TableView table;
    @FXML
    TableColumn nameCol;
    @FXML
    TableColumn bgCol;
    @FXML
    TableColumn addressCol;
    @FXML
    TableColumn phoneCol;

    @FXML
    void onBackBtn() throws IOException {
        Driver.setScene("loggedIn.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableStuff();
        try {
            Connection con =  ConnectToDatabase.getConnection();
            Statement st = con.createStatement();
            String query = "SELECT * FROM donorReg";
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                String name = rs.getString(2);
                String bg = rs.getString(3);
                String address = rs.getString(4);
                String phone = rs.getString(5);
                PendingDonors pd = new PendingDonors(name,bg,address,phone);
                table.getItems().add(pd);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    void tableStuff()
    {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        bgCol.setCellValueFactory(new PropertyValueFactory<>("bg"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
    }
}
