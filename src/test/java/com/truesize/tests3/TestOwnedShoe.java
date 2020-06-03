package com.truesize.tests3;

import com.truesize.OwnedShoe;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestOwnedShoe {

    @Test
    public void testConstructor() {
        OwnedShoe testShoe = new OwnedShoe("T1a", "Adidas", 500.0, "f", "https://fakeurl.com");
        assert(testShoe.getShoeImgURL().equals("https://fakeurl.com"));
    }

    @Test
    public void testToString() {
        OwnedShoe testShoe = new OwnedShoe("T1a", "Adidas", 500.0, "f", "https://fakerurl.com");
        assert(testShoe.toString().contains("500.0"));

    }




}
