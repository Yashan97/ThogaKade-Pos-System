package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.layout.AnchorPane;


import java.io.IOException;

public class HomeFormController {

      @FXML
    private AnchorPane ancMain;

    public void btnProduct(ActionEvent event) {

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
            ancMain.getChildren().clear();
            ancMain.getChildren().setAll(pane);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
