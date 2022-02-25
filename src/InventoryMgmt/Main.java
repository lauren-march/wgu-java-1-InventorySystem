package InventoryMgmt;

import Model.InHouse;
import Model.Inventory;
import Model.Outsourced;
import Model.Product;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{


        Parent root = FXMLLoader.load(getClass().getResource("/View/Main.fxml"));
        primaryStage.setTitle("");
        primaryStage.setScene(new Scene(root, 900, 400));
        primaryStage.show();
    }

    public static void main(String[] args) {

        Inventory.addPart(new InHouse(Inventory.getPartId(), "Battery", 4.00, 5, 2, 10, 1000));
        Inventory.addPart(new Outsourced(Inventory.getPartId(),"Charge Port",6.00,6,3,15, "Xiang Inc."));
        Inventory.addPart(new InHouse(Inventory.getPartId(),"OLED Screen",10.00,7,4,10,1001));
        Inventory.addProduct(new Product(Inventory.getProductId(),"iPhone 6",199.99,8,2,15));
        Inventory.addProduct(new Product(Inventory.getProductId(),"iPhone X",499.99,3,2,10));

        launch(args);
    }
}
