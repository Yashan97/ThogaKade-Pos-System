package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;

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
    private LocalDate registerDate;
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

    public Customer(String cusName, int contactNumber1, int contactNumber2, String city, String address, double outStanding, LocalDate registerDate) {
        this.cusName = cusName;
        this.contactNumber1 = contactNumber1;
        this.contactNumber2 = contactNumber2;
        this.city = city;
        this.address = address;
        this.outStanding = outStanding;
        this.registerDate = registerDate;

    }

    public Customer(String name, int num1, int num2, String city, String address, double blance, LocalDate date, int id) {
        this.cusName = name;
        this.contactNumber1 = num1;
        this.contactNumber2 = num2;
        this.city = city;
        this.address =address;
        this.outStanding = blance;
        this.registerDate= date;
        this.cusId = id;

    }
}
