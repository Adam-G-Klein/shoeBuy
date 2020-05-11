package com.truesize;

import javax.persistence.Entity;

@Entity
public class Shoe {

    public String model;
    public String sex;
    public double size;

    public Shoe(String model, String sex, double size) {
        this.model = model;
        this.sex = sex;
        this.size = size;
    }

}