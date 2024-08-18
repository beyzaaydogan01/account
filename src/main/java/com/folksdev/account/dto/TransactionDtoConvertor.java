package com.folksdev.account.dto;

import com.folksdev.account.model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionDtoConvertor {

    public TransactionDto convert(Transaction from){
        return new TransactionDto(from.getId(),
                from.getTransactionType(),
                from.getAmount(),
                from.getTransactionDate());
    }
}
