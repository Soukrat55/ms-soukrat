package org.sid.bankaccountservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor @Builder

public class Customer {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "customer")
    @JsonProperty(access=JsonProperty.Access.WRITE_ONLY) //pour pas faire la repertion de jointure entre Account et Customer
    private List<BankAccount> bankAccounts;
}
