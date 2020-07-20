package com.app.page.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.app.core.Common;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage_Elements extends Common {
	
	@AndroidFindBy(id = "com.ebay.mobile:id/button_classic")
	public static MobileElement use_email_button;
	
	@AndroidFindBy(id="com.ebay.mobile:id/button_google")
	public static MobileElement sign_in_with_google_button;
	
	@AndroidFindBy(id="com.ebay.mobile:id/button_facebook")
	public static MobileElement sign_in_facebook_button;
	
	@AndroidFindBy(id = "com.ebay.mobile:id/button_create_account")
	public static MobileElement create_account_button;
	
	@FindBy(name = "identifier")
	public static WebElement email_text_box;
	
	@FindBy(xpath = "//span[text()='Next']")
	public static WebElement next_button;
	
	@FindBy(name = "password")
	public static WebElement password_text_box;

}
