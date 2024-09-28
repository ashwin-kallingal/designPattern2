package org.ashwinkallingal.AbstractComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {



    public WebDriver initializeDriver()
    {
        WebDriver driver = new ChromeDriver();

        return driver;
    }





}
