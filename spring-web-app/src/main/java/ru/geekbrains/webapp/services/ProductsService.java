package ru.geekbrains.webapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.webapp.model.Product;
import ru.geekbrains.webapp.repositories.ProductsRepository;

import java.util.List;

@Service
public class ProductsService {

    private ProductsRepository productsRepository;

    @Autowired
    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public List<Product> findAll() {
        return productsRepository.findAll();
    }

    public Product findById(Long id) {
        return productsRepository.findById(id);
    }

    public void save(Product product) {
        productsRepository.save(product);
    }

    public void changeProductPrice(Long id, String action) {
        Product product = findById(id);
        int productCurrentPrice = product.getPrice();
        product.setPrice(action.equals("increment") ? ++productCurrentPrice : --productCurrentPrice);
    }
}
