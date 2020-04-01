package com.toms.api.customer;


import com.toms.domain.customer.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/customers")
public class CustomerController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public void test(){

    }
}
