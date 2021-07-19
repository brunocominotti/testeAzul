package Marker;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "D:\\ProjectsIntellij\\src\\test\\java\\Feature", glue = "stepsDefinition")
public class CucumberMarker {
}
