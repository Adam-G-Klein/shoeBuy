package com.truesize;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import com.truesize.tests1.TestStartupAndHomeController;
import com.truesize.tests2.TestShoeRecommendAndShoeSearch;
import com.truesize.tests3.TestShoeEdgeAndOwnedShoe;
import com.truesize.tests4.TestAccountService;
import com.truesize.tests5.TestUserController;


@RunWith(Suite.class)
@SuiteClasses({ TestUserController.class, TestStartupAndHomeController.class, TestAccountService.class, TestShoeEdgeAndOwnedShoe.class, TestShoeRecommendAndShoeSearch.class })
public class AllTests {

}
