package com.toms.api.customer;


import com.toms.service.customerService.CustomerCreaterDTO;
import com.toms.service.customerService.CustomerDTO;
import com.toms.service.customerService.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO createCustomerAccount(@RequestBody CustomerCreaterDTO customerCreaterDTO){
        return customerService.createCustomerService(customerCreaterDTO);
    }
}
