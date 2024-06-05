package com.gopi;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gopi.entity.Address;
import com.gopi.entity.Order;
import com.gopi.entity.OrderItem;
import com.gopi.entity.Product;
import com.gopi.entity.repository.OrderRepository;
import com.gopi.entity.repository.ProductRepository;

import jakarta.transaction.Transactional;


@SpringBootApplication
public class OneToOneMappingApplication implements CommandLineRunner{

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	ProductRepository productRepository;
	    
	public static void main(String[] args) {
		SpringApplication.run(OneToOneMappingApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		saveOrder();
		//saveProducts();
	}

	@Transactional
	public void saveOrder() {
		Address address = new Address();
		address.setStreet("456 MG Road");
		address.setCity("Bangalore");
		address.setState("Karnataka");
		address.setCountry("India");
		address.setPinCode("560001");

		
		Order order = new Order();
		order.setOrderTrackingNumber("ORD123456");
		order.setStatus("Shipped");
		
		
		//Create the Order Item-1
		OrderItem orderItem1 = new OrderItem();
		orderItem1.setProduct(productRepository.findById(11L).get());
		orderItem1.setImageUrl("imgUrl-1.png");
		orderItem1.setQuantity(2);
		orderItem1.setPrice(productRepository.findById(11L).get().getPrice().multiply(new BigDecimal(2)));
		
		OrderItem orderItem2 = new OrderItem();
		orderItem2.setProduct(productRepository.findById(12L).get());
		orderItem2.setImageUrl("imgUrl-1.png");
		orderItem2.setQuantity(3);
		orderItem2.setPrice(productRepository.findById(12L).get().getPrice().multiply(new BigDecimal(3)));
		
		order.getOrderItems().add(orderItem1);
		order.getOrderItems().add(orderItem2);
		order.setAddress(address);
		
		BigDecimal amount = productRepository.findById(11L).get().getPrice().
				multiply(new BigDecimal(2)).add(productRepository.findById(12L).get().getPrice().multiply(new BigDecimal(3)));
		
		order.setTotalPrice(amount);
		order.setTotalQuantity(2);
		orderRepository.save(order);
		
	}	
	
	
	
	public void saveProducts() {
		  List<Product> products = new ArrayList<>();

	       // products.add(createProduct("SKU-001", "Apple iPhone 14", "Latest model of iPhone with A15 Bionic chip, 6.1-inch display, and improved camera system.", new BigDecimal("999.99"), "http://example.com/iphone14.jpg"));
	        products.add(createProduct("SKU-002", "Samsung Galaxy S22", "Flagship Samsung smartphone with Snapdragon 8 Gen 1 processor and 108MP camera.", new BigDecimal("899.99"), "http://example.com/galaxys22.jpg"));
	        products.add(createProduct("SKU-003", "Sony WH-1000XM4", "Noise-cancelling wireless headphones with superior sound quality and comfort.", new BigDecimal("349.99"), "http://example.com/sonywh1000xm4.jpg"));
	        products.add(createProduct("SKU-004", "Dell XPS 13", "High-performance ultrabook with Intel i7 processor, 16GB RAM, and 512GB SSD.", new BigDecimal("1199.99"), "http://example.com/dellxps13.jpg"));
	        products.add(createProduct("SKU-005", "Apple MacBook Pro", "Powerful laptop with M1 chip, 16GB RAM, and stunning Retina display.", new BigDecimal("1499.99"), "http://example.com/macbookpro.jpg"));
	        products.add(createProduct("SKU-006", "Bose QuietComfort 35 II", "Wireless noise-cancelling headphones with Alexa voice control.", new BigDecimal("299.99"), "http://example.com/boseqc35ii.jpg"));
	        products.add(createProduct("SKU-007", "Amazon Echo Dot", "Smart speaker with Alexa, perfect for any room.", new BigDecimal("49.99"), "http://example.com/echodot.jpg"));
	        products.add(createProduct("SKU-008", "Fitbit Charge 5", "Advanced fitness and health tracker with built-in GPS and stress management tools.", new BigDecimal("179.99"), "http://example.com/fitbitcharge5.jpg"));
	        products.add(createProduct("SKU-009", "Nintendo Switch", "Versatile gaming console that can be used as a home console and handheld device.", new BigDecimal("299.99"), "http://example.com/nintendoswitch.jpg"));
	        products.add(createProduct("SKU-010", "GoPro HERO10", "High-performance action camera with 5.3K video and advanced stabilization.", new BigDecimal("499.99"), "http://example.com/goprohero10.jpg"));
	        products.add(createProduct("SKU-011", "Logitech MX Master 3", "Advanced wireless mouse with ergonomic design and programmable buttons.", new BigDecimal("99.99"), "http://example.com/logitechmxmaster3.jpg"));
	        products.add(createProduct("SKU-012", "Kindle Paperwhite", "E-reader with high-resolution display, waterproof design, and built-in light.", new BigDecimal("129.99"), "http://example.com/kindlepaperwhite.jpg"));
	        products.add(createProduct("SKU-013", "Instant Pot Duo", "7-in-1 electric pressure cooker, slow cooker, rice cooker, and more.", new BigDecimal("89.99"), "http://example.com/instantpotduo.jpg"));
	        products.add(createProduct("SKU-014", "Dyson V11", "High-performance cordless vacuum cleaner with powerful suction and intelligent cleaning modes.", new BigDecimal("599.99"), "http://example.com/dysonv11.jpg"));
	        products.add(createProduct("SKU-015", "Sony PlayStation 5", "Next-gen gaming console with ultra-high-speed SSD and 4K gaming support.", new BigDecimal("499.99"), "http://example.com/ps5.jpg"));
	        products.add(createProduct("SKU-016", "Oculus Quest 2", "Advanced all-in-one virtual reality headset with 128GB storage and intuitive controls.", new BigDecimal("299.99"), "http://example.com/oculusquest2.jpg"));
	        products.add(createProduct("SKU-017", "Nespresso VertuoPlus", "Coffee and espresso machine with Centrifusion technology for perfect brewing.", new BigDecimal("179.99"), "http://example.com/nespressovertuoplus.jpg"));
	        products.add(createProduct("SKU-018", "Anker PowerCore 10000", "Compact and lightweight portable charger with high-speed charging technology.", new BigDecimal("25.99"), "http://example.com/ankerpowercore10000.jpg"));
	        products.add(createProduct("SKU-019", "Apple Watch Series 7", "Smartwatch with always-on Retina display, ECG app, and fitness tracking features.", new BigDecimal("399.99"), "http://example.com/applewatchseries7.jpg"));
	        products.add(createProduct("SKU-020", "Canon EOS R5", "Professional mirrorless camera with 45MP sensor and 8K video recording.", new BigDecimal("3899.99"), "http://example.com/canoneosr5.jpg"));

	        productRepository.saveAll(products);

	}
	
	private static  Product createProduct(String sku, String name, String description, BigDecimal price, String imageUrl) {
        Product product = new Product();
        product.setSku(sku);
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setActive(true);
        product.setImageUrl(imageUrl);
        return product;
    }
}
