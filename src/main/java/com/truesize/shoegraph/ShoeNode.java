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

    public ShoeNode(String model, String brand, String sex){
        this.model = model.toLowerCase();
        this.brand = brand.toLowerCase();
        this.sex = sex.toLowerCase();
        this.uniqueShoeCode = generateUniqueCode(this.model, this.brand, this.sex);
        this.edges = new ArrayList();
    }

    public static String generateUniqueCode(String model, String brand, String sex) {
        return model.toLowerCase() + brand.toLowerCase() + sex.toLowerCase();
    }

    private DirectedShoeEdge findEdgeWithCode(String code){
        for(DirectedShoeEdge e : edges) {
            if(e.endShoeNode.uniqueShoeCode.equals(code)) {
                return e;
            }
        }
        return null;
    }

    public void addEdge(ShoeNode shoeConnection, double thisShoeSize, double secondShoeSize)
    {
        double sizeDifference = secondShoeSize - thisShoeSize;

        //the last boolean ensure that this function in run for both shoe nodes and doesn't loop endlessly
        addEdgeBothWays(shoeConnection, sizeDifference, false);
    }
    private void addEdgeBothWays(ShoeNode shoeConnection, double sizeDifference, boolean isEndShoe) {

        DirectedShoeEdge matchingEdge = findEdgeWithCode(shoeConnection.uniqueShoeCode);

        //if this edge already exists, modify it
        if(matchingEdge != null){
            matchingEdge.sizeDifference = (matchingEdge.sizeDifference * matchingEdge.connectionMultiplicity + sizeDifference)/(matchingEdge.connectionMultiplicity + 1);
            matchingEdge.connectionMultiplicity += 1;
            
            //prevent addEdge from infinitly looping back and forth from start to end Node
            if(!isEndShoe){ shoeConnection.addEdgeBothWays(this, sizeDifference * -1, true); }
        }
        //otherwise, add it
        else{
            DirectedShoeEdge edge = new DirectedShoeEdge(1, sizeDifference, shoeConnection);

            //prevent addEdge from infinitly looping back and forth from start to end Node
            if(!isEndShoe){ shoeConnection.addEdgeBothWays(this, sizeDifference * -1, true); }
    
            this.edges.add(edge);
        } 
    }
    public List<String> getEdgesAsShoeCodes(){
        List<String> edgesAsCodes = new ArrayList<>();
        for(DirectedShoeEdge e : edges) {
            edgesAsCodes.add(e.endShoeNode.uniqueShoeCode);
        }
        return edgesAsCodes;
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