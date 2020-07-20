package com.app.page.elements;

import java.util.List;

import com.app.core.Common;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SearchPage_Elements extends Common{
	
	@AndroidFindBy(id="com.ebay.mobile:id/search_src_text")
    public static MobileElement search_text_box;

    @AndroidFindBy(id = "com.ebay.mobile:id/search_box")
    public static MobileElement search_icon;

    @AndroidFindBy(id = "com.ebay.mobile:id/text")
    public static List<MobileElement> suggested_items_list;

    @AndroidFindBy(id ="com.ebay.mobile:id/textview_item_count")
    public static MobileElement search_results_count;
    
    @AndroidFindBy(id = "com.ebay.mobile:id/textview_item_title")
    public static List<MobileElement> brands;
    
    @AndroidFindBy(id="com.ebay.mobile:id/cell_collection_item")
    public static List<MobileElement> searched_items_list;
    
    @AndroidFindBy(id="com.ebay.mobile:id/textview_item_name")
    public static MobileElement selected_items_title;

    @AndroidFindBy(id="com.ebay.mobile:id/textview_item_subtitle")
    public static MobileElement selected_items_subtitles;
    
    @AndroidFindBy(id="com.ebay.mobile:id/rating_bar")
    public static MobileElement selected_items_stars;
    
    @AndroidFindBy(id="com.ebay.mobile:id/reviews_count")
    public static MobileElement selected_items_stars_count;
    
    @AndroidFindBy(id="com.ebay.mobile:id/textview_item_price")
    public static MobileElement selected_items_rating_price;
    
    @AndroidFindBy(id="com.ebay.mobile:id/original_price_textview")
    public static MobileElement selected_items_strikethrough_price;
    
    @AndroidFindBy(id="com.ebay.mobile:id/percent_off_textview")
    public static MobileElement selected_items_price_off_percent;
    
    @AndroidFindBy(id ="com.ebay.mobile:id/button_bin")
    public static MobileElement buy_it_now_button;
    
    
    

}
