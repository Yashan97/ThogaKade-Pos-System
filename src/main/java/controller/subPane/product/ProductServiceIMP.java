package controller.subPane.product;

import model.Item;

import java.util.List;

public class ProductServiceIMP implements ProductService{
    @Override
    public boolean addItem(Item item) {
        return false;
    }

    @Override
    public boolean updateItem(Item item) {
        return false;
    }

    @Override
    public boolean deleteItem(String id) {
        return false;
    }

    @Override
    public Item searchItem(String id) {
        return null;
    }

    @Override
    public List<Item> getAll() {
        return List.of();
    }
}
