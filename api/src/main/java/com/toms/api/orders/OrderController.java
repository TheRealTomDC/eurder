package com.toms.api.orders;


import com.toms.service.orderservice.ItemGroupCreatedDTO;
import com.toms.service.orderservice.ItemGroupCreatorDTO;
import com.toms.service.orderservice.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(path = "/orders")

public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(path = "/new-order", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public String startNewOrder(@RequestBody String customersEmail) {
        return (orderService.openNewOrder(customersEmail)).toString();
    }

    @PostMapping(path = "/makeItemGroup", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public String makeItemGroup(@RequestBody ItemGroupCreatorDTO itemGroupCreatorDTO) {
        ItemGroupCreatedDTO toPrintOut = (orderService.makeNewItemGroupService(itemGroupCreatorDTO));
        return toPrintOut.toString();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    protected void notUniqueException(IllegalArgumentException e, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.CONFLICT.value(), e.getMessage());
    }
}
