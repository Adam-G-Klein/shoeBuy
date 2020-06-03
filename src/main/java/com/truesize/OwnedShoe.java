package com.truesize;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "ownedShoes")
public class OwnedShoe {

    @Id
    @GeneratedValue 
    @Column(name = "id")
    private long id;
    private String shoeModel;
    private String shoeBrand;
    private Double shoeSize;
    private String shoeSex;
    private String shoeImgURL;

    private OwnedShoe() {}
    
    public OwnedShoe(String model, String brand, Double size, String sex, String imgURL){
        this.shoeModel = model.toLowerCase();
        this.shoeBrand = brand.toLowerCase();
        this.shoeSize = size;
        this.shoeSex = sex.toLowerCase();
        this.shoeImgURL = imgURL;
    }

    public OwnedShoe(String model, Double size){
        this(model, "nike", size, "u", "https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/zc5x1xceepbszkhwprvn/joyride-run-flyknit-mens-running-shoe-PjmR5M.jpg");
    }

    public Double getShoeSize() {return shoeSize;}

    public void setShoeSize(Double size) {this.shoeSize = size;}

    public String getShoeSex() {return shoeSex;}

    public String getShoeModel() {return shoeModel;}

    public String getShoeBrand() {return shoeBrand;}

    public String getShoeImgURL() {return shoeImgURL;}

    public void setShoeImgURL(String imgURL) {this.shoeImgURL = imgURL;}

    @Override
    public String toString() {
        return "OwnedShoe{" +
                "id=" + id +
                ", model=" + shoeModel +
                ", brand=" + shoeBrand +
                ", size=" + shoeSize +
                ", sex=" + shoeSex +
                ", imgURL=" + shoeImgURL +
                '}';
    }
}
