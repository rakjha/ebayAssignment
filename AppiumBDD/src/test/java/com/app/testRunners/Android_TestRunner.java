package com.app.testRunners;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.app.core.Base;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "./src/test/resources/features/",

		tags = {"@Test111" },

		glue = { "com.app.steps_definitions" },

		plugin = { "json:target/androidOutput/android.json" })

public class Android_TestRunner extends AbstractTestNGCucumberTests {
	
	@Parameters({"platformName","platformVersion","UDID","deviceName"})
	@BeforeClass
	public void setBrowserValue(String platformName, String platformVersion,String UDID,String deviceName) throws MalformedURLException {
		
		Base.device_PlatformName=platformName;
		Base.device_PlatformVersion=platformVersion;
		Base.device_UDID=UDID;
		Base.device_DeviceName=deviceName;
	}
		
}