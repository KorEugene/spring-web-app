package ru.geekbrains.webapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.geekbrains.webapp.model.Product;
import ru.geekbrains.webapp.services.ProductsService;

@Controller
public class ProductsController {

    private ProductsService productsService;

    @Autowired
    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    // root = http://localhost:8189/webapp

    // GET [http://localhost:8189/webapp]/show_all
    @GetMapping("/show_all")
    public String showProductPage(Model model) {
        model.addAttribute("products", productsService.findAll());
        return "products";
    }

    // GET [http://localhost:8189/webapp]/show/{id}
    @GetMapping("/show/{id}")
    public String showProductPage(Model model, @PathVariable Long id) {
        model.addAttribute("product", productsService.findById(id));
        return "product_info";
    }

    @GetMapping("/create")
    public String showCreateForm() {
        return "create_product";
    }

    @PostMapping("/create")
    public String saveProduct(@RequestParam Long id, @RequestParam String title, @RequestParam int cost) {
        Product product = new Product(id, title, cost);
        productsService.save(product);
        return "redirect:/show_all";
    }
}
