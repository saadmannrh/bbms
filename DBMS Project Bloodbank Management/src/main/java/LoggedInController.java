import javafx.fxml.FXML;

import java.io.IOException;

public class LoggedInController {
    @FXML
    void oneditBtn() throws IOException {
        Driver.setScene("EditStock.fxml");
    }

    @FXML
    void onplistBtn() {

    }

    @FXML
    void onDlistBtn() {

    }
    @FXML
    void onPendingDonorBtn() throws IOException {
        Driver.setScene("pendingDonors.fxml");
    }

    @FXML
    void onBackBtn() throws IOException {
        Driver.setScene("home.fxml");
    }



}
