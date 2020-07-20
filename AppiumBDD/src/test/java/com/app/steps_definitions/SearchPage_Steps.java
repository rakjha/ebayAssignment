package com.app.steps_definitions;

import com.app.page.methods.SearchPage_Methods;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchPage_Steps extends SearchPage_Methods {

	@When("^User enters '(.*)' to search$")
	public void user_enters_to_search(String item) throws Throwable {

		searchItem(item);
	}

	@Then("^User selects '(.*)' from the suggested list$")
	public void user_selects_from_the_suggested_list(String arg1) throws Throwable {

		selectItemFromSuggestedList(arg1);
	}

	@Then("^User selects '(.*)' brand$")
	public void user_selects_brand(String brand) throws Throwable {

		selectBrand(brand);
	}

	@When("^User clicks on the (\\d+) (?:st|nd|rd|th) item$")
	public void user_clicks_on_the_nd_item(int arg1) throws Throwable {

		clickItemFromList(arg1);
	}

	@When("^User captures all the details of the selected item$")
	public void user_captures_all_the_details_of_the_selected_item() throws Throwable {

		searched_item_details();
	}

	@Then("^User clicks Buy It Now button on buy out page$")
	public void user_clicks_Buy_It_Now_button_on_buy_out_page() throws Throwable {

		clickBuyButton();
	}

	@Then("^User scrolls '(.*)'$")
	public void user_scrolls_direction(String direction) throws Throwable {

		scrollByDirection(direction);
	}

	@Then("^User scrolls by coordinates$")
	public void user_scrolls_by_coordinates() throws Throwable {
		scrollByCoordinates();
	}

}
