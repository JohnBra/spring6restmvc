package com.spryse.spring_6_rest_mvc.services;

import com.spryse.spring_6_rest_mvc.models.CustomerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    private Map<UUID, CustomerDTO> customerMap;

    public CustomerServiceImpl() {
        this.customerMap = new HashMap<>();

        CustomerDTO c1 = CustomerDTO.builder()
                .id(UUID.randomUUID())
                .version(1)
                .customerName("Customer One")
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        CustomerDTO c2 = CustomerDTO.builder()
                .id(UUID.randomUUID())
                .version(1)
                .customerName("Customer Two")
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        CustomerDTO c3 = CustomerDTO.builder()
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
    public List<CustomerDTO> listAll() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public Optional<CustomerDTO> getById(UUID id) {
        log.debug("Get customer by Id - in service. Id: " + id.toString());

        return Optional.of(customerMap.get(id));
    }

    @Override
    public CustomerDTO create(CustomerDTO customer) {
        CustomerDTO savedCustomer = CustomerDTO.builder()
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
    public void update(UUID id, CustomerDTO customer) {
        CustomerDTO existing = customerMap.get(id);

        if (existing == null) {
            return;
        }

        existing.setCustomerName(customer.getCustomerName());
        existing.setVersion(existing.getVersion()+1);
        existing.setLastModifiedDate(LocalDateTime.now());

        customerMap.put(id, existing);
    }

    @Override
    public void patch(UUID id, CustomerDTO customer) {
        CustomerDTO existing = customerMap.get(id);

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
