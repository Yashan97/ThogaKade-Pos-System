package controller.subPane.customer;

import model.Customer;
import utill.CRUDUtill;

import java.sql.SQLException;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    @Override
    public boolean addCustomer(Customer customer) throws SQLException {
        int i = CRUDUtill.executeUpdate("INSERT INTO Customer (cusName,contactNumber1, contactNumber2 , city ,address,outStanding,registerDate) VALUES (?,?,?,?,?,?,?)",
                    customer.getCusName(), customer.getContactNumber1(), customer.getContactNumber2(), customer.getCity(), customer.getAddress(), customer.getOutStanding(),customer.getRegisterDate());
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
    public Customer searchCustomerById(String id) {
        return null;
    }

    @Override
    public List<Customer> getAll() {
        return List.of();
    }
}
