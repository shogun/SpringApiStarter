package com.shn.spr.bookstore;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {

    @Id
    private Long id;

    private String title;

//    @ManyToMany
//    @JoinTable(
//            name="EMP_PROJ",
//            joinColumns=@JoinColumn(name="EMP_ID", referencedColumnName="id"),
//            inverseJoinColumns=@JoinColumn(name="PROJ_ID", referencedColumnName="ID"))
//    private List<Book> books;


}
