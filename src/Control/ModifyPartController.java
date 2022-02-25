package Control;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ModifyPartController implements Initializable {

    public AnchorPane modifyPartScreen;
    public RadioButton outsourcedModifyRadio;
    public Text machineIDDefault;
    public TextField machineIdTextField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void cancelModifyPart(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/Main.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 900, 400);
        stage.setScene(scene);
        stage.show();

    }
    public void modifyInHouseRadio(ActionEvent actionEvent) {

        machineIDDefault.setText("Machine ID");

    }

    public void modifyOutsourcedRadio(ActionEvent actionEvent) {

        machineIDDefault.setText("Company Name");

    }


}