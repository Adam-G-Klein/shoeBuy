package com.truesize.shoegraph;

import javax.persistence.*;

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

    private String sex;
    private String model;
    private String brand;
    private String imgURL;

    //the uniqueShoeCode is a string combining the model + brand + sex of the show (lowercase, no spaces)
    private String uniqueShoeCode;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "edges", referencedColumnName = "id")
    private List<DirectedShoeEdge> edges;

    private ShoeNode() { }

    public ShoeNode(String model, String brand, String sex, String imgURL){
        this.model = model.toLowerCase();
        this.brand = brand.toLowerCase();
        this.sex = sex.toLowerCase();
        this.uniqueShoeCode = generateUniqueCode(this.model, this.brand, this.sex);
        this.edges = new ArrayList<>();
        this.imgURL = imgURL;
    }

    public ShoeNode(String model, String brand, String sex){
        this(model, brand, sex, "URL");
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

    public String getUniqueShoeCode() {
        return uniqueShoeCode;
    }

    public static String generateUniqueCode(String model, String brand, String sex) {
        return model.toLowerCase() + brand.toLowerCase() + sex.toLowerCase();
    }

    public DirectedShoeEdge findEdgeWithCode(String code){
        for(DirectedShoeEdge e : edges) {
            if(e.endShoeNode.uniqueShoeCode.equals(code)) {
                return e;
            }
        }
        return null;
    }
    public List<DirectedShoeEdge> getEdges() {
        return edges;
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
            matchingEdge.setSizeDifference((matchingEdge.getSizeDifference() * matchingEdge.getConnectionMultiplicity() + sizeDifference)/(matchingEdge.getConnectionMultiplicity() + 1));
            matchingEdge.setConnectionMultiplicity(matchingEdge.getConnectionMultiplicity() + 1);
            
            //prevent addEdge from infinitly looping back and forth from start to end Node
            if(!isEndShoe){ shoeConnection.addEdgeBothWays(this, sizeDifference * -1, true); }
        }
        //otherwise, add it
        else{
            DirectedShoeEdge edge = new DirectedShoeEdge(1, sizeDifference, shoeConnection);

            //prevent addEdge from infinitely looping back and forth from start to end Node
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
                return e.getSizeDifference();
            }
        }
        return null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoeNode shoeNode = (ShoeNode) o;
        return Objects.equals(sex, shoeNode.sex) &&
                Objects.equals(model, shoeNode.model) &&
                Objects.equals(brand, shoeNode.brand) &&
                Objects.equals(imgURL, shoeNode.imgURL) &&
                Objects.equals(uniqueShoeCode, shoeNode.uniqueShoeCode);
    }

    @Override
    public String toString() {
        return "ShoeNode";
    }
}
