package az.ibatech.codechallange.config;

import az.ibatech.codechallange.entity.db.CreditHistories;
import az.ibatech.codechallange.entity.db.Customer;
import az.ibatech.codechallange.repository.CreditHistoryRepository;
import az.ibatech.codechallange.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class AutoRun {


    @Bean
    public CommandLineRunner mapping(CustomerRepository customerRepository,
                                     CreditHistoryRepository creditHistoryRepository) {
        return args -> {

            Customer customer1 = new Customer("Ali", 31, 200.0);
            Customer customer2 = new Customer("Aysu", 21, 204.0);
            Customer customer3 = new Customer("Adil", 43, 400.0);
            Customer customer4 = new Customer("Leyla", 32, 1100.0);
            Customer customer5 = new Customer("Vahid", 51, 200.0);

            customerRepository.saveAll(List.of(customer1,customer2,customer3,customer4));


            CreditHistories creditHistories1 = new CreditHistories(new Date(), 200.0, customer1);
            CreditHistories creditHistories2 = new CreditHistories(new Date(), 300.0, customer2);
            CreditHistories creditHistories3 = new CreditHistories(new Date(), 400.0, customer3);
            CreditHistories creditHistories4 = new CreditHistories(new Date(), 450.0, customer4);
            CreditHistories creditHistories5 = new CreditHistories(new Date(), 500.0, customer1);
            CreditHistories creditHistories6 = new CreditHistories(new Date(), 530.0, customer4);
            CreditHistories creditHistories7 = new CreditHistories(new Date(), 100.0, customer1);
            CreditHistories creditHistories8 = new CreditHistories(new Date(), 340.0, customer3);
            CreditHistories creditHistories9 = new CreditHistories(new Date(), 340.0, customer5);
            CreditHistories creditHistories10 = new CreditHistories(new Date(), 340.0, customer5);
            CreditHistories creditHistories11 = new CreditHistories(new Date(), 340.0, customer5);

            creditHistoryRepository.saveAll(List.of(creditHistories1,creditHistories2,
                    creditHistories3,creditHistories4,creditHistories5,creditHistories6,creditHistories7,
                    creditHistories8, creditHistories9, creditHistories10, creditHistories11));
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}