package controller.subPane.customer;

import dbConnection.DBConnection;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

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

    public void btnSearchCustomer(ActionEvent event) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement psTm = connection.prepareStatement("SELECT * from Customer WHERE cusName LIKE ?");
            psTm.setString(1,"%"+txtSearchCustomer.getText()+"%");
            ResultSet resultSet = psTm.executeQuery();
            if (resultSet.next()){
                txtCustomerName.setText(resultSet.getString("cusName"));
                txtCusId.setText(resultSet.getString("cusID"));
                txtContactNumber1.setText(String.valueOf(resultSet.getInt("contactNumber1")));
                txtContactNumber2.setText(String.valueOf(resultSet.getInt("contactNumber2")));
                txtCity.setText(resultSet.getString("city"));
                txtAddress.setText(resultSet.getString("address"));
                txtBlance.setText(String.valueOf(resultSet.getDouble("outStanding")));
                txtDate.getEditor().setText(resultSet.getString("registerDate"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
