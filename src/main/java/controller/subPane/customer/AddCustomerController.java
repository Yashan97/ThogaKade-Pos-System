package controller.subPane.customer;

import dbConnection.DBConnection;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import utill.CRUDUtill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddCustomerController {
    public TextField txtSearchCustomer;
    public TextField txtCustomerName;
    public TextField txtContactNumber1;
    public TextField txtContactNumber2;
    public TextField txtCity;
    public TextField txtAddress;
    public TextField txtBlance;
    public DatePicker txtDate;
    public TextField txtCusId;
    public TextField txtSummeryName;
    public TextField txtSummryID;
    public TextField txtSummryNumber;
    public TextField txtTotalOrder;
    public TextField txtSummeryBlance;
    public TextField txtSummeryLastVisit;

    public void btnSearchCustomer(ActionEvent event) {
        try {
            String keyword ="%"+txtSearchCustomer.getText()+"%";
            ResultSet resultSet = CRUDUtill.execute("SELECT * FROM Customer WHERE cusID LIKE ? OR cusName LIKE ? OR contactNumber1 LIKE ?",
                    keyword,keyword,keyword);

            if (resultSet.next()){
                txtCustomerName.setText(resultSet.getString("cusName"));
                txtCusId.setText(resultSet.getString("cusID"));
                txtContactNumber1.setText(String.valueOf(resultSet.getInt("contactNumber1")));
                txtContactNumber2.setText(String.valueOf(resultSet.getInt("contactNumber2")));
                txtCity.setText(resultSet.getString("city"));
                txtAddress.setText(resultSet.getString("address"));
                txtBlance.setText(String.valueOf(resultSet.getDouble("outStanding")));
                txtDate.getEditor().setText(resultSet.getString("registerDate"));

                txtSummeryName.setText(resultSet.getString("cusName"));
                txtSummryID.setText(String.valueOf(resultSet.getInt("cusID")));
                txtSummryNumber.setText(String.valueOf(resultSet.getInt("contactNumber1")));
                txtSummeryBlance.setText(String.valueOf(resultSet.getDouble("outStanding")));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
