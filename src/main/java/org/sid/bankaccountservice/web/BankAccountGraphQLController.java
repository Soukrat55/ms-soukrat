package org.sid.bankaccountservice.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.bankaccountservice.dto.BankAccountRequestDTD;
import org.sid.bankaccountservice.dto.BankAccountResponseDTD;
import org.sid.bankaccountservice.entities.BankAccount;
import org.sid.bankaccountservice.entities.Customer;
import org.sid.bankaccountservice.repositories.BankAccountRepository;
import org.sid.bankaccountservice.repositories.CustomerRepository;
import org.sid.bankaccountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller

public class BankAccountGraphQLController {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountService accountService;
    @Autowired
    private CustomerRepository customerRepository;

    @QueryMapping
    public List<BankAccount> accountsList(){
        return  bankAccountRepository.findAll();
    }

    @QueryMapping
    public BankAccount bankAccountById(@Argument String id){
        return  bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Account %s,not found",id)));
    }
    @MutationMapping
    public BankAccountResponseDTD addAccount(@Argument BankAccountRequestDTD bankAccount){
      //  return bankAccountRepository.save(bankAccount);
        return accountService.addAccount(bankAccount);
    }
    @MutationMapping
    public BankAccountResponseDTD updateAccount(@Argument String id,@Argument BankAccountRequestDTD bankAccount){
        return accountService.updateAccount(id,bankAccount);
    }

    @MutationMapping
    public void deleteAccount(@Argument String id){
         bankAccountRepository.deleteById(id);
    }

    @QueryMapping
    public List<Customer> customers(){
        return  customerRepository.findAll();
    }


}
/*
record BankAccountDTD(Double balance,String type,String currency){ //le plus recent java 14=<version

}*/
////////// est equivalant de ca
// le plus ancien/////////
/*
@Data @NoArgsConstructor @AllArgsConstructor
class BankAccountDTD{
    private  String type;
    private  Double balance;
    private String currency;
}*/
