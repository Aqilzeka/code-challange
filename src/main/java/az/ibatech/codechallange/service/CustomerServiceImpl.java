package az.ibatech.codechallange.service;

import az.ibatech.codechallange.entity.db.Customer;
import az.ibatech.codechallange.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepository customerRepository;


    @Override
    public List<Customer> getAll() {
        return customerRepository.findByOrderByCreditHistoriesAsc();
    }
}
