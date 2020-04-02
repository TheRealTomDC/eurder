package com.toms.domain.items;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ItemsRepository {

    private final Map itemsMap;

    public ItemsRepository() {
        this.itemsMap = new HashMap();
    }

    public void addNewItemToRepository(Item item){
        itemsMap.put(item.getName(),item);

    }

    public int getSizeOfMap(){
        return itemsMap.size();
    }


}
