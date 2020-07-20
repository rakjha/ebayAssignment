package com.app.core;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class Common {

	public static String env_name;
	static WebDriverWait wait = new WebDriverWait(Base.Appium_Driver.get(), 30);
	@SuppressWarnings("rawtypes")
	static TouchAction touch = new TouchAction(Base.Appium_Driver.get());

	public void waitForPageLoad() throws InterruptedException {

		Base.Appium_Driver.get().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		staticWait(500);
	}

	public static void staticWait(final long millis) {
		try {
			TimeUnit.SECONDS.sleep(millis);
		} catch (final InterruptedException e) {
		}
	}

	public static MobileElement waitForElementToBeClickable(final MobileElement element) {

		return  (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static Boolean waitForElementToBeSelected(final MobileElement element) {

		return wait.until(ExpectedConditions.elementToBeSelected(element));
	}

	public static MobileElement waitForVisibilityOfElement(final MobileElement element) {

		return (MobileElement) wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static Boolean waitForInVisibilityOfElement(final MobileElement element) {

		return wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public static void waitForVisibilityOfElementsList(final List<MobileElement> element) {

		for (MobileElement mobileElement : element) {
			
			wait.until(ExpectedConditions.visibilityOf(mobileElement));
			
		}
	}

	public static void tapOnAndroidElement(final MobileElement element) {

		touch.tap(ElementOption.element(element)).perform();
		staticWait(500);
	}
	
	public static Dimension dim = Base.Appium_Driver.get().manage().window().getSize();
	public static void scrollByCoordinates() {
		int x = dim.getWidth()/2;
		int startY = (int)(dim.getHeight()*0.8);
		int endY = (int)(dim.getHeight()*0.2);
		touch.press(PointOption.point(x, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
		.moveTo(PointOption.point(x,endY)).release().perform();
	}
	
	public static void scrollByDirection(String direction) {
		int x = dim.getWidth()/2;
		int startY = 0;
		int endY = 0;
		
		switch (direction) {
		case "up":
		startY = (int)(dim.getHeight()*0.8);
		endY = (int)(dim.getHeight()*0.2);
		touch.press(PointOption.point(x, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
		.moveTo(PointOption.point(x,endY)).release().perform();
		break;
		
		case "down":
			startY = (int)(dim.getHeight()*0.2);
			endY = (int)(dim.getHeight()*0.8);
			touch.press(PointOption.point(x, endY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
			.moveTo(PointOption.point(x,startY)).release().perform();
			break;

		default:
			break;
		}
		
	}
	
	// This method is to scroll to a element using text
	public static void scrollIntoView(String Text){

        ((AndroidDriver<MobileElement>) Base.Appium_Driver.get()).findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"" + Text + "\").instance(0))").click();
	}
	
	public static Set<String> findContextViews() {
		return Base.Appium_Driver.get().getContextHandles();
	}

}