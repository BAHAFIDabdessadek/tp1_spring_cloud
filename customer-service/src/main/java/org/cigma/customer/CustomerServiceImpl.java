package org.cigma.customer;

import lombok.RequiredArgsConstructor;
import org.cigma.customer.service.FraudFeignService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private final FraudFeignService fraudFeignService;
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;
    @Override
    public void registerCustomer(CustomerRequest customerRequest) {
        Customer customer = Customer.builder()
                .firstname(customerRequest.firstname())
                .lastname(customerRequest.lastname())
                .email(customerRequest.email())
                .build();

        // TODO: CHECK EMAIL VALID

        // TODO: CHECK EMAIL NOT TAKEN
        //TODO STORE CUSTOMER IN DATABASE
        customerRepository.save(customer);

        FraudResponse fraudResponse = fraudFeignService.isFraudster(customer.getId());
        /*
        restTemplate.getForObject(
                "http:localhost:8081/api/v1/fraud-check/{customer_id}",FraudResponse.class,customer.getId()
        );

         */

        if (fraudResponse.isFraudster()){
            throw  new IllegalStateException("Fraudster");
        }
    }

}
