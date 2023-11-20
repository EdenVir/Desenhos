package com.eden.Desenhos.controllerTest;

import com.eden.Desenhos.Controller.ListsController;
import com.eden.Desenhos.Entity.Lists;
import com.eden.Desenhos.Service.ListsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class ListsControllerTest {

    @Mock
    private ListsService listsService;

    @InjectMocks
    private ListsController listsController;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

  @Test
    void createLists_Success(){
        Lists mockLists = new Lists();
        mockLists.setId(4);
        mockLists.setName("Anime");
        mockLists.setItems(new ArrayList<>());

        when(listsService.createLists(any(Lists.class))).thenReturn(mockLists);

        Lists result = listsController.createLists(new Lists());

        verify (listsService, times(1)).createLists(any());
        assertEquals (mockLists,result);

  }
}
