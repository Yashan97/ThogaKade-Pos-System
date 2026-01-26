package controller.subPane.product;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import utill.CRUDUtill;

import java.sql.SQLException;

public class addCategoryController {

    public TextField txtCategoryName;
    public TextField txtOtherInfo;

    public void btnSearch(ActionEvent event) {
    }

    public void btnSave(ActionEvent event) {
        try {
            CRUDUtill.executeUpdate("INSERT ");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnDelete(ActionEvent event) {
    }

    public void btnUpdate(ActionEvent event) {
    }
}
