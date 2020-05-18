package com.truesize;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "shoes")
public class Shoe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
 
    @OneToOne(mappedBy = "shoe", cascade = CascadeType.ALL)
    private ShoeNode shoeNode;
    
    public String brand;
    public String model;
    public String sex;

    private Shoe() {}


    @Override
    public int hashCode() {
        return Objects.hash(id, model, sex);
    }
    
    public Shoe(String model, String brand, String sex) {
        this.model = model;
        this.brand = brand;
        this.sex = sex;
    }
    @Override
    public String toString() {
        return "shoe";
    }

    // Overriding equals() to compare two Complex objects 
    @Override
    public boolean equals(Object o) { 
  
        // If the object is compared with itself then return true   
        if (o == this) { 
            return true; 
        } 
  
        /* Check if o is an instance of Complex or not 
          "null instanceof [type]" also returns false */
        if (!(o instanceof Shoe)) { 
            return false; 
        } 
          
        // typecast o to Complex so that we can compare data members  
        Shoe c = (Shoe) o; 
          
        // Compare the data members and return accordingly  
        return brand.equals(c.brand) && sex.equals(c.sex) && model.equals(c.model); 
    } 
}