package com.toms.service.itemsservice;

import com.toms.domain.items.Item;
import com.toms.domain.items.ItemsRepository;
import com.toms.service.validationservice.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemsService {

    private ItemsRepository itemsRepository;
    private Validation validation;

    @Autowired
    public ItemsService(ItemsRepository itemsRepository, Validation validation) {
        this.itemsRepository = itemsRepository;
        this.validation = validation;
    }

    public ItemDTO addNewItemService(ItemCreaterDTO itemCreaterDTO){
        validation.checkIfItemIsNotAlreadyInStock(itemCreaterDTO.getName());
        Item newItem = new Item(itemCreaterDTO.getName(),itemCreaterDTO.getDescription(),itemCreaterDTO.getPrice(),itemCreaterDTO.getAmountInStock());
        itemsRepository.save(newItem);
        return new ItemDTO(newItem);
    }
}
