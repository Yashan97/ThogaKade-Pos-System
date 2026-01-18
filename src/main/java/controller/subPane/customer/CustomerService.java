package controller.subPane.customer;

import model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerService {
    boolean addCustomer(Customer customer) throws SQLException;
    boolean updateCustomer(Customer customer) throws SQLException;
    boolean deleteCustomer(String id);
    Customer searchCustomerById(String id);
    List<Customer> getAll();
}
