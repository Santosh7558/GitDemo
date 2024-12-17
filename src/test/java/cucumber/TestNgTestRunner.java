package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "C://Users//home//IdeaProjects//SeleniumFrameWorkDesign//src//test//java//cucumber//StandAlone.feature",
        glue = "rahulshettyacademy.stepDefintions",monochrome = true,
plugin = {"html:target/cucumber.html"})
public class TestNgTestRunner extends AbstractTestNGCucumberTests {


}
