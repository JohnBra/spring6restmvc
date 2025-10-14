package com.spryse.spring_6_rest_mvc.mappers;

import com.spryse.spring_6_rest_mvc.entities.Customer;
import com.spryse.spring_6_rest_mvc.models.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    Customer customerDtoToCustomer(CustomerDTO dto);

    CustomerDTO customerToCustomerDTO(Customer customer);
}
