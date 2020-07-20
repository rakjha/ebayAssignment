package com.app.steps_definitions;

import static org.testng.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;

import com.app.core.Base;
import com.app.page.methods.LoginPage_Methods;

import cucumber.api.java.en.When;

public class LoginPage_Steps extends LoginPage_Methods {

	@When("^User logins using '(.*)' and '(.*)'$")
	public void user_logins_using_email_and_password(String email, String pwd) throws Throwable {
	   
	}
	
	@When("^User logins using '(.*)' button$")
	public void user_logins_using_google_button(String buttonName) throws Throwable {
	   
		if(buttonName.equalsIgnoreCase("Google")) {
			scrollIntoView("SIGN IN WITH GOOGLE");
			Thread.sleep(3000);
			Base.Appium_Driver.get().context((String) findContextViews().toArray()[2]);
			
			if(email_text_box.isDisplayed()) {
				email_text_box.clear();
				email_text_box.sendKeys(Base.CONFIG.getProperty("email"));
				assertTrue(StringUtils.isNotEmpty(email_text_box.getText()));
			}
			
			next_button.click();
			if(password_text_box.isDisplayed()) {
				password_text_box.clear();
				password_text_box.sendKeys(Base.CONFIG.getProperty("password"));
				assertTrue(StringUtils.isNotEmpty(password_text_box.getText()));
			}
			
			
		}else if(buttonName.equalsIgnoreCase("facebook")) {
			waitForElementToBeClickable(sign_in_facebook_button);
			sign_in_facebook_button.click();
		}else {
			Assert.fail(buttonName +"is not dispalyed " );
		}
		
	}
}
