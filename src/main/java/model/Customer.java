package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private int cusId;
    private String cusName;
    private int contactNumber1;
    private int contactNumber2;
    private String city;
    private String address;
    private Double outStanding;
    private int registerDate;
    private String customerImg;

    public Customer(int cusId, String cusName, int contactNumber1, int contactNumber2, String city, String address, double outStanding) {
        this.cusId = cusId;
        this.cusName = cusName;
        this.contactNumber1 = contactNumber1;
        this.contactNumber2 = contactNumber2;
        this.city =city;
        this.address = address;
        this.outStanding = outStanding;
    }
}
