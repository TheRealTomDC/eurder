package com.toms.api.items;

import com.toms.domain.items.ItemsRepository;
import com.toms.service.itemsservice.ItemCreaterDTO;
import com.toms.service.itemsservice.ItemDTO;
import com.toms.service.itemsservice.ItemsService;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class ItemsControllerTest {

    ItemsRepository repository = new ItemsRepository();
    ItemsService service = new ItemsService(repository);
    ItemsController control = new ItemsController(service);

    @Test
    void whenItemisAdded_makeSureItReturnsDTO() {
        ItemCreaterDTO itemCreaterDTO = new ItemCreaterDTO("Banana", "yellow", 0.9, 10);
        Assertions.assertThat(control.addNewItem(itemCreaterDTO)).isInstanceOf(ItemDTO.class);
    }

    @Test
    void whenOneItemIsInRepository_addNewItem_makeSureSizeOfRepositoryIsTwo() {
        //Given
        ItemCreaterDTO itemCreaterDTO = new ItemCreaterDTO("Banana", "yellow", 0.9, 10);
        ItemCreaterDTO secondItem = new ItemCreaterDTO("Grape", "round", 1.1, 5);
        control.addNewItem(itemCreaterDTO);
        //When
        control.addNewItem(secondItem);
        // Then
        Assertions.assertThat(repository.getSizeOfMap()).isEqualTo(2);
    }

    @Test
    void whenOneItemIsInRepository_addNewItemWithSameName_makeSureReturnsException() {
        //Given
        ItemCreaterDTO itemCreaterDTO = new ItemCreaterDTO("Banana", "yellow", 0.9, 10);
        ItemCreaterDTO secondItem = new ItemCreaterDTO("Banana", "round", 1.1, 5);
        control.addNewItem(itemCreaterDTO);
        // Then
        Assertions.assertThatThrownBy(()->control.addNewItem(secondItem)).hasMessage("There is allready a Banana item in our stock");
        Assertions.assertThat(repository.getAmountOfGivenItem("Banana")).isEqualTo(10);  // not sure he even gets there
    }


}