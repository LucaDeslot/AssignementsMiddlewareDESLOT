package cvut.fel;

import cvut.fel.entity.Customer;
import cvut.fel.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class  StartApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(StartApplication.class);

    @Autowired
    private CustomerRepository customerRepository;

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

    @Override
    public void run(String... args) {

        log.info("StartApplication...");

        Customer customer1 = new Customer("Java");
        customer1.setPhone("09");
        Customer customer2 = new Customer("Node");
        customer2.setPhone("08");
        Customer customer3 = new Customer("Python");
        customer3.setPhone("07");
        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);

        System.out.println("\nfindAll()");
        customerRepository.findAll().forEach(System.out::println);

        System.out.println("\nfindById(1L)");
        customerRepository.findById(1L).ifPresent(System.out::println);

        System.out.println("\nfindByName('Node')");
        customerRepository.findByName("Node").forEach(System.out::println);


    }

}