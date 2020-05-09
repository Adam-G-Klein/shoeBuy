package com.truesize;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class UserShoe {

    private @Id
    @GeneratedValue long id;
    private String modelName;
    private Double size;

    private UserShoe() {}

    public UserShoe(String modelName, Double size){
        this.modelName = modelName;
        this.size = size;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, modelName,size);
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    @Override
    public String toString() {
        return "UserShoe{" +
                "id=" + id +
                ", modelName='" + modelName + '\'' +
                ", size=" + size +
                '}';
    }
}
