package org.sid.bankaccountservice.mappers;

import org.sid.bankaccountservice.dto.BankAccountResponseDTD;
import org.sid.bankaccountservice.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public BankAccountResponseDTD formBankAccount(BankAccount bankAccount){
        BankAccountResponseDTD bankAccountResponseDTD =new BankAccountResponseDTD();
        BeanUtils.copyProperties(bankAccount,bankAccountResponseDTD);
        return bankAccountResponseDTD;
    }
}
