package com.pluralsight.NorthwindTradersSpringBoot;

import com.pluralsight.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class NorthwindApplication implements CommandLineRunner {

    private ProductDao service;

    @Autowired
    public NorthwindApplication(ProductDao service) {
        this.service = service;
    }

    @Override
    public void run(String... args) throws Exception {
        boolean running = true;
        while (running) {
            System.out.println("""
					1) List Products
					2) Add Products
					0) Exit
					""");

            int choice = IOUtils.messageAndResponseInt("Make your choice: ");
            switch (choice) {
                case 1 -> service.printProducts(service.getAllProducts());
                case 2 -> service.addProduct(new Product());
                case 0 -> running = false;
                default -> System.err.println("Error: choose one of the available options.");
            }
        }
    }
}
