package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();

    public Product createProduct(Product product) {
        productData.add(product);
        return product;
    }

    public Iterator<Product> findAllProducts() {
        return productData.iterator();
    }

    public Product findProductById(String id) {
        for (Product product : productData) {
            if (product.getProductId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    public void editProduct(String id, Product newProduct) {
        Product oldProduct = findProductById(id);
        oldProduct.setProductName(newProduct.getProductName());
        oldProduct.setProductQuantity(newProduct.getProductQuantity());
    }

    public void deleteProduct(String id) {
        productData.remove(findProductById(id));
    }
}
