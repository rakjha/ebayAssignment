package com.app.generateReports;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.TestListenerAdapter;

public class GenerateReports extends TestListenerAdapter {

	@Override
	public void onFinish(ITestContext testContext) {
		super.onFinish(testContext);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (System.getProperty("surefire.suiteXmlFiles")==null|| System.getProperty("surefire.suiteXmlFiles").equalsIgnoreCase("android_device.xml")
				|| System.getProperty("surefire.suiteXmlFiles").equalsIgnoreCase("android_emulator.xml")) {

			if (System.getProperty("os.name").toLowerCase().contains("mac")) {
				runShAndroidReport();
			} else {
				runBatAndroidReport();
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else if (System.getProperty("surefire.suiteXmlFiles").equalsIgnoreCase("iOS_device.xml")
				|| System.getProperty("surefire.suiteXmlFiles").equalsIgnoreCase("iOS_simulator.xml")) {

			if (System.getProperty("os.name").toLowerCase().contains("mac")) {
				runShiOSReport();
			} else {
				runShiOSReport();
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void runShAndroidReport() {

		String dirPath = System.getProperty("user.dir");
		try {
			System.out.println(dirPath);
			Runtime.getRuntime().exec("/bin/bash /" + dirPath + "/batFiles/generateAndroidReport.sh");
			System.out.println("Generating Android Execution report !!!");

		}

		catch (IOException e) {
			System.out.println("Error in running .sh file");
			e.printStackTrace();
		}

		System.out.println("Android HTML report generated");

	}

	public static void runBatAndroidReport() {

		System.out.println("Generating Android HTML report !!!");
		String dirPath = System.getProperty("user.dir");
		try {
			Runtime.getRuntime().exec("cmd.exe /c" + dirPath + "/batFiles/generateAndroidReport.bat");
		} catch (IOException e) {
			System.out.println("Error in running .bat file");
			e.printStackTrace();
		}
		System.out.println("Android HTML report generated");

	}

	public static void runBatiOSReport() {

		System.out.println("Generating iOS HTML reports ....");
		String dirPath = System.getProperty("user.dir");
		System.out.println(dirPath);

		try {
			Runtime.getRuntime().exec("cmd.exe /c" + dirPath + "/batFiles/generateiOSReport.bat");

		} catch (IOException e) {
			System.out.println("Error in running .bat file");
			System.out.println(e.getMessage());
		}

		System.out.println("iOS HTML reports generated");

	}

	public static void runShiOSReport() {

		System.out.println("Generating iOS HTML reports ....");
		String dirPath = System.getProperty("user.dir");
		try {

			Runtime.getRuntime().exec("/bin/bash /" + dirPath + "/batFiles/generateiOSReport.sh");

		} catch (IOException e) {
			System.out.println("Error in running .sh file");
			System.out.println(e.getMessage());
		}
		System.out.println("iOS HTML reports generated");

	}

	public static void runShMultiMobileReport() {

		String dirPath = System.getProperty("user.dir");
		try {
			System.out.println(dirPath);
			Runtime.getRuntime().exec("/bin/bash /" + dirPath + "/batFiles/generateMultiMobileReport.sh");
			System.out.println("Generating Multi Mobile Execution report !!!");
		}

		catch (IOException e) {
			System.out.println("Error in running .sh file");
			e.printStackTrace();
		}

		System.out.println("Multi Mobile HTML report generated");
	}

}