package com.demo.ecommerce;

import com.demo.ecommerce.entity.Product;
import com.demo.ecommerce.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class EcommerceApplication {
	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

	@Bean
	CommandLineRunner run(ProductRepository productRepository) {
		return args -> {
			productRepository.save(new Product(null,
					"Sample Product",
					"Sample product to verify DB connection",
					new BigDecimal("199.99"),
					100));
			productRepository.findAll().forEach(System.out::println);
		};
	}
}
