package org.sid.bankaccountservice.service;

import org.sid.bankaccountservice.dto.BankAccountRequestDTD;
import org.sid.bankaccountservice.dto.BankAccountResponseDTD;

import org.sid.bankaccountservice.entities.BankAccount;
import org.sid.bankaccountservice.repositories.BankAccountRepository;

public interface AccountService {
     BankAccountResponseDTD addAccount(BankAccountRequestDTD bankAccountDTD);

    BankAccountResponseDTD updateAccount(String id, BankAccountRequestDTD bankAccountDTD);
}
