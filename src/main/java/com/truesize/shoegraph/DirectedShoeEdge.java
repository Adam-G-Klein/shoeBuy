package com.truesize.shoegraph;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DirectedShoeEdge {
    
    private @Id
    @GeneratedValue long id;

    private int connectionMultiplicity;
    private double sizeDifference;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "end_shoenode_id", referencedColumnName = "id")
    public ShoeNode endShoeNode;

    private DirectedShoeEdge() {}

    public DirectedShoeEdge(int connectionMultiplicity, double sizeDifference,
                            ShoeNode endShoeNode){
        this.connectionMultiplicity = connectionMultiplicity;
        this.sizeDifference = sizeDifference;
        this.endShoeNode = endShoeNode;
    }
  
    public double getSizeDifference() {
        return sizeDifference;
    }
    public void setSizeDifference(double num) {
        this.sizeDifference = num;
    }
    public int getConnectionMultiplicity() {
        return connectionMultiplicity;
    }
    public void setConnectionMultiplicity(int num) {
        this.connectionMultiplicity = num;
    }

    @Override
    public String toString() {
        return "DirectedShoeEdge{" +
                "id=" + id +
                ", connectionMultiplicity='" + connectionMultiplicity + '\'' +
                ", sizeDifference=" + sizeDifference +
                ", endShoeNode='" + endShoeNode + '\'' +
                '}';
    }
}