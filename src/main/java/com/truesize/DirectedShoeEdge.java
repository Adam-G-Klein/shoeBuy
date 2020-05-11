package com.truesize;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class DirectedShoeEdge {
    
    private @Id
    @GeneratedValue long id;

    public int connectionMultiplicity;
	public double sizeDifference;
	public ShoeNode startShoeNode;
    public ShoeNode endShoeNode;


    public DirectedShoeEdge(int connectionMultiplicity, double sizeDifference,
                            ShoeNode startShoeNode, ShoeNode endShoeNode){
        this.connectionMultiplicity = connectionMultiplicity;
        this.sizeDifference = sizeDifference;
        this.startShoeNode = startShoeNode;
        this.endShoeNode = endShoeNode;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, connectionMultiplicity, sizeDifference, startShoeNode, endShoeNode);
    }

    @Override
    public String toString() {
        return "DirectedShoeEdge{" +
                "id=" + id +
                ", connectionMultiplicity='" + connectionMultiplicity + '\'' +
                ", sizeDifference=" + sizeDifference +
                ", startShoeNode='" + startShoeNode + '\'' +
                ", endShoeNode='" + endShoeNode + '\'' +
                '}';
    }
}