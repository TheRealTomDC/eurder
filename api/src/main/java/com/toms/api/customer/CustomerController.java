package com.toms.api.customer;


import com.toms.domain.customer.NotUniqueException;
import com.toms.service.customerservice.CustomerCreaterDTO;
import com.toms.service.customerservice.CustomerDTO;
import com.toms.service.customerservice.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(path = "/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @PostMapping(produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO createCustomerAccount(@RequestBody CustomerCreaterDTO customerCreaterDTO){
        return customerService.createCustomerService(customerCreaterDTO);
    }

    @ExceptionHandler(NotUniqueException.class)
    protected void notUniqueException(NotUniqueException e, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.CONFLICT.value(), e.getMessage());
    }




}
