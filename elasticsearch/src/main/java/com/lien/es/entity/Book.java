package com.lien.es.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Book {

    private String number;

    private Double price;

    private String title;

    private String province;

    private Date publishTime;

    public String toString(){
        return this.number + " " + this.title + "" +
                this.price + " " + this.province + " " + this.publishTime;
    }
}
