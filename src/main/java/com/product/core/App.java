package com.product.core;

import com.product.core.model.Product;
import com.product.core.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    CommandLineRunner init(ProductRepository productRepository) {
        return args -> {
            if (productRepository.count() == 0) {
                productRepository.save(new Product("Ordinateur Portable", "PC portable 15 pouces haute performance", 899.99, 10));
                productRepository.save(new Product("Souris Sans Fil", "Souris ergonomique Bluetooth", 29.99, 50));
                productRepository.save(new Product("Clavier Mecanique", "Clavier gaming retro-eclaire RGB", 79.99, 30));
                System.out.println(">>> 3 produits enregistres dans MySQL.");
            } else {
                System.out.println(">>> Base deja initialisee, " + productRepository.count() + " produits trouves.");
            }

            System.out.println("\n--- Liste des produits en base ---");
            productRepository.findAll().forEach(System.out::println);
            System.out.println("--- Fin de la liste ---\n");
        };
    }
}
