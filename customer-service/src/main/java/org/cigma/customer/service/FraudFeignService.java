package org.cigma.customer.service;

import org.cigma.customer.FraudResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "FRAUD-SERVICE")
public interface FraudFeignService {

    @GetMapping(path = "api/v1/fraud-check/{customer_id}")
    FraudResponse isFraudster(@PathVariable("customer_id") Long customer_id);
}
