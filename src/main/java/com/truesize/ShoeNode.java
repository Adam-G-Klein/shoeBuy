package com.truesize;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import java.util.List;
import java.util.Objects;

@Entity
public class ShoeNode {

    private @Id
    @GeneratedValue long id;

    @OneToOne
    public Shoe shoe;

    @OneToMany
    private List<DirectedShoeEdge> edges;

    private ShoeNode() { }

    public ShoeNode(String model, String sex, double size, List<DirectedShoeEdge> edges){
        this.shoe = new Shoe(model, sex, size);
        this.edges = edges;
    }

    public void addEdge() {
        //TODO: this should add a directed shoe edge to edges, and also
        //add a directed shoe edge in the endPoint shoe node back to this one.
    }

    public List<DirectedShoeEdge> getEdges(){
        return edges;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, shoe);
    }

    @Override
    public String toString() {
        return "ShoeNode{" +
                "id=" + id +
                ", shoe='" + shoe + '\'' +
                ", edges=" + edges +
                '}';
    }
}