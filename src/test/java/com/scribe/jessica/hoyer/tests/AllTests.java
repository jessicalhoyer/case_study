package com.scribe.jessica.hoyer.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

@RunWith(Suite.class)
@SuiteClasses({ DocumentServiceTest.class, FolderServiceTest.class, UserServiceTest.class })
public class AllTests {
	
	public class TestRunner {
		
		public void main(String[] args) {
			Result result = JUnitCore.runClasses(SuiteClasses.class);
			
			for (Failure failure : result.getFailures()) {
				System.out.println(failure.toString());
			}
			
			System.out.println(result.wasSuccessful());
		}
	}

}
