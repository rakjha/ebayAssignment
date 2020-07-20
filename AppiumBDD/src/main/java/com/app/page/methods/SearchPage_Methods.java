package com.app.page.methods;

import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.support.PageFactory;

import com.app.core.Base;
import com.app.page.elements.SearchPage_Elements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SearchPage_Methods extends SearchPage_Elements {

	public SearchPage_Methods() {
		PageFactory.initElements(new AppiumFieldDecorator(Base.Appium_Driver.get()), this);

	}
    
	public void searchItem(String item) {
		
		search_icon.click();
		waitForVisibilityOfElement(search_text_box);
		search_text_box.click();
		search_text_box.sendKeys(item);
		assertTrue(StringUtils.isNotEmpty(search_text_box.getText()));
	}
	
	public void selectItemFromSuggestedList(String item) {
		for (MobileElement suggestion : suggested_items_list) {
			if(suggestion.getText().trim().contains(item.toLowerCase())) {
				suggestion.click();
				waitForVisibilityOfElement(search_results_count);
				break;
			}
			
		}
	}
	
	public static void selectBrand(String brandName) {
		
		waitForVisibilityOfElement(search_results_count);
		for(MobileElement brand : brands) {
			if(brand.getText().equalsIgnoreCase(brandName)) {
				brand.click();
				waitForVisibilityOfElement(search_results_count);
				break;
			}
		}
	}
	
	HashMap<String,String> searchedItemDeatils = new HashMap<String,String>();
    
	public HashMap<String, String> searched_item_details() {
    	
    	waitForVisibilityOfElement(selected_items_title);
    	searchedItemDeatils.put("itemName", selected_items_title.getText());
    	searchedItemDeatils.put("starsCount", selected_items_stars_count.getText());
    	searchedItemDeatils.put("sellingPrice", selected_items_rating_price.getText());

    	return searchedItemDeatils;
   }
    
   public static void clickBuyButton() { 
	   scrollByDirection("up");
	   buy_it_now_button.click();
   }
   
   public void clickItemFromList(int arg1) {
	   assertTrue(searched_items_list.get(arg1-1).isDisplayed()); 
	   searched_items_list.get(arg1-1).click();
	   waitForElementToBeClickable(buy_it_now_button);
	   
	   
   }
}
