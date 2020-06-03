package com.truesize.Tests2;

import com.truesize.AccountService;
import com.truesize.HomeController;
import com.truesize.shoegraph.ShoeSearchFactory;
import com.truesize.shoegraph.ShoeSizeRecommendSearcherBFS;
import com.truesize.shoegraph.ShoeSizeRecommendSearcherSmartBFS;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestShoeSearchFactory {

    private ShoeSearchFactory searchFactory;

    @Test
    public void testNaiiveBFS () {
        assert(searchFactory.createSearcher("ShoeSizeRecommendSearcherBFS") instanceof ShoeSizeRecommendSearcherBFS);
    }

    @Test
    public void homeIndex() {
        assert(searchFactory.createSearcher("ShoeSizeRecommendSearcherSmartBFS") instanceof ShoeSizeRecommendSearcherSmartBFS);
    }
}
