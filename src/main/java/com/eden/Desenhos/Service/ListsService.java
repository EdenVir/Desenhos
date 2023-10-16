package com.eden.Desenhos.Service;


import com.eden.Desenhos.Entity.Lists;
import com.eden.Desenhos.Repository.ListsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListsService {

    @Autowired
    private ListsRepository listsRepository;

    public List<Lists> getAllLists() {
        return listsRepository.findAll();
    }

    public Lists createLists(Lists lists){
        return listsRepository.save(lists);
    }

}
