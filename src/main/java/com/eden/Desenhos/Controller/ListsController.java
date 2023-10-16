package com.eden.Desenhos.Controller;


import com.eden.Desenhos.Entity.Lists;
import com.eden.Desenhos.Service.ListsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/../Lists")
public class ListsController {

    @Autowired
    private ListsService listsService;

    @GetMapping
    public List<Lists> getAllLists() {
        return listsService.getAllLists();
    }

    @PostMapping
    public Lists createLists(@RequestBody Lists lists) {
        return listsService.createLists(lists);
    }


}
