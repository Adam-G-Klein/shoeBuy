package com.truesize;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class Shoe {
    private @Id
    @GeneratedValue Long id;
}
