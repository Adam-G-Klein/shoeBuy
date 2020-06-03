package com.truesize.tests2;

import com.truesize.shoegraph.AllShoeRepository;
import com.truesize.shoegraph.ShoeNode;
import com.truesize.shoegraph.ShoeSizeRecommendSearcherBFS;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestShoeRecommendLoops {

    private static final String ADIDAS = "ADIDAS";
    private static final String F = "f";

    @Autowired
    private AllShoeRepository allShoeRepository;

    private ShoeSizeRecommendSearcherBFS searcher = new ShoeSizeRecommendSearcherBFS();


    @Test
    public void testDoublesAverage() {
        List<Double> testList = new ArrayList<>();

        //test the loop running zero times
        assert(searcher.getDoubleListAverage(testList) == null);

        //test the loop running once
        testList.add(1.5);
        assertEquals(searcher.getDoubleListAverage(testList), 1.5, 0.001);


        //test the loop running twice
        testList.add(0.00);
        assertEquals(searcher.getDoubleListAverage(testList), 0.75, 0.001);


        //test the loop running a typical number of times
        testList.add(2.25);
        testList.add(0.00);
        testList.add(2.00);
        testList.add(4.00);
        testList.add(-2.00);
        assertEquals(searcher.getDoubleListAverage(testList), 1, 0.11);
    }

    @Test
    public void testFindEdgeWithCode() {
        addTestGroup3();
        addTestGroup1();
        addTestGroup2();
        addTestGroup5();

        ShoeNode node;
        //get a test node with no edges,
        // loop runs zero times
        node = allShoeRepository.findByUniqueShoeCode(
                ShoeNode.generateUniqueCode("T8b", "Nike", "f"));
        assert(node.findEdgeWithCode("notacode") == null);


        //get a test node with one edge,
        // loop runs exactly once
        node = allShoeRepository.findByUniqueShoeCode(
                ShoeNode.generateUniqueCode("T7b", ADIDAS, F));
        assert(node.findEdgeWithCode(ShoeNode.generateUniqueCode("T5b", ADIDAS, F)) != null);


        //get a test node with two edges, run function on second edge code added,
        // loop runs exactly twice
        node = allShoeRepository.findByUniqueShoeCode(
                ShoeNode.generateUniqueCode("T2b", ADIDAS, F));
        assert(node.findEdgeWithCode(ShoeNode.generateUniqueCode("T6b", ADIDAS, F)) != null);


        //get a test node with multiple edges, run function on last edge code added,
        // loop runs a typical number of times
        node = allShoeRepository.findByUniqueShoeCode(
                ShoeNode.generateUniqueCode("T1b", ADIDAS, F));
        assert(node.findEdgeWithCode(ShoeNode.generateUniqueCode("T4b", ADIDAS, F)) != null);

    }
    private void addTestGroup1(){
        //---Test Group 1: 2 nodes directly connected---
        ShoeNode testNode = new ShoeNode("KD8", "Nike", "m");
        ShoeNode testNode2 = new ShoeNode("KD9", "Nike", "m");
        testNode.addEdge(testNode2, 10.0, 12.0);
        this.allShoeRepository.save(testNode);
        this.allShoeRepository.save(testNode2);
    }

    private void addTestGroup2(){
        //---Test Group 2: 3 nodes, no cycles---
        ShoeNode t1a = new ShoeNode("T1A", ADIDAS, F, "https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/zc5x1xceepbszkhwprvn/joyride-run-flyknit-mens-running-shoe-PjmR5M.jpg");
        ShoeNode t2a = new ShoeNode("T2A", ADIDAS, F);
        ShoeNode t3a = new ShoeNode("T3A", ADIDAS, F);
        ShoeNode t4a = new ShoeNode("T4A", ADIDAS, F);

        t1a.addEdge(t2a, 10, 11);
        t1a.addEdge(t4a, 10, 11.5);

        t2a.addEdge(t3a, 12.5, 11);

        this.allShoeRepository.save(t1a);
        this.allShoeRepository.save(t2a);
        this.allShoeRepository.save(t3a);
        this.allShoeRepository.save(t4a);
    }



    private void addTestGroup5(){
        ShoeNode t1c = new ShoeNode("KD9", "Nike", "u");
        ShoeNode t2c = new ShoeNode("KD3000", "Nike", "u");
        ShoeNode t3c = new ShoeNode("HotDog", "Nike", "u");

        this.allShoeRepository.save(t1c);
        this.allShoeRepository.save(t2c);
        this.allShoeRepository.save(t3c);
    }
    private void addTestGroup3(){
        //---Test Group 3: 7 nodes, several cycles, size differences may not be consistent bc for test purposes--
        ShoeNode t1b = new ShoeNode("T1b", ADIDAS, F);
        ShoeNode t2b = new ShoeNode("T2b", ADIDAS, F);
        ShoeNode t3b = new ShoeNode("T3b" ,ADIDAS, F);
        ShoeNode t4b = new ShoeNode("T4b" ,ADIDAS, F);
        ShoeNode t5b = new ShoeNode("T5b" ,ADIDAS, F);
        ShoeNode t6b = new ShoeNode("T6b" ,ADIDAS, F);
        ShoeNode t7b = new ShoeNode("T7b" ,ADIDAS, F);
        ShoeNode t8b = new ShoeNode("T8b", "Nike", F);

        t1b.addEdge(t2b, 10, 11);
        t1b.addEdge(t3b, 10, 10);
        t1b.addEdge(t4b, 11, 11.5);

        t2b.addEdge(t6b, 8.5, 9);

        t3b.addEdge(t5b, 12, 13);
        t3b.addEdge(t4b, 13, 19);

        t5b.addEdge(t7b, 12.5, 13);

        t6b.addEdge(t5b, 10, 9.5);

        this.allShoeRepository.save(t1b);
        this.allShoeRepository.save(t2b);
        this.allShoeRepository.save(t3b);
        this.allShoeRepository.save(t4b);
        this.allShoeRepository.save(t5b);
        this.allShoeRepository.save(t6b);
        this.allShoeRepository.save(t7b);
        this.allShoeRepository.save(t8b);
    }

}
