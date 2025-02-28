package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository extends GeneralProductRepository<Product>{
    private List<Product> productData = new ArrayList<>();

    public Product editProduct(String id, Product newProduct) {
        Product oldProduct = super.findById(id);
        if (oldProduct != null) {
            oldProduct.setProductName(newProduct.getProductName());
            oldProduct.setProductQuantity(newProduct.getProductQuantity());
            return oldProduct;
        }
        return null;
    }
}
