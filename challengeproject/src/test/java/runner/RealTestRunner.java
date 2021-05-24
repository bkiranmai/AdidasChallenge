package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/resources/features"},
				 monochrome=true,
				 glue={"glue"},
				 plugin={"pretty","html:target\\realtestresults","rerun:target\\realtestfailed.txt"}
				)
public class RealTestRunner
{
}
