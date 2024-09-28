package org.ashwinkallingal.PageComponents;

import org.ashwinkallingal.AbstractComponents.AbstractComponent;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBar extends AbstractComponent {

    By flights = By.cssSelector("[title='Flights']");
    By links = By.tagName("a");

    public NavigationBar(WebDriver driver, By sectionElement) {
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
