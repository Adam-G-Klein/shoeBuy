package com.truesize;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestUserController.class, TestStartupAndHomeController.class, TestAccountService.class })
public class AllTests {

}
