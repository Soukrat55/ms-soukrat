package org.sid.bankaccountservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.bankaccountservice.entities.AccountType;

import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor @Builder

public class BankAccountResponseDTD {
    private String id;
    private Date createAt;
    private Double balance;
    private String currency;
    private AccountType type;
}
