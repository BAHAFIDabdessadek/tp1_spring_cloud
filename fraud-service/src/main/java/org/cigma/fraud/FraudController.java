package org.cigma.fraud;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
@RequiredArgsConstructor
public class FraudController {

    private final FraudService fraudService;


    @GetMapping("/{customer_id}")
    public FraudResponse isFraudster(@PathVariable("customer_id") Long customer_id){

        boolean isFraudulentCustomer = fraudService.isFraudulentCustomer(customer_id);

        return new FraudResponse(isFraudulentCustomer);


    }

}
