package controller.subPane.customer;


import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.Customer;
import utill.CRUDUtill;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

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
            ResultSet resultSet = CRUDUtill.executeQuery("SELECT * FROM Customer WHERE cusID LIKE ? OR cusName LIKE ? OR contactNumber1 LIKE ?",
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

    public void btnAddCustomer(ActionEvent event) throws SQLException {
        String name = txtCustomerName.getText();
        int num1 = Integer.parseInt(txtContactNumber1.getText());
        int num2 = Integer.parseInt(txtContactNumber2.getText());
        String city = txtCity.getText();
        String address = txtAddress.getText();
        double blance = Double.parseDouble(txtBlance.getText());
        LocalDate date = txtDate.getValue();

        Customer customer = new Customer(name,num1,num2,city,address,blance,date);
        if (new CustomerServiceImpl().addCustomer(customer)){
            new Alert(Alert.AlertType.INFORMATION,"Customer Added Success").show();

        }else {
            new Alert(Alert.AlertType.ERROR,"Customer Not Added! ").show();
        }
    }

    public void btnUpdate(ActionEvent event) {
        try {
            String name = txtCustomerName.getText();
            int num1 = Integer.parseInt(txtContactNumber1.getText());
            int num2 = Integer.parseInt(txtContactNumber2.getText());
            String city = txtCity.getText();
            String address = txtAddress.getText();
            String blance = txtBlance.getText();
            LocalDate date = txtDate.getValue();
            String id = txtCusId.getText();
            int i = CRUDUtill.executeUpdate("UPDATE Customer SET cusName = ? ,contactNumber1 = ? , contactNumber2 = ? , city = ? , address = ? , outStanding = ? , registerDate = ? WHERE cusID = ?",
                    name, num1, num2, city, address, blance, date , id);
            if(i>0){
                new Alert(Alert.AlertType.CONFIRMATION,"Update Success").show();
            }else {
                new Alert(Alert.AlertType.ERROR,"Not Update").show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnDelete(ActionEvent event) {
        String id = txtCusId.getText();
        int i = 0;
        try {
            i = CRUDUtill.executeUpdate("DELETE FROM Customer WHERE cusID = ?", id);
            if (i>0){
                new Alert(Alert.AlertType.CONFIRMATION,"Customer Deleted!").show();
            }else {
                new Alert(Alert.AlertType.ERROR,"Not Deleted!").show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
