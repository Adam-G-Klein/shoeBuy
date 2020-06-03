package com.truesize.tests3;

import com.truesize.shoegraph.AllShoeRepository;
import com.truesize.shoegraph.DirectedShoeEdge;
import com.truesize.shoegraph.ShoeNode;
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
}
