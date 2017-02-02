package utils;

import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;

public class CustomReporter implements IReporter{

	@Override
	public void generateReport(List<XmlSuite> XmlSuites, List<ISuite> suites, String outputDirectory) {
		// TODO Auto-generated method stub
		//Iterating over each suite included in the test
		for(ISuite suite: suites){
			
			//Following code gets the suite name
			String suiteName = suite.getName();
			//Getting the results for the above suite
			@SuppressWarnings("rawtypes")
			Map suiteResults = suite.getResults();
			for (Object sr : suiteResults.values()) {
		        ITestContext tc = ((ISuiteResult) sr).getTestContext();
		        System.out.println("Passed tests for suite '" + suiteName +
		             "' is:" + tc.getPassedTests().getAllResults().size());
		        System.out.println("Failed tests for suite '" + suiteName +
		             "' is:" + 
		             tc.getFailedTests().getAllResults().size());
		        System.out.println("Skipped tests for suite '" + suiteName +
		             "' is:" + 
		             tc.getSkippedTests().getAllResults().size());
		 
					
				}
		}
	}

	
}
