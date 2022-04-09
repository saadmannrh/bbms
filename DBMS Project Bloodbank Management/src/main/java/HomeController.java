import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class HomeController {
    @FXML
    Button adminLogInBtn;
    @FXML
    Button donateBtn;
    @FXML
    Button searchbtn;
    @FXML
    Button lookfordonorBtn;

    @FXML
    void onSearchBtn() throws IOException {
        Driver.setScene("Search.fxml");
    }
    @FXML
    void onDonateBtn() throws IOException {
        Driver.setScene("Donate.fxml");
    }
    @FXML
    void onAdminLogInBtn() throws IOException {
        Driver.setScene("adminLoginScene.fxml");
    }
    @FXML
    void onStockBtn() throws IOException {
        Driver.setScene("bloodstock.fxml");
    }
}
