package com.example.carg.model;

//
//import lombok.Data;
//
//import javax.persistence.*;
//@Data
//@Entity
//
//
//public class Category {
//    @Id
//    @GeneratedValue(strategy= GenerationType.AUTO)
//    @Column(name="category_id")
//    private int id;
//    private String name;
//
//
//}




import lombok.Data;

import javax.persistence.*;

@Entity
@Data

public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="category_id")
    private int id;
    private String name;

}
