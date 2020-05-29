package com.truesize;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;

@Entity
@Table(name = "UserProfile")
public class UserProfile {

    private @Id String email;
    private String name;
    private String password;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ownedShoes", referencedColumnName = "email")
    public List<OwnedShoe> ownedShoes;

    private UserProfile() {}

    public UserProfile(String email, String password){
        this.email = email;
        this.password = password;
        this.ownedShoes = new ArrayList();
        ownedShoes.add(new OwnedShoe("NikeKD9", 17.5));
        ownedShoes.add(new OwnedShoe("NikeKD3000", 17.5));
        ownedShoes.add(new OwnedShoe("NikeHotDog", 400.5));
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // public String shoesToString(){
    //     String temp = "";
    //     for (OwnedShoe shoe: shoes){
    //         temp += shoe.toString();
    //     }
    //     return temp;
    // }

    @Override
    public String toString() {
        return "UserProfile{" +
                "name=" + name +
                ", email=" + email +
                ", password=" + password +'}';
    }
}


//+ "shoes=" + shoesToString() +


