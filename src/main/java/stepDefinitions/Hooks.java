package stepDefinitions;

import contextManagers.TestContext;

import cucumber.api.java.After;
import cucumber.api.java.Before;
;

public class Hooks {

    private TestContext testContext;

    public Hooks(TestContext context){
        testContext=context;
    }

    @Before
    public void setUpBeforeEachTest(){
        testContext.getWebDriverManager().getDriver();
        System.out.println("The test case is started");
    }
    @After
    public void tearDownAfterEachTest(){
        testContext.getWebDriverManager().getDriver().close();
        System.out.println("The test case is finished");
    }


}
