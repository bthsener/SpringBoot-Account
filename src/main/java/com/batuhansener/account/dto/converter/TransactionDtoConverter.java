package com.batuhansener.account.dto.converter;

import com.batuhansener.account.dto.TransactionDto;
import com.batuhansener.account.model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionDtoConverter {

    public TransactionDto convert(Transaction from){
        return new TransactionDto(from.getId(), from.getTransactionType(), from.getAmount(), from.getTransactionDate());
    }
}
