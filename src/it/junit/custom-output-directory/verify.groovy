import org.junit.Assert

import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace

File buildDirectory = new File(basedir, "target");

File suite01 = new File(basedir, "target/generated-test-sources/cucumber/Parallel01IT.java")
File suite02 = new File(basedir, "target/generated-test-sources/cucumber/Parallel02IT.java")

File feature1 = new File(basedir, "/src/test/resources/features/feature1.feature")
File feature2 = new File(basedir, "/src/test/resources/features/feature2.feature")

assert suite01.isFile()
assert suite02.isFile()

String expected01 =
        """import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
      
        features = {"${feature1.absolutePath}"},
        plugin = {"json:${buildDirectory.absolutePath}/my-custom-dir/1.json"},
        monochrome = false,
        tags = {},
        glue = {"foo", "bar"})
public class Parallel01IT {
}"""

String expected02 =
        """import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"${feature2.absolutePath}"},
        plugin = {"json:${buildDirectory.absolutePath}/my-custom-dir/2.json"},
        monochrome = false,
        tags = {},
        glue = {"foo", "bar"})
public class Parallel02IT {
}"""

Assert.assertThat(suite01.text, equalToIgnoringWhiteSpace(expected01))
Assert.assertThat(suite02.text, equalToIgnoringWhiteSpace(expected02))

