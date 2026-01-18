package controller.subPane.customer;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CustomerFormcontroller implements Initializable {

    public AnchorPane ancCustomer;

    public void btnAllViewCustomer(ActionEvent event) {

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/subPanes/customer/viewAllCustomer.fxml"));
            AnchorPane.setTopAnchor(pane, 0.0);
            AnchorPane.setBottomAnchor(pane, 0.0);
            AnchorPane.setLeftAnchor(pane, 0.0);
            AnchorPane.setRightAnchor(pane, 0.0);
            ancCustomer.getChildren().setAll(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void btnAddCustoemr(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/subPanes/customer/addCustoemr.fxml"));
            AnchorPane.setTopAnchor(pane, 0.0);
            AnchorPane.setBottomAnchor(pane, 0.0);
            AnchorPane.setLeftAnchor(pane, 0.0);
            AnchorPane.setRightAnchor(pane, 0.0);
            ancCustomer.getChildren().setAll(pane);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnCustomerReport(ActionEvent event) {
    }

    public void btnSaveExcel(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/subPanes/customer/viewAllCustomer.fxml"));
            AnchorPane.setTopAnchor(pane, 0.0);
            AnchorPane.setBottomAnchor(pane, 0.0);
            AnchorPane.setLeftAnchor(pane, 0.0);
            AnchorPane.setRightAnchor(pane, 0.0);
            ancCustomer.getChildren().setAll(pane);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
