package com.truesize;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "shoenodes")
public class ShoeNode {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shoe_id", referencedColumnName = "id")
    private Shoe shoe;
    private String model;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "edges", referencedColumnName = "id")
    private List<DirectedShoeEdge> edges;

    private ShoeNode() { }

    public ShoeNode(String model, String brand, String sex, double size){
        this.model = model;
        this.shoe = new Shoe(model, brand, sex);
        this.edges = new ArrayList();
    }
    public String getModel(){
        return model;
    }
    public Shoe getShoe() {
        return shoe;
    }
    public void addEdge(ShoeNode shoeConnection, double sizeDifference, boolean endShoe) {

        DirectedShoeEdge edge = new DirectedShoeEdge(1, sizeDifference, this, shoeConnection);
        if(!endShoe){
            shoeConnection.addEdge(this, sizeDifference * -1, true);
        }
        
        this.edges.add(edge);
    }
    public double getImmediateSizeDiff(Shoe shoe){
        String model = shoe.model;
        String brand = shoe.brand;
        String sex = shoe.sex;
        for(DirectedShoeEdge e : this.edges) {
            Shoe endShoeNodeShoe = e.endShoeNode.shoe;
            if(endShoeNodeShoe.model.equals(model) && endShoeNodeShoe.brand.equals(brand) && endShoeNodeShoe.sex.equals(sex)){
                return e.sizeDifference;
            }
        }
        return 0.0;
    }
    public double tester(){
        return 5.9;
    }

    //public List<DirectedShoeEdge> getEdges(){
     //   return edges;
    //}

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ShoeNode";
    }
}