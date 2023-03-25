package org.cigma.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{


    private final CustomerRepository customerRepository;
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

    }

}
