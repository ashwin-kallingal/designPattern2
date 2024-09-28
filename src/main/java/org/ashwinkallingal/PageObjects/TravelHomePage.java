package org.ashwinkallingal.PageObjects;

import org.ashwinkallingal.AbstractComponents.SearchFlightAvail;
import org.ashwinkallingal.AbstractComponents.StratergyFactor;
import org.ashwinkallingal.PageComponents.FooterNavigation;
import org.ashwinkallingal.PageComponents.NavigationBar;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class TravelHomePage {
    WebDriver driver;
    By sectionElement = By.id("traveller-home");
    By navigationElement = By.cssSelector(".search-buttons-heading");
    SearchFlightAvail searchFlightAvail;

    public TravelHomePage(WebDriver driver){
        this.driver = driver;
    }

    public void gotTo(){
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }

    public NavigationBar getNavigationBar()
    {
    return new NavigationBar(driver, navigationElement);
    }

    public FooterNavigation getFooterNavigation()
    {
    return new FooterNavigation(driver, sectionElement);
    }

    public void setBookingStratergy(String stratergyType)
    {
        StratergyFactor factor = new StratergyFactor(driver);
        searchFlightAvail = factor.createStratergy(stratergyType);
        this.searchFlightAvail = searchFlightAvail;
    }

    public void checkAvail(HashMap<String, String> reservation) throws InterruptedException {
        searchFlightAvail.checkAvailability(reservation);
    }

    public String getPageTitle(){
        System.out.println("Hello Brother");
        System.out.println("Hello World");
        return driver.getTitle();

    }


}
