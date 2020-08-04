package az.ibatech.codechallange.service;

import az.ibatech.codechallange.entity.db.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAll();
}
