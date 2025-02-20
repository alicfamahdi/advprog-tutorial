package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/create")
    public String createProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "CreateProduct";
    }

    @PostMapping("/create")
    public String createProductPost(@ModelAttribute Product product, Model model) {
        service.createProduct(product);
        return "redirect:list";
    }

    @GetMapping("/list")
    public String productListPage(Model model) {
        List<Product> allProducts = service.findAllProducts();
        model.addAttribute("products", allProducts);
        return "ListProduct";
    }

    @GetMapping("/edit/{productId}")
    public String editProductPage(Model model, @PathVariable String productId) {
        Product product = service.findProductById(productId);
        model.addAttribute("product", product);
        return "EditProduct";
    }

    @PutMapping("/edit/{productId}")
    public String editProductPost(@ModelAttribute Product product, @PathVariable String productId) {
        service.editProduct(productId, product);
        return "redirect:/product/list";
    }

    @GetMapping("/delete/{productId}")
    public String deleteProduct(@PathVariable String productId) {
        service.deleteProduct(productId);
        return "redirect:/product/list";
    }
}
