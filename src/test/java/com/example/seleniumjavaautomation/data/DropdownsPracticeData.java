package com.example.seleniumjavaautomation.data;

public class DropdownsPracticeData {
    public static final String URL = "https://rahulshettyacademy.com/dropdownsPractise/";
    public static final String URL_SEARCH_MODE = "https://rahulshettyacademy.com/dropdownsPractise/#search.aspx?mode=search";
    public static final String PAGE_TITLE = "QAClickJet - Flight Booking for Domestic and International, Cheap Air Tickets";
    public static final String CURRENCY_DROPDOWN_XPATH = "//select[@id='ctl00_mainContent_DropDownListCurrency']";
    public static final String PASSENGERS_INPUT_XPATH = "//div[@id='divpaxinfo']";
    public static final String PASSENGERS_OPTIONS_XPATH = "//div[@id='divpaxOptions']";
    public static final String PASSENGERS_ADULT_ADD_ID = "hrefIncAdt";
    public static final String PASSENGERS_ADULT_SUBTRACT_ID = "hrefDecAdt";
    public static final String PASSENGERS_ADULT_AMOUNT_ID = "spanAudlt";
    public static final String PASSENGERS_DONE_BTN_ID = "btnclosepaxoption";
    public static final String DEPARTURE_CITY_INPUT_ID = "ctl00_mainContent_ddl_originStation1_CTXT";
    public static final String DEPARTURE_CITIES_LIST_XPATH = "//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR']";
    public static final String ARRIVAL_CITIES_LIST_XPATH = "//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']";
    public static final String ARRIVAL_CITY_INPUT_ID = "ctl00_mainContent_ddl_destinationStation1_CTXT";
    public static final String ARRIVAL_CITY_INPUT_ARROW_ID = "ctl00_mainContent_ddl_destinationStation1_CTXTaction";
    public static final String COUNTRY_INPUT_ID = "autosuggest";
    public static final String COUNTRY_AUTOSUGGESTION_LIST_XPATH = "//li[@class='ui-menu-item']";
    public static final String DISCOUNT_OPTIONS_CHECKBOXES_XPATH = "//div[@id='discount-checkbox']";
    public static final String DISCOUNT_FRIENDS_AND_FAM_ID_ENDING = "'friendsandfamily'";
    public static final String DISCOUNT_SENIOR_ID_ENDING = "'SeniorCitizenDiscount'";
    public static final String DISCOUNT_INDIAN_AF_ENDING = "'IndArm'";
    public static final String DISCOUNT_STUDENT_ENDING = "'StudentDiscount'";
    public static final String DISCOUNT_LONELY_MINOR_ENDING = "'Unmr'";
    public static final String DISCOUNT_CHECKBOXES_TYPE_XPATH = "//input[@type = 'checkbox']";
    public static final String TRIP_ONEWAY_XPATH = "//input[@value = 'OneWay' and contains(@id, 'rbtnl_Trip')]";
    public static final String TRIP_ROUND_XPATH = "//input[@value = 'RoundTrip' and contains(@id, 'rbtnl_Trip')]";
    public static final String TRIP_MULTI_XPATH = "//input[@value = 'TripPlanner' and contains(@id, 'rbtnl_Trip')]";
    public static final String DEPARTURE_DATE_BUTTON_XPATH = "//div[@id='marketCityPair_1']//following-sibling::div[@class='picker-first2']//descendant::button[@class = 'ui-datepicker-trigger']";
    public static final String DATE_PICKER_ID = "ui-datepicker-div";
    public static final String CURRENT_DATE_HIGHLIGHTED_XPATH = "//a[contains(@class, 'ui-state-highlight')]";
    public static final String ACTUAL_DEPARTURE_DATE_ID = "view_fulldate_id_1";
    public static final String RETURN_DATE_BOX_ID = "Div1";
    public static final String SEARCH_BUTTON_ID = "ctl00_mainContent_btn_FindFlights";
}
