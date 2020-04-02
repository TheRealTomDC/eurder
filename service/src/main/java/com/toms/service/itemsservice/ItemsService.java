package com.toms.service.itemsservice;

import com.toms.domain.items.Item;
import com.toms.domain.items.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemsService {

    private ItemsRepository itemsRepository;

    @Autowired
    public ItemsService(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    public ItemDTO addNewItemService(ItemCreaterDTO itemCreaterDTO){
        Item newItem = new Item(itemCreaterDTO.getName(),itemCreaterDTO.getDescription(),itemCreaterDTO.getPrice(),itemCreaterDTO.getAmountInStock());
        itemsRepository.addNewItemToRepository(newItem);
        return new ItemDTO(newItem);
    }
}
