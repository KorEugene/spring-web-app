package ru.geekbrains.webapp.repositories;

import org.springframework.stereotype.Component;
import ru.geekbrains.webapp.model.Product;
import ru.geekbrains.webapp.model.ProductTitle;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class ProductsRepository {

    private List<Product> products;

    @PostConstruct
    public void init() {

        Random random = new Random();
        int productsCount = 5;

        ProductTitle[] productTitles = ProductTitle.values();
        this.products = new ArrayList<>();
        for (int i = 0; i < productsCount; i++) {
            products.add(new Product(i + 1L, productTitles[i].getTitle(), random.nextInt(100)));
        }
    }

    public List<Product> findAll() {
        return Collections.unmodifiableList(products);
    }

    public Product findById(Long id) {
        return products.stream().filter(s -> s.getId().equals(id)).findFirst().get();
    }

    public void save(Product product) {
        products.add(product);
    }
}
