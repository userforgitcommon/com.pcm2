package sis.pcm.testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "./feature/test2.feature",
    glue = "sis.pcm.stepdefinitions",
    plugin = {
        "pretty",
        "html:test-output/Suite/cucumber.html",
        "json:test-output/Suite/cucumber.json",
        "junit:junit_xml_output/cucumber.xml",
        "html:test-output",
        "json:json_output/cucumber.json",
        "json:./results/cucumber.json",
    },
    dryRun = false,
    monochrome = true,
    strict = false,
    tags = {
        "@SmokeSuite"
    })

public class testrunner {

}