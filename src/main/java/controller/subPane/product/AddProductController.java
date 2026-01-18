package controller.subPane.product;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import utill.CRUDUtill;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddProductController {
    public TextField txtSearchProduct;
    public TextField txtItemCode;
    public TextField txtDescription;
    public TextField txtPackSize;
    public TextField txtQTY;
    public TextField txtUnitPrice;

    public void btnSearch(ActionEvent event) {
        try {
            String keyWord = "%"+txtSearchProduct.getText()+"%";
            ResultSet resultSet = CRUDUtill.executeQuery("SELECT * FROM item WHERE ItemCode LIKE ? OR Description LIKE ?",keyWord,keyWord);
            if (resultSet.next()){
                txtDescription.setText(resultSet.getString("Description"));
                txtItemCode.setText(resultSet.getString("ItemCode"));
                txtPackSize.setText(resultSet.getString("PackSize"));
                txtUnitPrice.setText(String.valueOf(resultSet.getDouble("UnitPrice")));
                txtQTY.setText(String.valueOf(resultSet.getInt("QtyOnHand")));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnAddItem(ActionEvent event) {
    }

    public void btnDeleteItem(ActionEvent event) {
    }

    public void btnUpdateItem(ActionEvent event) {
    }
}
