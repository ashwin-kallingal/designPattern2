package org.ashwinkallingal.PageComponents;

import org.ashwinkallingal.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FooterNavigation extends AbstractComponent {
    WebDriver driver;

    By flights = By.cssSelector("[title='Flights']");
    By links = By.tagName("a");

    public FooterNavigation(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }


    public String selectFlight()
    {
        return findElement(flights).getAttribute("class");

    }

    public int getLinkCount()
    {
        return findElements(links).size();
    }



    }
