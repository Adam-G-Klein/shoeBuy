package com.truesize.shoegraph;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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


    public String sex;
    public String model;
    public String brand;

    //the uniqueShoeCode is a string combining the model + brand + sex of the show (lowercase, no spaces)
    public String uniqueShoeCode;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "edges", referencedColumnName = "id")
    private List<DirectedShoeEdge> edges;

    private ShoeNode() { }

    public ShoeNode(String model, String brand, String sex, double size){
        this.model = model.toLowerCase();
        this.brand = brand.toLowerCase();
        this.sex = sex.toLowerCase();
        this.uniqueShoeCode = generateUniqueCode(this.model, this.brand, this.sex);
        this.edges = new ArrayList();
    }

    public static String generateUniqueCode(String model, String brand, String sex) {
        return model.toLowerCase() + brand.toLowerCase() + sex.toLowerCase();
    }

    //when calling 'addEdge' from anywhere, 'endShoe' should always be false in order to add edge in both directions  
    public void addEdge(ShoeNode shoeConnection, double sizeDifference, boolean endShoe) {

        DirectedShoeEdge edge = new DirectedShoeEdge(1, sizeDifference, this, shoeConnection);

        //prevent addEdge from infinitly looping back and forth from start to end Node
        if(!endShoe){ shoeConnection.addEdge(this, sizeDifference * -1, true); }

        this.edges.add(edge);
    }

    //returns null if shoe isn't found, otherwise the size difference
    public Double getImmediateSizeDiff(String shoeCode){

        for(DirectedShoeEdge e : this.edges) {
            String endShoeCode = e.endShoeNode.uniqueShoeCode;
            if(endShoeCode.equals(shoeCode)){
                return e.sizeDifference;
            }
        }
        return null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ShoeNode";
    }
}