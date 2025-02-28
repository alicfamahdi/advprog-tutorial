package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Setter
@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product) {
        productRepository.create(product);
        return product;
    }

    @Override
    public List<Product> findAllProducts() {
        Iterator<Product> productIterator = productRepository.findAll();
        List<Product> allProducts = new ArrayList<>();
        productIterator.forEachRemaining(allProducts::add);
        return allProducts;
    }

    @Override
    public void editProduct(String id, Product product) {
        productRepository.editProduct(id, product);
    }

    @Override
    public Product findProductById(String id) {
        return productRepository.findById(id);
    }

    @Override
    public void deleteProduct(String productId) {
        productRepository.delete(productId);
    }
}
