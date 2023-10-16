package com.eden.Desenhos.Service;



import com.eden.Desenhos.Entity.Item;
import com.eden.Desenhos.Entity.Lists;
import com.eden.Desenhos.Repository.ItemRepository;
import com.eden.Desenhos.Repository.ListsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;


@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ListsRepository listsRepository;

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item createItem(Item item){
        return itemRepository.save(item);
    }

    public Item drawItem (Long list_id) {
        Lists lists = listsRepository.findById(list_id).orElse(null);
        if (lists == null || lists.getItems().isEmpty()) {
            return null;
        }

        List<Item> items = lists.getItems();
        int index = new Random().nextInt(items.size());
        return items.get(index);
    }


}
