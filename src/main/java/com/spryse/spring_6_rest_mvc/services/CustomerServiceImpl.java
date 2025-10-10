package com.spryse.spring_6_rest_mvc.services;

import com.spryse.spring_6_rest_mvc.models.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    private Map<UUID, Customer> customerMap;

    public CustomerServiceImpl() {
        this.customerMap = new HashMap<>();

        Customer c1 = Customer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .customerName("Customer One")
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        Customer c2 = Customer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .customerName("Customer Two")
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        Customer c3 = Customer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .customerName("Customer Three")
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        customerMap.put(c1.getId(), c1);
        customerMap.put(c2.getId(), c2);
        customerMap.put(c3.getId(), c3);
    }

    @Override
    public List<Customer> listAll() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public Customer getById(UUID id) {
        log.debug("Get customer by Id - in service. Id: " + id.toString());

        return customerMap.get(id);
    }

    @Override
    public Customer create(Customer customer) {
        Customer savedCustomer = Customer.builder()
                .id(UUID.randomUUID())
                .customerName(customer.getCustomerName())
                .version(1)
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        customerMap.put(savedCustomer.getId(), savedCustomer);

        return savedCustomer;
    }

    @Override
    public void update(UUID id, Customer customer) {
        Customer existing = customerMap.get(id);

        if (existing == null) {
            return;
        }

        existing.setCustomerName(customer.getCustomerName());
        existing.setVersion(existing.getVersion()+1);
        existing.setLastModifiedDate(LocalDateTime.now());

        customerMap.put(id, existing);
    }

    @Override
    public void patch(UUID id, Customer customer) {
        Customer existing = customerMap.get(id);

        if (existing == null) {
            return;
        }

        if (customer.getCustomerName() != null) {
            existing.setCustomerName(customer.getCustomerName());
        }

        existing.setVersion(existing.getVersion()+1);
        existing.setLastModifiedDate(LocalDateTime.now());
    }

    @Override
    public void delete(UUID id) {
        customerMap.remove(id);
    }
}
