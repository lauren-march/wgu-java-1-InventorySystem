package Model;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Control.MainController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class Inventory {

    private static ObservableList<Part> allParts = FXCollections.observableArrayList();

    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();

    public static void addPart(Part part) {
        allParts.add(part);
    }

    public static void addProduct(Product product) {
        allProducts.add(product);
    }

    public static ObservableList<Part> getAllParts() {
        return allParts;
    }

    public static ObservableList<Product> getAllProducts() {
        return allProducts;
    }


    private static int partId = 1;
    private static int productId = 1000;

    /**
     * This method allows for a unique ID to be attached to each new part added
     *
     * @return
     */
    public static int getPartId() {
        return partId++;
    }

    /**
     * This method allows for a unique ID to be attached to each new product added
     *
     * @return
     */
    public static int getProductId() {
        return productId++;
    }

    //How to get this to reflect the method called in Main Controller
    public static Part lookupPart(int partId) {
        Part part = null;
        for (int i = 0; i < allParts.size(); i++) {
            if (allParts.get(i).getId() == partId) {
                part = allParts.get(i);
                break;
            }
        }
        ;
        return part;
    }

    public static Product lookupProduct(int productId) {
        Product product = null;
        for (int i = 0; i < allProducts.size(); i++) {
            if (allProducts.get(i).getId() == productId) {
                product = allProducts.get(i);
                break;
            }
        }
        ;
        return product;
    }
}



