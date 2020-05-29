package com.truesize;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;
import java.util.ArrayList;
import javax.persistence.Table;

@Entity
@Table(name = "ownedShoes")
public class OwnedShoe {

    private @Id
    @GeneratedValue long id;
    public String model;
    public String brand;
    public Double size;
    public String sex;
    // private Double width;
    // private Double stiffness;
    // private String comment;

    private OwnedShoe() {}
    
    //public OwnedShoe(String model, String brand, Double size, String sex, Double width, Double stiffness, String comment){
    public OwnedShoe(String model, String brand, Double size, String sex){
        this.model = model;
        this.brand = brand;
        this.size = size;
        this.sex = sex;
        //this.width = width;
        //this.stiffness = stiffness;
        //this.comment = comment;

    }

    public OwnedShoe(String model, Double size){
        this.model = model;
        this.brand = "obviously nike";
        this.size = size;
        this.sex = "unisex";
        // this.width = 23423.0;
        // this.stiffness = 42.0;
        // this.comments = new ArrayList<String>();

    }

    @Override
    public int hashCode() {

        return Objects.hash(id, model, brand, size);
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "OwnedShoe{" +
                "id=" + id +
                ", model=" + model +
                ", brand=" + brand +
                ", size=" + size +
                ", sex=" + sex +
                + '}';
    }
}
