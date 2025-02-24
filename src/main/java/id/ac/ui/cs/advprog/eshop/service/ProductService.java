package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;

import java.util.List;

public interface ProductService {
    public Product createProduct(Product product);
    public List<Product> findAllProducts();
    public void editProduct(String id, Product product);
    public Product findProductById(String id);
    public void deleteProduct(String productId);
}
