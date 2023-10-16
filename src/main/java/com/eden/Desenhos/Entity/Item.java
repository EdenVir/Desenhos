package com.eden.Desenhos.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String Name;

    @ManyToOne
    @JoinColumn(name = "lists_id")
    private Lists lists;

}
