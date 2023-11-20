package com.eden.Desenhos.serviceTest;

import com.eden.Desenhos.Entity.Lists;
import com.eden.Desenhos.Repository.ListsRepository;
import com.eden.Desenhos.Service.ListsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
public class listsServiceTest {

    @Mock
    private ListsRepository listsRepository;

    @InjectMocks
    private ListsService listsService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createLists_Success(){

        when(listsRepository.count()).thenReturn(1L);

        Lists newLists = new Lists();

        listsService.createLists(newLists);

        verify(listsRepository, times(1)).save(newLists);

    }

    @Test
    void createLists_Failure(){

        when(listsRepository.count()).thenReturn(2L);

        Lists newLists = new Lists();

        assertThrows(RuntimeException.class, () -> listsService.createLists(newLists));

        verify(listsRepository, never()).save(newLists);

    }
}
