package controller.subPane.customer;


import Service.BoFactory;
import Service.custom.CustomerService;
import Service.custom.impl.CustomerServiceImpl;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.Customer;
import utill.CRUDUtill;
import utill.ServiceType;

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

    CustomerService customerService= BoFactory.getInstance().getServiceType(ServiceType.CUSTOMER);

    public void btnSearchCustomer(ActionEvent event) {
        try {
            String keyword ="%"+txtSearchCustomer.getText()+"%";
            Customer customer = customerService.searchCustomerById(keyword);
            if (customer == null){
                new Alert(Alert.AlertType.ERROR,"Cant Find This Customer ").show();
            }else {
                txtCusId.setText(String.valueOf(customer.getCusId()));
                txtCustomerName.setText(customer.getCusName());
                txtContactNumber1.setText(String.valueOf(customer.getContactNumber1()));
                txtContactNumber2.setText(String.valueOf(customer.getContactNumber2()));
                txtCity.setText(customer.getCity());
                txtAddress.setText(customer.getAddress());
                txtBlance.setText(String.valueOf(customer.getOutStanding()));
                txtDate.getEditor().setText(String.valueOf(customer.getRegisterDate()));

                txtSummeryName.setText(customer.getSName());
                txtSummryID.setText(String.valueOf(customer.getSId()));
                txtSummryNumber.setText(String.valueOf(customer.getSNumber()));
                txtSummeryBlance.setText(String.valueOf(customer.getSBlance()));
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
        Customer customer1 = customerService.searchCustomerById(String.valueOf(num1));
        if (customer1 == null){
            if (new CustomerServiceImpl().addCustomer(customer)){
                new Alert(Alert.AlertType.INFORMATION,"Customer Added Success").show();

            }else {
                new Alert(Alert.AlertType.ERROR,"Customer Not Added! ").show();
                clearTextFieald();
            }
        }else {
            new Alert(Alert.AlertType.ERROR,"This Customer Already added").show();
            clearTextFieald();
        }

    }

    public void btnUpdate(ActionEvent event) {
        try {
            String name = txtCustomerName.getText();
            int num1 = Integer.parseInt(txtContactNumber1.getText());
            int num2 = Integer.parseInt(txtContactNumber2.getText());
            String city = txtCity.getText();
            String address = txtAddress.getText();
            double blance = Double.parseDouble(txtBlance.getText());
            LocalDate date = txtDate.getValue();
            int id = Integer.parseInt(txtCusId.getText());
            Customer customer = new Customer(name, num1, num2, city, address, blance, date , id);

            if(customerService.updateCustomer(customer)){
                new Alert(Alert.AlertType.CONFIRMATION,"Update Success").show();
            }else {
                new Alert(Alert.AlertType.ERROR,"Not Update").show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnDelete(ActionEvent event) throws SQLException {
        String id = txtCusId.getText();
        if (customerService.deleteCustomer(id)){
            new Alert(Alert.AlertType.INFORMATION,id+" Customer Deleted!").show();
            clearTextFieald();

        }else {
            new Alert(Alert.AlertType.ERROR,id+" Customer Not Deleted!").show();
            clearTextFieald();
        }

    }

    public void clearTextFieald(){
        txtCusId.clear();
        txtCustomerName.clear();
        txtContactNumber1.clear();
        txtContactNumber2.clear();
        txtCity.clear();
        txtAddress.clear();
        txtBlance.clear();
        txtDate.getEditor().clear();

        txtSummryID.clear();
        txtSummeryName.clear();
        txtSearchCustomer.clear();
        txtSummeryBlance.clear();
        txtSummeryLastVisit.clear();
        txtSummryNumber.clear();
    }
}






