package id.ac.ui.cs.advprog.eshop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@WebMvcTest(controllers = ProductController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ProductService productService;

    @Autowired
    private ObjectMapper objectMapper;

    @Mock
    private Model model;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @Test
    void testCreateProductPage() {
        String viewName = productController.createProductPage(model);
        verify(model).addAttribute(eq("product"), any(Product.class));
        assertEquals("CreateProduct", viewName);
    }

    @Test
    void testCreateProductPost() {
        Product product = new Product();
        String viewName = productController.createProductPost(product, model);
        verify(productService).createProduct(product);
        assertEquals("redirect:list", viewName);
    }

    @Test
    void testProductListPage() {
        List<Product> productList = Arrays.asList(new Product(), new Product());
        when(productService.findAllProducts()).thenReturn(productList);
        String viewName = productController.productListPage(model);
        verify(model).addAttribute("products", productList);
        assertEquals("ListProduct", viewName);
    }

    @Test
    void testEditProductPage() {
        Product product = new Product();
        when(productService.findProductById("1")).thenReturn(product);
        String viewName = productController.editProductPage(model, "1");
        verify(model).addAttribute("product", product);
        assertEquals("EditProduct", viewName);
    }

    @Test
    void testEditProductPost() {
        Product product = new Product();
        String viewName = productController.editProductPost(product, "1");
        verify(productService).editProduct("1", product);
        assertEquals("redirect:/product/list", viewName);
    }

    @Test
    void testDeleteProduct() {
        String viewName = productController.deleteProduct("1");
        verify(productService).deleteProduct("1");
        assertEquals("redirect:/product/list", viewName);
    }
}
