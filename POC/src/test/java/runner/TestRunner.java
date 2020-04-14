package runner;

import cucumber.api.CucumberOptions;
@CucumberOptions(
        features = "Features",
        glue = {"stepdefs"},
        tags = {"@abc"},
       plugin = {"pretty", "html:target/cucumber_target.html", "json:target/cucumber.json"})
   //  plugin={“com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html”},
      //  monochrome = true)
public class TestRunner  {

}

