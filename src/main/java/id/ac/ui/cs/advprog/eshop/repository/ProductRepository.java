package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();

    public Product createProduct(Product product) {
        if (product.getProductId() == null) {
            UUID uuid = UUID.randomUUID();
            product.setProductId(uuid.toString());
        }
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

    public Product editProduct(String id, Product newProduct) {
        Product oldProduct = findProductById(id);
        if (oldProduct != null) {
            oldProduct.setProductName(newProduct.getProductName());
            oldProduct.setProductQuantity(newProduct.getProductQuantity());
            return oldProduct;
        }
        return null;
    }

    public void deleteProduct(String id) {
        productData.remove(findProductById(id));
    }
}
