package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {
    @InjectMocks
    ProductServiceImpl productService;
    @BeforeEach
    void setUp() {
        productService.setProductRepository(new ProductRepository());
    }
    @Test
    void testCreateAndFindProduct() {
        Product product = new Product();
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        Product productByService = productService.create(product);
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");

        assertNotNull(productByService);
        assertEquals("eb558e9f-1c39-460e-8860-71af6af63bd6", productByService.getProductId());
        assertEquals("Sampo Cap Bambang", productByService.getProductName());
        assertEquals(100, productByService.getProductQuantity());
    }

    @Test
    void testFindAllIfEmpty() {
        List<Product> productList = productService.findAll();
        assertTrue(productList.isEmpty());
    }

    @Test
    void testFindAllIfMoreThanOneProduct() {
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productService.create(product1);

        Product product2 = new Product();
        product2.setProductId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productService.create(product2);

        List<Product> productList = productService.findAll();
        assertFalse(productList.isEmpty());
        Product foundProduct = productList.getFirst();
        assertEquals(product1.getProductId(), foundProduct.getProductId());
        foundProduct = productList.get(1);
        assertEquals(product2.getProductId(), foundProduct.getProductId());
    }

    @Test
    void testCreateAndEditProduct() {
        Product product1 = new Product();
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productService.create(product1);
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");

        Product product2 = new Product();
        product2.setProductId(product1.getProductId());
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);

        productService.edit("eb558e9f-1c39-460e-8860-71af6af63bd6", product2);
        assertEquals("Sampo Cap Usep", product1.getProductName());
        assertEquals(50, product1.getProductQuantity());
    }

    @Test
    void testCreateDeleteProduct() {
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productService.create(product1);

        productService.delete(product1.getProductId());
        List<Product> productList = productService.findAll();
        assertTrue(productList.isEmpty());
    }

    @Test
    void testCreateEditDeleteProduct() {
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productService.create(product1);

        Product product2 = new Product();
        product2.setProductId(product1.getProductId());
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productService.edit(product2.getProductId(), product2);

        List<Product> productList = productService.findAll();
        Product foundProduct = productList.getFirst();
        assertNotNull(foundProduct);

        productService.delete(product2.getProductId());
        productList = productService.findAll();
        assertTrue(productList.isEmpty());
    }

    @Test
    void testFindProductById() {
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);

        Product foundProduct = productService.findById(product1.getProductId());
        assertNull(foundProduct);
    }

}
