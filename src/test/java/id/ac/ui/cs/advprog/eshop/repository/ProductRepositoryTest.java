package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ProductRepositoryTest {
    @InjectMocks
    ProductRepository productRepository;

    @Test
    void testCreateAndFindProduct() {
        Product product = new Product();
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product foundProduct = productIterator.next();
        assertEquals(product.getProductId(), foundProduct.getProductId());
        assertEquals(product.getProductName(), foundProduct.getProductName());
        assertEquals(product.getProductQuantity(), foundProduct.getProductQuantity());
        assertNotNull(productRepository.findById(foundProduct.getProductId()));
    }

    @Test
    void testFindAllIfEmpty() {
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testFindAllIfMoreThanOneProduct() {
        Product product1 = new Product();
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");

        Product product2 = new Product();
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productRepository.create(product2);
        product2.setProductId("a0f9de46-90b1-437d-a0bf-d0821dde9096");

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product foundProduct = productIterator.next();
        assertEquals(product1.getProductId(), foundProduct.getProductId());
        foundProduct = productIterator.next();
        assertEquals(product2.getProductId(), foundProduct.getProductId());
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testCreateAndEditProduct() {
        Product product1 = new Product();
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");

        Product product2 = new Product();
        product2.setProductId(product1.getProductId());
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);

        productRepository.editProduct("eb558e9f-1c39-460e-8860-71af6af63bd6", product2);
        assertEquals("Sampo Cap Usep", product1.getProductName());
        assertEquals(50, product1.getProductQuantity());
    }

    @Test
    void testCreateDeleteProduct() {
        Product product1 = new Product();
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");

        productRepository.delete(product1.getProductId());
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testCreateEditDeleteProduct() {
        Product product1 = new Product();
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");

        Product product2 = new Product();
        product2.setProductId(product1.getProductId());
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productRepository.editProduct(product2.getProductId(), product2);

        Iterator<Product> productIterator = productRepository.findAll();
        Product foundProduct = productIterator.next();
        assertNotNull(foundProduct);
        assertFalse(productIterator.hasNext());

        productRepository.delete(product2.getProductId());
        productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testFindProductById() {
        Product product1 = new Product();
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");

        Product product2 = new Product();
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productRepository.create(product2);
        product2.setProductId("a0f9de46-90b1-437d-a0bf-d0821dde9096");

        Product foundProduct = productRepository.findById("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        assertNotNull(foundProduct);
        assertEquals(product2.getProductId(), foundProduct.getProductId());
        assertEquals(product2.getProductName(), foundProduct.getProductName());
        assertEquals(product2.getProductQuantity(), foundProduct.getProductQuantity());
    }

    @Test
    void testFindProductByIdIfNull() {
        Product product1 = new Product();
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");

        Product foundProduct = productRepository.findById(product1.getProductId());
        assertNull(foundProduct);
    }

}
