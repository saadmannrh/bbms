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

public class StockController implements Initializable {
    @FXML
    TableView table;
    @FXML
    TableColumn bgCol;
    @FXML
    TableColumn quantityCol;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableStuff();
        Connection con = null;
        try {
            con = ConnectToDatabase.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            Statement st = con.createStatement();
            String query = "SELECT * FROM stocks";
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                String bg = rs.getString(1);
                int quantity = rs.getInt(2);
                Stocks stocks = new Stocks(bg,quantity);
                table.getItems().add(stocks);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void tableStuff()
    {
        bgCol.setCellValueFactory(new PropertyValueFactory<>("bg"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));

    }
    @FXML
    void onBackBtn() throws IOException {
        Driver.setScene("home.fxml");
    }
}
