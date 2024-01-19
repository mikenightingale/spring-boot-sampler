package com.mn.springbootsampler.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@NoArgsConstructor
@Data
public class Payment implements IdentifiedEntity {

    @Builder
    @SuppressWarnings("unused")
    private Payment(Integer paymentId, String bic, String iban, String currency, Integer amount) {
        this.id = paymentId;
        this.bic = bic;
        this.iban = iban;
        this.currency = currency;
        this.amount = amount;
    }

    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "payment_seq"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @Column(name="payment_id")
    private Integer id;
    private String bic;
    private String iban;
    private String currency;
    private Integer amount;

}
