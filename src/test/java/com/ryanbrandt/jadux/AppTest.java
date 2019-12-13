package com.ryanbrandt.jadux;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Placeholder to run JUnit tests as Suite
 * 
 * @author Ryan Brandt
 */
@RunWith(Suite.class)
@SuiteClasses({ StoreTest.class, ActionTest.class, ReducerTest.class })
public class AppTest {

}
