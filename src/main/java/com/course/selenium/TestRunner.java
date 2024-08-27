package com.course.selenium;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//Uruchomienie przez runner generuje report.html
// czasami       glue={"stepDefinitions"}, dodac folder gdy test/Step Definitions
// bo stepy tutaj kladziemy w java a nie w test wiec widzi
//Step Definition musi byc w name pacgage np. pl.coderslab
@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/",
    plugin = {"pretty", "html:report.html"}
)
public class TestRunner {
}
