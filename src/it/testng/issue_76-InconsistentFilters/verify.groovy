import org.junit.Assert

import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace

File buildDirectory = new File(basedir, "target");

File suite01 = new File(basedir, "target/generated-test-sources/cucumber/Parallel01IT.java");
File suite02 = new File(basedir, "target/generated-test-sources/cucumber/Parallel02IT.java");

File feature1 = new File(basedir, "/src/test/resources/features/feature1.feature");
File feature2 = new File(basedir, "/src/test/resources/features/feature2.feature");

assert suite01.isFile()
assert suite02.isFile()

String expected01 =
        """
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
    
        features = {"${feature1.absolutePath}:4"},
        plugin = {"json:${buildDirectory.absolutePath}/cucumber-parallel/1.json"},
        monochrome = false,
        glue = {"foo", "bar"})
public class Parallel01IT extends AbstractTestNGCucumberTests {
}"""

String expected02 =
        """
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"${feature2.absolutePath}:4"},
        plugin = {"json:${buildDirectory.absolutePath}/cucumber-parallel/2.json"},
        monochrome = false,
        glue = {"foo", "bar"})
public class Parallel02IT extends AbstractTestNGCucumberTests {
}"""
Assert.assertThat(suite01.text, equalToIgnoringWhiteSpace(expected01))
Assert.assertThat(suite02.text, equalToIgnoringWhiteSpace(expected02))
