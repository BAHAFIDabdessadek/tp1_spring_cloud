package org.cigma.fraud;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity



public class Fraud {

    @Id
    @SequenceGenerator(
            name = "fraud_id_sequence",
            sequenceName = "fraud_id_sequence",
            initialValue = 32
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "fraud_id_sequence")
    private Long id;
    private Long id_customer;
    private Boolean isFraud;
    private LocalDateTime createdAt;

}
