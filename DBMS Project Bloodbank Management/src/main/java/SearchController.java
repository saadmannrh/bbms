import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SearchController {
    @FXML
    TextField searchArea;
    @FXML
    Label result;
    @FXML
    void onSearchBtn() throws SQLException {
        String query="SELECT quantity from stocks where bg='"+searchArea.getText()+"'";
        Connection con = ConnectToDatabase.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        if(!rs.next())
        {
            result.setText("No match found");
            result.setVisible(true);
        }
        else{
            result.setText(rs.getString(1)+ " bags available");
            result.setVisible(true);
        }


    }
    @FXML
    void onBackBtn() throws IOException {
        Driver.setScene("home.fxml");
    }
}
