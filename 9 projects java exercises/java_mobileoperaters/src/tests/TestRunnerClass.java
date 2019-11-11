package tests;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
// select all packages that have tests inside
@SelectPackages("tests") 
public class TestRunnerClass {
}
