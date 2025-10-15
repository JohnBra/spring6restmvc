package com.spryse.spring_6_rest_mvc.services;

import com.spryse.spring_6_rest_mvc.entities.Customer;
import com.spryse.spring_6_rest_mvc.mappers.CustomerMapper;
import com.spryse.spring_6_rest_mvc.models.CustomerDTO;
import com.spryse.spring_6_rest_mvc.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Primary
@RequiredArgsConstructor
public class CustomerServiceJPA implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public List<CustomerDTO> listAll() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::customerToCustomerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CustomerDTO> getById(UUID id) {
        return Optional.ofNullable(customerMapper.customerToCustomerDTO((customerRepository.findById(id).orElse(null))));
    }

    @Override
    public CustomerDTO create(CustomerDTO customerDTO) {
        Customer customer = customerRepository.save(customerMapper.customerDtoToCustomer(customerDTO));
        return customerMapper.customerToCustomerDTO(customer);
    }

    @Override
    public void update(UUID id, CustomerDTO customerDTO) {
        customerRepository.findById(id).ifPresent(foundCustomer -> {
            foundCustomer.setCustomerName(customerDTO.getCustomerName());
            customerRepository.save(foundCustomer);
        });
    }

    @Override
    public void delete(UUID id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void patch(UUID id, CustomerDTO customerDTO) {
        customerRepository.findById(id).ifPresent(foundCustomer -> {
            foundCustomer.setCustomerName(customerDTO.getCustomerName());
            customerRepository.save(foundCustomer);
        });
    }
}
