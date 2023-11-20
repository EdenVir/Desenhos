package com.eden.Desenhos.Service;


import com.eden.Desenhos.Entity.Lists;
import com.eden.Desenhos.Repository.ListsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListsService {


    private final ListsRepository listsRepository;
    @Autowired
    public ListsService(ListsRepository listsRepository) {
        this.listsRepository = listsRepository;
    }

    public List<Lists> getAllLists() {
        return listsRepository.findAll();
    }

    public Lists createLists(Lists lists){
        if (countLists() >=2)
            throw new RuntimeException("Número de máximo de listas atingidas");

        return listsRepository.save(lists);
    }

    private long countLists(){

        return listsRepository.count();
    }

    public boolean deleteLists(Long id){
        if(listsRepository.existsById(id)){
            listsRepository.deleteById(id);
            return true;
        }else {
            return false;
        }

    }

}
