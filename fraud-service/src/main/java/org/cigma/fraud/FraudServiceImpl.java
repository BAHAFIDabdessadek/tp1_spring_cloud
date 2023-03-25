package org.cigma.fraud;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class FraudServiceImpl implements FraudService {

    private final FraudRepository fraudRepository;
    @Override
    public Boolean isFraudulentCustomer(Long customer_id) {
        fraudRepository.save(
                Fraud.builder()
                        .id_customer(customer_id)
                        .isFraud(false)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return false;
    }
}
