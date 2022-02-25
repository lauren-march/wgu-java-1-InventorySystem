package Control;

import Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class MainController implements Initializable {

    //Part search bar

    @FXML
    private TextField partSearchMain;

    /**
     *
     * @param actionEvent
     */
    public void partSearchMainAction(ActionEvent actionEvent) {
        String q = partSearchMain.getText();

        ObservableList<Part> parts = FXCollections.observableArrayList();
        try {
            Part part = Inventory.lookupPart(Integer.parseInt(q));
            if(part == null){
                throw new NumberFormatException();
            }

            mainPartTable.getSelectionModel().select(part);
        } catch (NumberFormatException e) {
            //parts = Inventory.lookupPart(q);
            mainPartTable.setItems(parts);
        }

    }


    //Product Search Bar

    @FXML
    private TextField productSearchMain;

    /**
     * This method enables the search bar on the Parts side of main screen
     * @param actionEvent
     */
    public void productSearchMainAction(ActionEvent actionEvent) {
        String p = productSearchMain.getText();

        ObservableList<Product> products = searchByProductName(p);

        if(products.size() == 0 ) {
            try {
                int product = Integer.parseInt(p);
                Product productId = getProductId(product);
                if (productId != null)
                    products.add(productId);
            }
            catch (NumberFormatException e) {
                //ignore
            }
        }

        mainProductTable.setItems(products);

    }

    /**
     * This method searches through the data with for loop to find a match or partial match of the product name
     * @param partialName
     * @return
     */
    private ObservableList<Product> searchByProductName(String partialName) {
        ObservableList<Product> productName = FXCollections.observableArrayList();

        ObservableList<Product> allProducts = Inventory.getAllProducts();

        for(Product product : allProducts) {
            if(product.getName().contains(partialName)) {
                productName.add(product);
            }

        }

        return productName;
    }

    /**
     * This method searches through the data to find a match or partial match of the product Id
     * @param productId
     * @return
     */
    private Product getProductId(int productId) {
        ObservableList<Product> allProducts = Inventory.getAllProducts();

        for(Product product : allProducts) {
            if(product.getId() == productId) {
                return product;
            }
        }

        return null;
    }



    @FXML
    private Button deletePartButtonMain;

    public void deletePartAction(ActionEvent actionEvent){


    }


    @FXML
    private Button deleteProductButtonMain;


    // Parts table
    @FXML
    private TableView<Part> mainPartTable;

    @FXML
    private TableColumn<Part, Integer> id;

    @FXML
    private TableColumn<Part, String> name;

    @FXML
    private TableColumn<Part, Integer> stock;

    @FXML
    private TableColumn<Part, Double> price;


    //ProductTable
    @FXML
    private TableView<Product> mainProductTable;

    @FXML
    private TableColumn<Product, Integer> productId;

    @FXML
    private TableColumn<Product, String> productName;

    @FXML
    private TableColumn<Product, Integer> productStock;

    @FXML
    private TableColumn<Product, Double> productPrice;

    /**
     * I DON'T KNOW WHAT THIS DOES!!!!
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        id.setCellValueFactory(new PropertyValueFactory<Part,Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<Part,String>("name"));
        stock.setCellValueFactory(new PropertyValueFactory<Part,Integer>("stock"));
        price.setCellValueFactory(new PropertyValueFactory<Part,Double>("price"));

        mainPartTable.setItems(Inventory.getAllParts());

        productId.setCellValueFactory(new PropertyValueFactory<Product,Integer>("id"));
        productName.setCellValueFactory(new PropertyValueFactory<Product,String>("name"));
        productStock.setCellValueFactory(new PropertyValueFactory<Product,Integer>("stock"));
        productPrice.setCellValueFactory(new PropertyValueFactory<Product,Double>("price"));

        mainProductTable.setItems(Inventory.getAllProducts());

    }

    //Scene changes

    /**
     * This method enables the Add button on the Part side to change to the AddPart scene
     * @param actionEvent
     * @throws IOException
     */
    public void mainAddPart(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/AddPart.fxml"));
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();

   }

    /**
     * This method enables the Modify button on the Part side to switch to the Modify Part scene
     * @param actionEvent
     * @throws IOException
     */
   public void mainModifyPart(ActionEvent actionEvent) throws IOException {
       Parent root = FXMLLoader.load(getClass().getResource("/View/ModifyPart.fxml"));
       Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
       Scene scene = new Scene(root, 600, 400);
       stage.setScene(scene);
       stage.show();
   }

    /**
     * This method enables the Add button on the Product side to switch to the Add Product scene
     * @param actionEvent
     * @throws IOException
     */
    public void mainAddProduct(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/AddProduct.fxml"));
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1000, 600);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This method enables the Modify button on the Product side to switch to the Modify Product scene
     * @param actionEvent
     * @throws IOException
     */
    public void mainModifyProduct(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/ModifyProduct.fxml"));
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1000, 600);
        stage.setScene(scene);
        stage.show();

    }

    //Exit button

    @FXML private javafx.scene.control.Button exitButtonMain;

    /**
     * This method enables the Exit button to close the program
     */
    @FXML
    private void exitButtonAction() {
        Stage stage = (Stage) exitButtonMain.getScene().getWindow();
        stage.close();
    }

}
