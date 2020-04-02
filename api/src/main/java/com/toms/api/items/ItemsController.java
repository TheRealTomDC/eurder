package com.toms.api.items;

import com.toms.service.itemsservice.ItemCreaterDTO;
import com.toms.service.itemsservice.ItemDTO;
import com.toms.service.itemsservice.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RestController
@RequestMapping(path = "/items")

public class ItemsController {

    private final ItemsService itemsService;

    @Autowired
    public ItemsController(ItemsService itemsService) {
        this.itemsService = itemsService;
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDTO addNewItem(@RequestBody ItemCreaterDTO itemCreaterDTO){
        return itemsService.addNewItemService(itemCreaterDTO);
    }



    @ExceptionHandler(IllegalArgumentException.class)
    protected void illegalArgExc(IllegalArgumentException e, HttpServletResponse response) throws IOException{
        response.sendError(HttpStatus.CONFLICT.value(), e.getMessage());
    }
}
