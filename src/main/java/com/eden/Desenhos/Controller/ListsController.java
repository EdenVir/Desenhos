package com.eden.Desenhos.Controller;


import com.eden.Desenhos.Entity.Lists;
import com.eden.Desenhos.Service.ListsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Lists")
public class ListsController {


    private final ListsService listsService;
    @Autowired
    public ListsController(ListsService listsService) {
        this.listsService = listsService;
    }

    @PostMapping
    public Lists createLists(@RequestBody Lists lists) {

        return listsService.createLists(lists);
    }

    @GetMapping
    public List<Lists> getAllLists() {
        return listsService.getAllLists();
    }

    @DeleteMapping("/Lists/{id}")
    public ResponseEntity<String> deleteLists(@PathVariable long id) {
        boolean deleted = listsService.deleteLists(id);

        if (deleted) {
            return ResponseEntity.ok("A lista com esse id " + id + " foi deletado.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
