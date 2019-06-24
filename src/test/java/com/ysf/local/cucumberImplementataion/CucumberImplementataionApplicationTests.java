package com.ysf.local.cucumberImplementataion;

import org.junit.runner.RunWith;

import com.ysf.local.cucumberImplementataion.config.LocalDateConverter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.deps.com.thoughtworks.xstream.annotations.XStreamConverter;
import cucumber.deps.com.thoughtworks.xstream.annotations.XStreamConverters;

@RunWith(Cucumber.class)
@CucumberOptions(
		 strict = true, //will fail if they are undefined or pending steps
		 //dryRun = true ,//checks that every Step mentioned in the Feature File
		 plugin = {"pretty","html:target/cucumber"},
		 tags = {"@Account" },
		 monochrome=true,//for readeable output
		 features = {"src/test/ressources/features"},//the paths to the feature
		 glue = "com.ysf.local"//path to stepDef
		)
@XStreamConverters(@XStreamConverter(LocalDateConverter.class))
public class CucumberImplementataionApplicationTests {

}
