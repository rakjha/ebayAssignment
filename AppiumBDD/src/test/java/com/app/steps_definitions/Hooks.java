package com.app.steps_definitions;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.app.core.Base;
import com.app.generateReports.ScriptRecordingTest;

import atu.testrecorder.exceptions.ATUTestRecorderException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
private static final Logger LOG = Logger.getLogger(Hooks.class);
	@Before
	public void openBrowser(Scenario scenario) throws Exception {
		
		Base.getBrowserInstance(Base.device_DeviceName);
		
		LOG.debug("---------- Launching ------------"+Base.device_PlatformName);
		
		System.out.println("Launching : "+Base.device_PlatformName);
		
		LOG.debug("Scenario " + "\"" + scenario.getName() + "\" execution started " + "\n");
		System.out.println("Scenario " + "\"" + scenario.getName() + "\" execution started " + "\n");
		ScriptRecordingTest.startRecording();
	}
	@After
	public void tearDown(Scenario scenario) throws IOException, AWTException, ATUTestRecorderException {

		if (scenario.isFailed()) {

			LOG.debug("Scenario " + "\"" + scenario.getName() + "\" is " + scenario.getStatus() + "\n");
			System.out.println("Screen shot getting captured for the " + "\"" + scenario.getName() + "\"" + "\n");
			final byte[] screenshot = ((TakesScreenshot) Base.Appium_Driver.get())
					.getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
			scenario.write(" Scenario : "+scenario.getName()+" is " +scenario.getStatus());

		}
		Base.Appium_Driver.get().closeApp();
		Base.Appium_Driver.get().quit();

		System.out.println("Scenario " + "\"" + scenario.getName() + "\" is " + scenario.getStatus() + "\n");
		System.out.println("\"" + scenario.getName() + "\" execution finished " + "\n");
		ScriptRecordingTest.stopRecording();
	}
}
