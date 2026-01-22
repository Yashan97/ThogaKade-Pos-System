package controller.subPane.product;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProductFormController implements Initializable {

    public AnchorPane ancProduct;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/subPanes/product/allProductForm.fxml"));
            AnchorPane.setTopAnchor(pane, 0.0);
            AnchorPane.setBottomAnchor(pane, 0.0);
            AnchorPane.setLeftAnchor(pane, 0.0);
            AnchorPane.setRightAnchor(pane, 0.0);
            ancProduct.getChildren().clear();
            ancProduct.getChildren().add(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnAllProduct(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/subPanes/product/allProductForm.fxml"));
            AnchorPane.setTopAnchor(pane, 0.0);
            AnchorPane.setBottomAnchor(pane, 0.0);
            AnchorPane.setLeftAnchor(pane, 0.0);
            AnchorPane.setRightAnchor(pane, 0.0);
            ancProduct.getChildren().clear();
            ancProduct.getChildren().add(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnAddProduct(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/subPanes/product/addProductForm.fxml"));
            AnchorPane.setTopAnchor(pane, 0.0);
            AnchorPane.setBottomAnchor(pane, 0.0);
            AnchorPane.setLeftAnchor(pane, 0.0);
            AnchorPane.setRightAnchor(pane, 0.0);
            ancProduct.getChildren().clear();
            ancProduct.getChildren().add(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnAddCategory(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/subPanes/product/addCategory.fxml"));
            AnchorPane.setTopAnchor(pane, 0.0);
            AnchorPane.setBottomAnchor(pane, 0.0);
            AnchorPane.setLeftAnchor(pane, 0.0);
            AnchorPane.setRightAnchor(pane, 0.0);
            ancProduct.getChildren().clear();
            ancProduct.getChildren().add(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnMostSellingProduct(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/subPanes/product/mostSellingProduct.fxml"));
            AnchorPane.setTopAnchor(pane, 0.0);
            AnchorPane.setBottomAnchor(pane, 0.0);
            AnchorPane.setLeftAnchor(pane, 0.0);
            AnchorPane.setRightAnchor(pane, 0.0);
            ancProduct.getChildren().clear();
            ancProduct.getChildren().add(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnProductReport(ActionEvent event) {
    }
}
