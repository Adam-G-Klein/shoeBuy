package com.truesize;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;
import java.util.ArrayList;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "ownedShoes")
public class OwnedShoe {

    @Id
    @GeneratedValue 
    @Column(name = "id")
    private long id;
    public String model;
    public String brand;
    public Double size;
    public String sex;
    public String imgURL;
    // private Double width;
    // private Double stiffness;
    // private String comment;

    private OwnedShoe() {}
    
    //public OwnedShoe(String model, String brand, Double size, String sex, Double width, Double stiffness, String comment){
    public OwnedShoe(String model, String brand, Double size, String sex, String imgURL){
        this.model = model.toLowerCase();
        this.brand = brand.toLowerCase();
        this.size = size;
        this.sex = sex.toLowerCase();
        this.imgURL = imgURL;
        //this.width = width;
        //this.stiffness = stiffness;
        //this.comment = comment;

    }

    public OwnedShoe(String model, Double size){
        this.model = model;
        this.brand = "nike";
        this.size = size;
        this.sex = "u";
        this.imgURL = "https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/zc5x1xceepbszkhwprvn/joyride-run-flyknit-mens-running-shoe-PjmR5M.jpg";
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
                ", imgURL=" + imgURL +
                '}';
    }
}
