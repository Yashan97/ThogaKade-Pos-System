package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeFormController implements Initializable {

      @FXML
    private AnchorPane ancMain;

    public void btnProduct(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(
                    getClass().getResource("/view/subPanes/productForm.fxml")
            );


            AnchorPane.setTopAnchor(pane, 0.0);
            AnchorPane.setBottomAnchor(pane, 0.0);
            AnchorPane.setLeftAnchor(pane, 0.0);
            AnchorPane.setRightAnchor(pane, 0.0);

            ancMain.getChildren().setAll(pane);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnSale(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(
                    getClass().getResource("/view/subPanes/saleForm.fxml")
            );


            AnchorPane.setTopAnchor(pane, 0.0);
            AnchorPane.setBottomAnchor(pane, 0.0);
            AnchorPane.setLeftAnchor(pane, 0.0);
            AnchorPane.setRightAnchor(pane, 0.0);

            ancMain.getChildren().setAll(pane);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnCustomer(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/subPanes/customerForm.fxml"));
            AnchorPane.setBottomAnchor(pane,0.0);
            AnchorPane.setLeftAnchor(pane,0.0);
            AnchorPane.setRightAnchor(pane,0.0);
            AnchorPane.setTopAnchor(pane, 0.0);


            ancMain.getChildren().setAll(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
