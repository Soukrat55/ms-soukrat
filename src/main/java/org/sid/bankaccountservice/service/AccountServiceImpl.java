package org.sid.bankaccountservice.service;

import jakarta.transaction.Transactional;
import org.sid.bankaccountservice.dto.BankAccountRequestDTD;
import org.sid.bankaccountservice.dto.BankAccountResponseDTD;
import org.sid.bankaccountservice.entities.BankAccount;
import org.sid.bankaccountservice.mappers.AccountMapper;
import org.sid.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public BankAccountResponseDTD addAccount(BankAccountRequestDTD bankAccountDTD) {
        BankAccount bankAccount=BankAccount.builder()
        .id(UUID.randomUUID().toString())
                .createAt(new Date())
                .balance((bankAccountDTD.getBalance()))
                .type(bankAccountDTD.getType())
                .currency(bankAccountDTD.getCurrency())
                .build();
        BankAccount saveBankAccount=bankAccountRepository.save(bankAccount);

     /*   BankAccountResponseDTD bankAccountResponseDTD=BankAccountResponseDTD.builder()
                .id(saveBankAccount.getId())
                .createAt(saveBankAccount.getCreateAt())
                .balance((saveBankAccount.getBalance()))
                .type(saveBankAccount.getType())
                .currency(saveBankAccount.getCurrency())
                .build();*/

        BankAccountResponseDTD bankAccountResponseDTD=accountMapper.formBankAccount(saveBankAccount);
        return bankAccountResponseDTD;
    }

    @Override
    public BankAccountResponseDTD updateAccount(String id,BankAccountRequestDTD bankAccountDTD) {
        BankAccount bankAccount=BankAccount.builder()
                .id(id)
                .createAt(new Date())
                .balance((bankAccountDTD.getBalance()))
                .type(bankAccountDTD.getType())
                .currency(bankAccountDTD.getCurrency())
                .build();
        BankAccount saveBankAccount=bankAccountRepository.save(bankAccount);
        BankAccountResponseDTD bankAccountResponseDTD=accountMapper.formBankAccount(saveBankAccount);
        return bankAccountResponseDTD;
    }
}
