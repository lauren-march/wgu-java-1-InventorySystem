package Control;

import Model.InHouse;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class AddPartController implements Initializable {

    public RadioButton outsourcedRadio;
    public RadioButton inHouseAddPart;
    public Label machineId;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**
     * This allows the cancel button to switch to the Main.fxml screen
     * @param actionEvent
     * @throws IOException
     */
    public void cancelAddPart(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/Main.fxml"));
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 900, 400);
        stage.setScene(scene);
        stage.show();


    }

    /**
     * This is the InHouse radio button that displays the text field Machine ID
     * @param actionEvent
     */
    public void inHouseRadioAdd(ActionEvent actionEvent) {

        machineId.setText("Machine Id");


    }

    /**
     * This is the Outsourced radio button that displays the text field Company Name
     * @param actionEvent
     */
    public void outsourcedRadioAdd(ActionEvent actionEvent) {

        machineId.setText("Company Name");

    }

    @FXML TextField machineIdText;
    public void machineTextField(ActionEvent actionEvent) {

        String m = machineIdText.getText();

    }


}
