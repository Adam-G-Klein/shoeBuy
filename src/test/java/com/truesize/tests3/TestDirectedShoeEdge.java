package com.truesize.tests3;

import com.truesize.shoegraph.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDirectedShoeEdge {

    @Autowired
    private AllShoeRepository allShoeRepository;

    private static final String ADIDAS = "ADIDAS";
    private static final String F = "f";

    @Test
    public void testConstructor() {
        ShoeNode sn = allShoeRepository.findByUniqueShoeCode(
                ShoeNode.generateUniqueCode("T1c", ADIDAS, F));
        DirectedShoeEdge de = new DirectedShoeEdge(3, -2, sn);
        assertEquals(de.getEndShoeNode(), sn);
    }

    @Test
    public void testToString() {
        ShoeNode sn = allShoeRepository.findByUniqueShoeCode(
                ShoeNode.generateUniqueCode("T2c", ADIDAS, F));
        DirectedShoeEdge de = new DirectedShoeEdge(3, -2, sn);
        assert(de.toString().contains("-2"));
    }

    private void addTestGroup(){
        //---Test Group 4: testing edge changes when add multiple shoe nodes that increase edge's multiplicity---
        ShoeNode t1c = new ShoeNode("T1c",ADIDAS, F);
        ShoeNode t2c = new ShoeNode("T2c",ADIDAS, F);
        ShoeNode t3c = new ShoeNode("T3c",ADIDAS, F);

        t1c.addEdge(t2c, 10.0, 9.0);
        t1c.addEdge(t2c, 10.0, 9.5);

        t2c.addEdge(t3c, 9.0, 8.5);
        this.allShoeRepository.save(t1c);
        this.allShoeRepository.save(t2c);
        this.allShoeRepository.save(t3c);
    }
}
