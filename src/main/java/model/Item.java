package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private  String ItemCode;
    private  String Description;
    private String PackSize;
    private Double UnitPrice;
    private int QtyOnHand;
}
