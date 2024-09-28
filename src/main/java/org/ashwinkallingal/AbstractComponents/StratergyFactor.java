package org.ashwinkallingal.AbstractComponents;

import org.ashwinkallingal.PageComponents.MultiCity;
import org.ashwinkallingal.PageComponents.RoundTrip;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StratergyFactor {

    public By sectionElement = By.id("flightSearchContainer");
    public WebDriver driver;

    public StratergyFactor(WebDriver driver) {
        this.driver = driver;
    }

    public SearchFlightAvail createStratergy(String stratergytype)
    {
        if(stratergytype.equalsIgnoreCase("roundtrip"))
        {
            return new RoundTrip(driver, sectionElement);
        }
        if(stratergytype.equalsIgnoreCase("multicity"))
        {
            return new MultiCity(driver, sectionElement);
        }
        return null;
    }




}
