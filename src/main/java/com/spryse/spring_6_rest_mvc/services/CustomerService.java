package com.spryse.spring_6_rest_mvc.services;

import com.spryse.spring_6_rest_mvc.models.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    public List<Customer> listAll();

    public Customer getById(UUID id);

    public Customer create(Customer customer);
}
