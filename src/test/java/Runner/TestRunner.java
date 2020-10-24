package Runner;
//import org.junit.runner.RunWith;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = "classpath:features",
		glue = "Stepdefs",
		tags = "",
		plugin = {"pretty", // to generate reports
	            "html:target/html/",
	            "json:target/json/file.json"},
	         publish = true,
	         dryRun = false)
	         
public class TestRunner{}
		  
