package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductRepositoryTest {
    @InjectMocks
    ProductRepository productRepository;
    @BeforeEach
    void setUp() {

    }
    @Test
    void testCreateAndFindProduct() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.createProduct(product);

        Iterator<Product> productIterator = productRepository.findAllProducts();
        assertTrue(productIterator.hasNext());
        Product foundProduct = productIterator.next();
        assertEquals(product.getProductId(), foundProduct.getProductId());
        assertEquals(product.getProductName(), foundProduct.getProductName());
        assertEquals(product.getProductQuantity(), foundProduct.getProductQuantity());
        assertNotNull(productRepository.findProductById(foundProduct.getProductId()));
    }

    @Test
    void testFindAllIfEmpty() {
        Iterator<Product> productIterator = productRepository.findAllProducts();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testFindAllIfMoreThanOneProduct() {
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.createProduct(product1);

        Product product2 = new Product();
        product2.setProductId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productRepository.createProduct(product2);

        Iterator<Product> productIterator = productRepository.findAllProducts();
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
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.createProduct(product1);

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
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.createProduct(product1);

        productRepository.deleteProduct(product1.getProductId());
        Iterator<Product> productIterator = productRepository.findAllProducts();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testCreateEditDeleteProduct() {
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.createProduct(product1);

        Product product2 = new Product();
        product2.setProductId(product1.getProductId());
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productRepository.editProduct(product2.getProductId(), product2);

        Iterator<Product> productIterator = productRepository.findAllProducts();
        Product foundProduct = productIterator.next();
        assertNotNull(foundProduct);
        assertFalse(productIterator.hasNext());

        productRepository.deleteProduct(product2.getProductId());
        productIterator = productRepository.findAllProducts();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testFindProductById() {
        Product product1 = new Product();
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.createProduct(product1);
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");

        Product product2 = new Product();
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productRepository.createProduct(product2);
        product2.setProductId("a0f9de46-90b1-437d-a0bf-d0821dde9096");

        Product foundProduct = productRepository.findProductById("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        assertNotNull(foundProduct);
        assertEquals(product2.getProductId(), foundProduct.getProductId());
        assertEquals(product2.getProductName(), foundProduct.getProductName());
        assertEquals(product2.getProductQuantity(), foundProduct.getProductQuantity());
    }

    @Test
    void testFindProductByIdIfNull() {
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);

        Product foundProduct = productRepository.findProductById(product1.getProductId());
        assertNull(foundProduct);
    }

}
