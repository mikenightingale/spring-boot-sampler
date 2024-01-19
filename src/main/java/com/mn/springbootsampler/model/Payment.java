package com.mn.springbootsampler.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@NoArgsConstructor
@Data
public class Payment {

    @Builder
    private Payment(Integer paymentId, String bic, String iban, String currency, Integer amount) {
        this.paymentId = paymentId;
        this.bic = bic;
        this.iban = iban;
        this.currency = currency;
        this.amount = amount;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
    @GenericGenerator(name = "seq", strategy="increment")
    private Integer paymentId;
    private String bic;
    private String iban;
    private String currency;
    private Integer amount;

}
