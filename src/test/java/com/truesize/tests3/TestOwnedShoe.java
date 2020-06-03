package com.truesize.tests3;

import com.truesize.OwnedShoe;
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
import java.util.Objects;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestOwnedShoe {

    @Test
    public void testConstructor() {

        OwnedShoe testShoe = new OwnedShoe("T1a", "Adidas", 500.0, "f", "https://fakeurl.com");

        //assert();



    }




}
