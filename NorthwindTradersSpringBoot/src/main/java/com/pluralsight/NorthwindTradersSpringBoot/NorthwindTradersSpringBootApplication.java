package com.pluralsight.NorthwindTradersSpringBoot;

import com.pluralsight.utils.IOUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class NorthwindTradersSpringBootApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(NorthwindTradersSpringBootApplication.class, args);
		ProductService service = context.getBean(ProductService.class);

		boolean running = true;
		while (running) {
			System.out.println("""
					1) List Products
					2) Add Products
					0) Exit
					""");

			int choice = IOUtils.messageAndResponseInt("Make your choice: ");
			switch (choice) {
				case 1 -> service.printProducts(service.getProducts());
				case 2 -> service.addProduct(new Product());
				case 0 -> running = false;
				default -> System.err.println("Error: choose one of the available options.");
			}
		}
		context.close();
	}
}
