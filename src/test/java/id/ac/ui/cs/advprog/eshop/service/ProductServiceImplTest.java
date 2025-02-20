package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import id.ac.ui.cs.advprog.eshop.service.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {
    @InjectMocks
    ProductServiceImpl productService;
    @BeforeEach
    void setUp() {
        productService.productRepository = new ProductRepository();
    }
    @Test
    void testCreateAndFindProduct() {
        Product product = new Product();
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        Product productByService = productService.createProduct(product);
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");

        assertNotNull(productByService);
        assertEquals("eb558e9f-1c39-460e-8860-71af6af63bd6", productByService.getProductId());
        assertEquals("Sampo Cap Bambang", productByService.getProductName());
        assertEquals(100, productByService.getProductQuantity());
    }

    @Test
    void testFindAllIfEmpty() {
        List<Product> productList = productService.findAllProducts();
        assertTrue(productList.isEmpty());
    }

    @Test
    void testFindAllIfMoreThanOneProduct() {
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productService.createProduct(product1);

        Product product2 = new Product();
        product2.setProductId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productService.createProduct(product2);

        List<Product> productList = productService.findAllProducts();
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
        productService.createProduct(product1);
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");

        Product product2 = new Product();
        product2.setProductId(product1.getProductId());
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);

        productService.editProduct("eb558e9f-1c39-460e-8860-71af6af63bd6", product2);
        assertEquals("Sampo Cap Usep", product1.getProductName());
        assertEquals(50, product1.getProductQuantity());
    }

    @Test
    void testCreateDeleteProduct() {
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productService.createProduct(product1);

        productService.deleteProduct(product1.getProductId());
        List<Product> productList = productService.findAllProducts();
        assertTrue(productList.isEmpty());
    }

    @Test
    void testCreateEditDeleteProduct() {
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productService.createProduct(product1);

        Product product2 = new Product();
        product2.setProductId(product1.getProductId());
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productService.editProduct(product2.getProductId(), product2);

        List<Product> productList = productService.findAllProducts();
        Product foundProduct = productList.getFirst();
        assertNotNull(foundProduct);

        productService.deleteProduct(product2.getProductId());
        productList = productService.findAllProducts();
        assertTrue(productList.isEmpty());
    }

    @Test
    void testFindProductById() {
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);

        Product foundProduct = productService.findProductById(product1.getProductId());
        assertNull(foundProduct);
    }
}
