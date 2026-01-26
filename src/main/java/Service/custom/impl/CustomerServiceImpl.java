package Service.custom.impl;

import Service.custom.CustomerService;
import model.Customer;
import utill.CRUDUtill;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    @Override
    public boolean addCustomer(Customer customer) throws SQLException {
        int i = CRUDUtill.executeUpdate("INSERT INTO Customer (cusName,contactNumber1, contactNumber2 , city ,address,outStanding,registerDate) VALUES (?,?,?,?,?,?,?)",
                customer.getCusName(), customer.getContactNumber1(), customer.getContactNumber2(), customer.getCity(), customer.getAddress(), customer.getOutStanding(), customer.getRegisterDate());
       return i>0;
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        int i = CRUDUtill.executeUpdate("UPDATE Customer SET cusName = ? ,contactNumber1 = ? , contactNumber2 = ? , city = ? , address = ? , outStanding = ? , registerDate = ? WHERE cusID = ?",
                customer.getCusName(),
                customer.getContactNumber1(),
                customer.getContactNumber2(),
                customer.getCity(),
                customer.getAddress(),
                customer.getOutStanding(),
                customer.getRegisterDate(),
                customer.getCusId());
        return i>0;
    }

    @Override
    public boolean deleteCustomer(String id) {
        return false;
    }

    @Override
    public Customer searchCustomerById(String id) throws SQLException {

        ResultSet resultSet = CRUDUtill.executeQuery("SELECT * FROM Customer WHERE cusID LIKE ? OR cusName LIKE ? OR contactNumber1 LIKE ?",
                id, id, id);
        if (resultSet.next()){
            return  new Customer(
            resultSet.getString("cusName"),
            resultSet.getInt("cusID"),
            resultSet.getInt("contactNumber1"),
            resultSet.getInt("contactNumber2"),
            resultSet.getString("city"),
            resultSet.getString("address"),
            resultSet.getDouble("outStanding"),
            resultSet.getString("registerDate"),

            resultSet.getString("cusName"),
            resultSet.getInt("cusID"),
            resultSet.getInt("contactNumber1"),
            resultSet.getDouble("outStanding")
            );
        }
        return null;
    }

    @Override
    public List<Customer> getAll() {
        return List.of();
    }
}
