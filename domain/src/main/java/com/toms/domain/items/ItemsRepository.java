package com.toms.domain.items;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ItemsRepository {

    private final Map<String, Item> itemsMap;

    public ItemsRepository() {
        this.itemsMap = new HashMap();
    }

    public double getItemPrice(String itemToBuy) {
        return itemsMap.get(itemToBuy).getPrice();
    }

    public void addNewItemToRepository(Item item) {
        itemsMap.put(item.getName(), item);

    }

    public int getSizeOfMap() {
        return itemsMap.size();
    }

    public void checkIfItemIsNotAllreadyInStock(String name) {
        if (itemsMap.containsKey(name)) {
            throw new IllegalArgumentException("There is allready a " + name + " item in our stock");
        }
    }

    public int getAmountOfGivenItem(String name) {
        return itemsMap.get(name).getAmountInStock();
    }

    public Map<String, Item> getItemsMap() {
        return itemsMap;
    }

    public boolean checkAndMaybeAdjustStock(String itemToBuy, int amountToBuy) {
        if (getAmountOfGivenItem(itemToBuy) < amountToBuy) {
            return false;
        }
        itemsMap.get(itemToBuy).setAmountInStock(getAmountOfGivenItem(itemToBuy) - amountToBuy);
        return true;
    }
}
