package com.eden.Desenhos.Controller;


import com.eden.Desenhos.Entity.Item;
import com.eden.Desenhos.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/../Item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public List<Item> getAllItems(){
        return itemService.getAllItems();
    }

    @PostMapping
    public Item createItem(@RequestBody Item item){
        return itemService.createItem(item);

    }

    @GetMapping("drawItem/{list_Id}")
    public Item drawItem(@PathVariable Long list_id){
        return itemService.drawItem(list_id);
    }
}
