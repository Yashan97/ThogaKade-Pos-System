package controller.subPane.product;

import model.Item;

import java.util.List;

public interface ProductService {
    boolean addItem(Item item);
    boolean updateItem(Item item);
    boolean deleteItem(String id);
    Item searchItem(String id);
    List<Item>getAll();
}
