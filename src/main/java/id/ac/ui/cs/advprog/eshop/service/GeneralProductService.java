package id.ac.ui.cs.advprog.eshop.service;

import java.util.List;

public interface GeneralProductService<T> {
    public T create(T product);
    public List<T> findAll();
    public void edit(String id, T product);
    public T findById(String id);
    public void delete(String productId);
}
