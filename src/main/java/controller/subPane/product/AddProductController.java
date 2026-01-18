package controller.subPane.product;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
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
        String itemCode = txtItemCode.getText();
        String desCription = txtDescription.getText();
        int qty = Integer.parseInt(txtQTY.getText());
        String packSize = txtPackSize.getText();
        double unitPrice = Double.parseDouble(txtUnitPrice.getText());
        try {
            int i = CRUDUtill.executeUpdate("INSERT INTO item (ItemCode,Description, PackSize , UnitPrice,QtyOnHand) VALUES (?,?,?,?,?)",
                    itemCode, desCription, packSize, unitPrice, qty);
            if (i>0){
                new Alert(Alert.AlertType.CONFIRMATION,"Item Added!").show();

            }else {
                new Alert(Alert.AlertType.ERROR,"Item Not Added").show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnDeleteItem(ActionEvent event) {
        String id = txtItemCode.getText();
        try {
            int i = CRUDUtill.executeUpdate("DELETE FROM item WHERE ItemCode = ?", id);
            if (i>0){
                new Alert(Alert.AlertType.CONFIRMATION,"Item Delete Success !").show();
            }else {
                new Alert(Alert.AlertType.ERROR,"Item Delete Not Success").show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void btnUpdateItem(ActionEvent event) throws SQLException {
        String itemCode = txtItemCode.getText();
        String description = txtDescription.getText();
        String packPize = txtPackSize.getText();
        double price = Double.parseDouble(txtUnitPrice.getText());
        int qty = Integer.parseInt(txtQTY.getText());

        int i = CRUDUtill.executeUpdate("UPDATE item SET Description = ? , PackSize = ? , UnitPrice = ? , QtyOnHand = ?  WHERE ItemCode = ?",
                description, packPize, price, qty, itemCode);
        if (i>0){
            new Alert(Alert.AlertType.INFORMATION,"Update Success!").show();
        }
    }
}
