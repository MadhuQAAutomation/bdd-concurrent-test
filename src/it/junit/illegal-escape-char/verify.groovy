import org.junit.Assert

import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace

File buildDirectory = new File(basedir, "target");

File suite01 = new File(basedir, "target/generated-test-sources/cucumber/Parallel01IT.java");

File feature = new File(basedir, "/src/test/resources/features/feature1.feature");

assert suite01.isFile()

String expected01 =
        """import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
       features = {"${feature.absolutePath}"},
        plugin = {"json:${buildDirectory.absolutePath}/cucumber-reports/1.json"},
        monochrome = false,
        tags = {},
        glue = {"foo", "bar"})
public class Parallel01IT {
}"""

Assert.assertThat(suite01.text, equalToIgnoringWhiteSpace(expected01))
