package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Repository
abstract public class GeneralProductRepository<T extends Product> {
    private List<T> productData = new ArrayList<>();

    public T create(T product) {
        if (product.getProductId() == null) {
            UUID uuid = UUID.randomUUID();
            product.setProductId(uuid.toString());
        }
        productData.add(product);
        return product;
    }

    public Iterator<T> findAll() {
        return productData.iterator();
    }

    public T findById(String id) {
        for (T product : productData) {
            if (product.getProductId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    public void delete(String id) {
        productData.remove(findById(id));
    }
}
