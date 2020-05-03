package com.toms.api.items;

import com.toms.domain.items.ItemsRepository;
import com.toms.service.itemsservice.ItemCreaterDTO;
import com.toms.service.itemsservice.ItemDTO;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ItemsControllerTest {

    private final ItemsController itemsController;
    private final ItemsRepository itemsRepository;

    @Autowired
    public ItemsControllerTest(ItemsController itemsController, ItemsRepository itemsRepository) {
        this.itemsController = itemsController;
        this.itemsRepository = itemsRepository;
    }

    @Test
    void whenItemisAdded_makeSureItReturnsDTO() {
        ItemCreaterDTO itemCreaterDTO = new ItemCreaterDTO("Banana", "yellow", 0.9, 10);
        Assertions.assertThat(itemsController.addNewItem(itemCreaterDTO)).isInstanceOf(ItemDTO.class);
    }

    @Test
    void whenOneItemIsInRepository_addNewItem_makeSureSizeOfRepositoryIsTwo() {
        //Given
        ItemCreaterDTO itemCreaterDTO = new ItemCreaterDTO("Banana", "yellow", 0.9, 10);
        ItemCreaterDTO secondItem = new ItemCreaterDTO("Grape", "round", 1.1, 5);
        itemsController.addNewItem(itemCreaterDTO);
        //When
        itemsController.addNewItem(secondItem);
        // Then
        Assertions.assertThat(itemsRepository.count()).isEqualTo(2);
    }

    @Test
    void whenOneItemIsInRepository_addNewItemWithSameName_makeSureReturnsException() {
        //Given
        ItemCreaterDTO itemCreaterDTO = new ItemCreaterDTO("Banana", "yellow", 0.9, 10);
        ItemCreaterDTO secondItem = new ItemCreaterDTO("Banana", "round", 1.1, 5);
        itemsController.addNewItem(itemCreaterDTO);
        // Then
        Assertions.assertThatThrownBy(()->itemsController.addNewItem(secondItem)).hasMessage("There is allready a Banana item in our stock");
      //  Assertions.assertThat(itemsRepository.getAmountOfGivenItem("Banana")).isEqualTo(10);  // not sure he even gets there
    }

    @AfterEach
    void clear(){
        itemsRepository.deleteAll();
    }


}
