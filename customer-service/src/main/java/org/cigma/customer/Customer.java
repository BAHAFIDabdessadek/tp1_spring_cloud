package org.cigma.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor @NoArgsConstructor @Entity
public class Customer {

    @Id @SequenceGenerator(
            name= "customer_id_sequence",
            sequenceName  = "customer_id_sequence",
            initialValue = 100
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE ,
            generator = "customer_id_sequence")
    private Long id ;
    private  String firstname;

    private  String lastname;
    private  String email;


}
