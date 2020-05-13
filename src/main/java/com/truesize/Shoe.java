package com.truesize;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Shoe {

    private @Id
    @GeneratedValue long id;
    
    public String model;
    public String sex;
    public double size;

    private Shoe() {}


    @Override
    public int hashCode() {
        return Objects.hash(id, model, sex, size);
    }
    
    public Shoe(String model, String sex, double size) {
        this.model = model;
        this.sex = sex;
        this.size = size;
    }
    @Override
    public String toString() {
        return "shoe";
    }
}