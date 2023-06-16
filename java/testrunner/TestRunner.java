package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

    @CucumberOptions(
            features = "src/main/java/features",
            glue=("stepdefinition")
    )
    public class TestRunner extends AbstractTestNGCucumberTests{


    }
