package com.folksdev.account.service;

import com.folksdev.account.dto.CustomerDto;
import com.folksdev.account.dto.CustomerDtoConvertor;
import com.folksdev.account.exception.CustomerNotFoundException;
import com.folksdev.account.model.Customer;
import com.folksdev.account.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerDtoConvertor convertor;

    public CustomerService(CustomerRepository customerRepository, CustomerDtoConvertor convertor) {
        this.customerRepository = customerRepository;
        this.convertor = convertor;
    }

    protected Customer findCustomerById(String id){
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer could not find by id:" + id));
    }

    public CustomerDto getCustomerById(String customerId) {

        return convertor.convertToCustomerDto(findCustomerById(customerId));
    }
}
