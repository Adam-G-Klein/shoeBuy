package com.truesize.Tests2;

import com.truesize.shoegraph.AllShoeRepository;
import com.truesize.shoegraph.ShoeNode;
import com.truesize.shoegraph.ShoeSearchFactory;
import com.truesize.shoegraph.ShoeSizeRecommendSearcherBFS;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestShoeRecommendLoops {

    @Autowired
    private AllShoeRepository allShoeRepository;

    private ShoeSizeRecommendSearcherBFS searcher = new ShoeSizeRecommendSearcherBFS();

    private ShoeNode node ;

    @Test
    public void testDoublesAverage() {
        List<Double> testList = new ArrayList<>();

        //test the loop running zero times
        assert(searcher.getDoubleListAverage(testList) == null);

        //test the loop running once
        testList.add(new Double(1.5));
        assertEquals(searcher.getDoubleListAverage(testList), 1.5, 0.001);


        //test the loop running twice
        testList.add(new Double(0.00));
        assertEquals(searcher.getDoubleListAverage(testList), 0.75, 0.001);


        //test the loop running a typical number of times
        testList.add(new Double(2.25));
        testList.add(new Double(0.00));
        testList.add(new Double(2.00));
        testList.add(new Double(4.00));
        testList.add(new Double(-2.00));
        assertEquals(searcher.getDoubleListAverage(testList), 1, 0.11);
    }

    @Test
    public void testFindEdgeWithCode() {

        //get a test node with no edges,
        // loop runs zero times
        node = allShoeRepository.findByUniqueShoeCode(
                ShoeNode.generateUniqueCode("T8b", "Nike", "f"));
        assert(node.findEdgeWithCode("notacode") == null);


        //get a test node with one edge,
        // loop runs exactly once
        node = allShoeRepository.findByUniqueShoeCode(
                ShoeNode.generateUniqueCode("T7b", "Adidas", "f"));
        assert(node.findEdgeWithCode(ShoeNode.generateUniqueCode("T5b", "Adidas", "f")) != null);


        //get a test node with two edges, run function on second edge code added,
        // loop runs exactly twice
        node = allShoeRepository.findByUniqueShoeCode(
                ShoeNode.generateUniqueCode("T2b", "Adidas", "f"));
        assert(node.findEdgeWithCode(ShoeNode.generateUniqueCode("T6b", "Adidas", "f")) != null);


        //get a test node with multiple edges, run function on last edge code added,
        // loop runs a typical number of times
        node = allShoeRepository.findByUniqueShoeCode(
                ShoeNode.generateUniqueCode("T1b", "Adidas", "f"));
        assert(node.findEdgeWithCode(ShoeNode.generateUniqueCode("T4b", "Adidas", "f")) != null);

    }

}
