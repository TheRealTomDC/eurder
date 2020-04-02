package com.toms.api.orders;

import com.toms.domain.customer.Customer;
import com.toms.service.orderservice.OrderOpeningDTO;
import com.toms.service.orderservice.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/orders")

public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(path = "/new-order", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public String startNewOrder(@RequestBody String customersEmail) {
        return (orderService.openNewOrder(customersEmail)).toString();
    }
}
