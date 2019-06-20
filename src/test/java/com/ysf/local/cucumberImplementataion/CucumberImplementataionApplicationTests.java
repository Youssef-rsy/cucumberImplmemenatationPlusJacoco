package com.ysf.local.cucumberImplementataion;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		 strict = true, //will fail if they are undefined or pending steps
		 dryRun = true ,//checks that every Step mentioned in the Feature File
		 plugin = {"pretty","html:target/cucumber"},
		 tags = {"~@todo"},
		 monochrome=true,//for readeable output
		 features = {"src/test/ressources/features"},//the paths to the feature
		 glue = {"com.ysf.local.cucumberImplementataion"}//path to stepDef
		)
public class CucumberImplementataionApplicationTests {

}
