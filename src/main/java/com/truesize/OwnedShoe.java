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
    private String model;
    private String brand;
    private Double size;
    private String sex;
    private String imgURL;

    private OwnedShoe() {}
    
    public OwnedShoe(String model, String brand, Double size, String sex, String imgURL){
        this.model = model.toLowerCase();
        this.brand = brand.toLowerCase();
        this.size = size;
        this.sex = sex.toLowerCase();
        this.imgURL = imgURL;
    }

    public OwnedShoe(String model, Double size){
        this.model = model;
        this.brand = "nike";
        this.size = size;
        this.sex = "u";
        this.imgURL = "https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/zc5x1xceepbszkhwprvn/joyride-run-flyknit-mens-running-shoe-PjmR5M.jpg";
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

    public String getSex() {
        return sex;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
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
