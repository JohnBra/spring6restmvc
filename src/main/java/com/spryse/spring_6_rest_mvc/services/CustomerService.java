package com.spryse.spring_6_rest_mvc.services;

import com.spryse.spring_6_rest_mvc.models.CustomerDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerService {
    public List<CustomerDTO> listAll();

    public Optional<CustomerDTO> getById(UUID id);

    public CustomerDTO create(CustomerDTO customer);

    public void update(UUID id, CustomerDTO customer);

    public void delete(UUID customerId);

    public void patch(UUID customerId, CustomerDTO customer);
}
