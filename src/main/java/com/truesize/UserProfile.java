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
import javax.persistence.FetchType;
import javax.persistence.Column;

@Entity
@Table(name = "UserProfile")
public class UserProfile {

    @Id
    @GeneratedValue 
    @Column(name = "id")
    private long id;
    private String email;
    private String name;
    private String password;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ownedShoes", referencedColumnName = "id")
    //@JoinColumn(name = "ownedShoes", referencedColumnName = "email")
    public List<OwnedShoe> ownedShoes;

    private UserProfile() {}

    public UserProfile(String email, String password){
        this.email = email;
        this.password = password;
        this.ownedShoes = new ArrayList();
        ownedShoes.add(new OwnedShoe("KD9", 17.5));
        ownedShoes.add(new OwnedShoe("KD3000", 17.5));
        ownedShoes.add(new OwnedShoe("HotDog", 400.5));
        ownedShoes.add(new OwnedShoe("t1c","adidas", 12.0, "f", "google.com"));
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

    public List<OwnedShoe> getOwnedShoes() {
        return ownedShoes;
    }

    public String shoesToString(){
        String temp = "OwnedShoes{";
        for (OwnedShoe shoe: ownedShoes){
            temp += shoe.toString()+ '\n';
        }
        temp += "}";
        return temp;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "name=" + name +
                ", email=" + email +
                ", password=" + password +'}';
    }
}


//+ "shoes=" + shoesToString() +



