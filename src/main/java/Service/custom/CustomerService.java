package Service.custom;

import Service.SuperBo;
import model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerService extends SuperBo {
    boolean addCustomer(Customer customer) throws SQLException;
    boolean updateCustomer(Customer customer) throws SQLException;
    boolean deleteCustomer(String id) throws SQLException;
    Customer searchCustomerById(String id) throws SQLException;
    List<Customer> getAll() throws SQLException;
}
