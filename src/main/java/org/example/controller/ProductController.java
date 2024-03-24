package org.example.controller;

import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.example.dto.ProductDto;
import org.example.mapper.ProductMapper;
import org.example.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.example.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    @Autowired
    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @GetMapping("/view-section")
    public String viewSection(Model model) {
        model.addAttribute("products", this.productService.getAll());
        model.addAttribute("product", new ProductDto());
        return TemplatesNames.PRODUCT_VIEW_SECTION;
    }

//    @GetMapping("/search")
//    public String search(@RequestParam(name = "query", required = false) String query, Model model) {
    // Perform search operation with the query parameter
    // Example: You can pass the query to a service method to retrieve search results

    // For demonstration, let's assume we are just returning the query string
//        model.addAttribute("query", query);
//        return "search-results";
//    }

    @PostMapping
    public ProductDto saveProduct(@RequestBody ProductDto productDto) {
        return productService.saveProduct(productDto);
    }

    @GetMapping
    @RequestMapping("/open-add-page")
    public String openAddPage(Model model) {
        model.addAttribute("newProduct", new ProductDto());
        return TemplatesNames.ADD_PAGE;
    }

    @PostMapping("/add-product")
    public String addProduct(Model model, @Valid @ModelAttribute ProductDto productDto) {
        model.addAttribute("newProduct", new ProductDto());
        productService.saveProduct(productDto);
        return "redirect:/products/view-section";
    }

    @GetMapping("/{id}")
    public ProductDto getProduct(@PathVariable Integer id) {
        return productService.getProduct(id);
    }

    @GetMapping
    public List<ProductDto> getAll() {
        return productService.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        productService.delete(id);
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        productService.updateProduct(id, product);
    }
}
