package org.sensyne;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"classpath:features"},
        glue = "org.sensyne.steps",
        plugin = {"html:target/cucumber-html/report.html"})
public class TestRunner {
}
