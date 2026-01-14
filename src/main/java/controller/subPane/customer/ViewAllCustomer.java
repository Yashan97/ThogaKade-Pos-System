package controller.subPane.customer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Customer;
import utill.CRUDUtill;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ViewAllCustomer implements Initializable {
    public TableView tblViewAllCustomer;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colCon1;
    public TableColumn colCon2;
    public TableColumn colCity;
    public TableColumn colAddrerss;
    public TableColumn colBlance;

    ArrayList<Customer>customerArray = new ArrayList<>();

    public void loadTable(){
        try {
            ResultSet resultSet = CRUDUtill.executeQuery("SELECT * FROM Customer");
            while (resultSet.next()){
                customerArray.add(new Customer(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getDouble(7)
                ));

                colId.setCellValueFactory(new PropertyValueFactory<>("cusId"));
                colName.setCellValueFactory(new PropertyValueFactory<>("cusName"));
                colCon1.setCellValueFactory(new PropertyValueFactory<>("contactNumber1"));
                colCon2.setCellValueFactory(new PropertyValueFactory<>("contactNumber2"));
                colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
                colAddrerss.setCellValueFactory(new PropertyValueFactory<>("address"));
                colBlance.setCellValueFactory(new PropertyValueFactory<>("outStanding"));

                ObservableList<Customer>observableList  = FXCollections.observableArrayList();
                customerArray.forEach(customer -> {
                    observableList.add(customer);
                });
                tblViewAllCustomer.setItems(observableList);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadTable();
    }
}
