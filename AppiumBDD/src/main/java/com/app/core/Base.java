package com.app.core;

import java.io.IOException;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Base {

	public static String env_name;
	public static ThreadLocal<AppiumDriver<MobileElement>> Appium_Driver = new ThreadLocal<>();
	public static String device_PlatformName = null;
	public static String device_PlatformVersion = null;
	public static String device_DeviceName = null;
	public static String device_UDID = null;
	public static long WDA;
	public static Properties CONFIG = null;
	public static String baseURL;
	public static String OS;
	public static String dirPath;
	public static String baseParallelURL1;
	public static String baseParallelURL2;
	public static String appium_url = "http://127.0.0.1:4723/wd/hub";
	
	public static DesiredCapabilities capabilities = new DesiredCapabilities();

	// This method is for setting up desired capabilities in virtual or android
	// emulator
	public static void appium_Android_EmulatorSetup() throws MalformedURLException {

		loadConfig();

		System.out.println("Launching Emulator Android Automation Test");

		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, device_PlatformName);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, device_PlatformVersion);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device_DeviceName);
		capabilities.setCapability(MobileCapabilityType.NO_RESET, true);

		capabilities.setCapability("appPackage", CONFIG.getProperty("appPackage"));
		capabilities.setCapability("appActivity", CONFIG.getProperty("appActivity"));

		capabilities.setCapability(MobileCapabilityType.ACCEPT_INSECURE_CERTS, true);
		capabilities.setCapability(MobileCapabilityType.ACCEPT_SSL_CERTS, true);
		capabilities.setCapability(MobileCapabilityType.SUPPORTS_ALERTS, true);
		capabilities.setCapability(MobileCapabilityType.CLEAR_SYSTEM_FILES, true);

		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		capabilities.setCapability(MobileCapabilityType.FORCE_MJSONWP, true);
		capabilities.setCapability(MobileCapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, true);

		capabilities.setCapability(MobileCapabilityType.UNHANDLED_PROMPT_BEHAVIOUR, true);
		capabilities.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, true);
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);

		capabilities.setCapability("unicodeKeyboard", true);
		capabilities.setCapability("resetKeyboard", true);
		capabilities.setCapability("autoGrantPermissions", true);
		capabilities.setCapability("autoDismissAlerts", true);
		capabilities.setCapability("printPageSourceOnFindFailure", true);

		Appium_Driver.set(new AndroidDriver<MobileElement>(new URL(appium_url), capabilities));

	}

	// This method is for setting up desired capabilities in real android device
	public static void appium_Android_DeviceSetup() throws MalformedURLException {

		loadConfig();

		System.out.println("Launching Emulator Android Automation Test");

		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, device_PlatformName);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, device_PlatformVersion);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device_DeviceName);
		capabilities.setCapability(MobileCapabilityType.UDID, device_UDID);
		capabilities.setCapability(MobileCapabilityType.NO_RESET, true);

		capabilities.setCapability("appPackage", CONFIG.getProperty("appPackage"));
		capabilities.setCapability("appActivity", CONFIG.getProperty("appActivity"));

		capabilities.setCapability(MobileCapabilityType.ACCEPT_INSECURE_CERTS, true);
		capabilities.setCapability(MobileCapabilityType.ACCEPT_SSL_CERTS, true);
		capabilities.setCapability(MobileCapabilityType.SUPPORTS_ALERTS, true);
		capabilities.setCapability(MobileCapabilityType.CLEAR_SYSTEM_FILES, true);

		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		capabilities.setCapability(MobileCapabilityType.FORCE_MJSONWP, true);
		capabilities.setCapability(MobileCapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, true);

		capabilities.setCapability(MobileCapabilityType.UNHANDLED_PROMPT_BEHAVIOUR, true);
		capabilities.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, true);
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);

		capabilities.setCapability("unicodeKeyboard", true);
		capabilities.setCapability("resetKeyboard", true);
		capabilities.setCapability("autoGrantPermissions", true);
		capabilities.setCapability("autoDismissAlerts", true);
		capabilities.setCapability("printPageSourceOnFindFailure", true);

		Appium_Driver.set(new AndroidDriver<MobileElement>(new URL(appium_url), capabilities));

	}

	// This method is for setting up desired capabilities in virtual iOS devices
	public static void appium_iOS_SimulatorSetup() throws MalformedURLException {

		loadConfig();

		DesiredCapabilities capabilities = new DesiredCapabilities();
		System.out.println("Launching iOS Automation Test");

		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, device_PlatformName);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, device_PlatformVersion);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device_DeviceName);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
		capabilities.setCapability(MobileCapabilityType.APP, "apppath");

		capabilities.setCapability(MobileCapabilityType.FORCE_MJSONWP, "true");
		capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
		capabilities.setCapability(MobileCapabilityType.ACCEPT_INSECURE_CERTS, true);
		capabilities.setCapability(MobileCapabilityType.ACCEPT_SSL_CERTS, true);
		capabilities.setCapability(MobileCapabilityType.AUTO_WEBVIEW, true);

		capabilities.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, true);
		capabilities.setCapability(MobileCapabilityType.SUPPORTS_JAVASCRIPT, true);
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
		capabilities.setCapability("autoDismissAlerts", true);
		capabilities.setCapability("simpleIsVisibleCheck", true);
		Appium_Driver.set(new IOSDriver<MobileElement>(new URL(appium_url), capabilities));

	}

	// This method is for setting up desired capabilities in real iOS devices

	public static void appium_iOS_DeviceSetup() throws MalformedURLException {

		loadConfig();

		DesiredCapabilities capabilities = new DesiredCapabilities();
		System.out.println("Launching iOS Automation Test");

		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, device_PlatformName);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, device_PlatformVersion);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device_DeviceName);
		capabilities.setCapability(MobileCapabilityType.UDID, device_UDID);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");

		capabilities.setCapability(MobileCapabilityType.FORCE_MJSONWP, "true");
		capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
		capabilities.setCapability(MobileCapabilityType.ACCEPT_INSECURE_CERTS, true);
		capabilities.setCapability(MobileCapabilityType.ACCEPT_SSL_CERTS, true);
		capabilities.setCapability(MobileCapabilityType.AUTO_WEBVIEW, true);

		capabilities.setCapability("xcodeOrgId", "Rakesh Jha");
		capabilities.setCapability("xcodeSigningId", "iPhone Developer");
		capabilities.setCapability("updateWDABundleId", "io.appium.rjha.sv.WebDriverAgentRunner");
		capabilities.setCapability(MobileCapabilityType.APP, "apppath");

		capabilities.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, true);
		capabilities.setCapability(MobileCapabilityType.SUPPORTS_JAVASCRIPT, true);
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
		capabilities.setCapability("autoDismissAlerts", true);
		capabilities.setCapability("simpleIsVisibleCheck", true);
		Appium_Driver.set(new IOSDriver<MobileElement>(new URL(appium_url), capabilities));

	}

	public static void getBrowserInstance(String browserValue) throws InterruptedException, IOException {

		// below method is written to delete the old log files

		LogDeletion ld = new LogDeletion();
		ld.deletePrevLogs();

		if (browserValue.equalsIgnoreCase("Android Emulator")) {

			appium_Android_EmulatorSetup();

		} else if (browserValue.equalsIgnoreCase("Android Device")) {

			appium_Android_DeviceSetup();
		} else if (browserValue.equalsIgnoreCase("iOS Simulator")) {
			
			appium_iOS_SimulatorSetup();
			
		} else if (browserValue.equalsIgnoreCase("iOS Device")) {

			appium_iOS_DeviceSetup();
		}
	}

	// load CONFIG
	public static void loadConfig() {
		env_name = System.getProperty("prop.name");

		if (CONFIG == null) {

			try {
				if (env_name == null) {

					CONFIG = new Properties();

					FileInputStream file = new FileInputStream(System.getProperty("user.dir")
							+ "//src//main//resources//Profile//Config_Testing.properties");
					CONFIG.load(file);

				} else if (env_name.equalsIgnoreCase("Testing")) {
					CONFIG = new Properties();

					FileInputStream file = new FileInputStream(System.getProperty("user.dir")
							+ "//src//main//resources//Profile//Config_Testing.properties");
					CONFIG.load(file);

				} else if (env_name.equalsIgnoreCase("Prod")) {
					CONFIG = new Properties();

					FileInputStream file = new FileInputStream(
							System.getProperty("user.dir") + "//src//main//resources//Profile//Config_Prod.properties");
					CONFIG.load(file);

				}

			} catch (Exception e) {
				System.out.println("Error in intializing properties files");
				e.printStackTrace();
				System.out.println(e.getMessage());
			}

		}

	}

}
