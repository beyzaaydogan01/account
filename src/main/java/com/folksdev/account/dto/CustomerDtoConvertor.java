package com.folksdev.account.dto;

import com.folksdev.account.model.Customer;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomerDtoConvertor {
    private final CustomerAccountDtoConvertor convertor;

    public CustomerDtoConvertor(CustomerAccountDtoConvertor convertor) {
        this.convertor = convertor;
    }

    public AccountCustomerDto convertToAccountCustomer(Customer from){
        if(from == null){
            return new AccountCustomerDto("","","");
        }

        return new AccountCustomerDto(from.getId(), from.getName(), from.getSurname());
    }
    public CustomerDto convertToCustomerDto(Customer from){
        return new CustomerDto(
                from.getId(),
                from.getName(),
                from.getSurname(),
                from.getAccounts().stream().map(convertor::convert).collect(Collectors.toSet()));
    }
}
