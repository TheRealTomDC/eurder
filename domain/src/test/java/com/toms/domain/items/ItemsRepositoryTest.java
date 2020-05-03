/*
package com.toms.domain.items;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemsRepositoryTest {

    @Test
    void checkAndMaybeAdjustStock_ifAmountToBuyIsBiggerThenAmountInStock_givesBackFalse() {
        // Given
        Item item = new Item("thisItem","t",20.0,10);
        ItemsRepository itemsRepository = new ItemsRepository();
        itemsRepository.addNewItemToRepository(item);
        // Then
        assertFalse(itemsRepository.checkAndMaybeAdjustStock("thisItem",11));
    }

    @Test
    void checkAndMaybeAdjustStock_ifAmountToBuyIsSmallerThenAmountInStock_givesBackTrueAndAdjustStock() {
        // Given
        Item item = new Item("thisItem","t",20.0,10);
        ItemsRepository itemsRepository = new ItemsRepository();
        itemsRepository.addNewItemToRepository(item);
        // Then
        assertTrue(itemsRepository.checkAndMaybeAdjustStock("thisItem",9));
        assertEquals(1,itemsRepository.getAmountOfGivenItem("thisItem"));
    }

    @Test
    void checkAndMaybeAdjustStock_ifAmountToBuyIsEqualThenAmountInStock_givesBackTrueAndAdjustStock() {
        // Given
        Item item = new Item("thisItem","t",20.0,10);
        ItemsRepository itemsRepository = new ItemsRepository();
        itemsRepository.addNewItemToRepository(item);
        // Then
        assertTrue(itemsRepository.checkAndMaybeAdjustStock("thisItem",10));
        assertEquals(0,itemsRepository.getAmountOfGivenItem("thisItem"));
    }
}*/
