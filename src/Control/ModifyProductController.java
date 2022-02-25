package Control;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class ModifyProductController implements Initializable {

    public AnchorPane modifyProductScreen;
    public TableView modifyProductAddTable;
    public TableView modifyProductRemoveTable;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void cancelModifyProduct(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/Main.fxml"));
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 900, 400);
        stage.setScene(scene);
        stage.show();
    }
}
