package org.ashwinkallingal.PageComponents;

import org.ashwinkallingal.AbstractComponents.AbstractComponent;
import org.ashwinkallingal.AbstractComponents.SearchFlightAvail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.function.Consumer;

public class RoundTrip extends AbstractComponent implements SearchFlightAvail {

    private final By roundTrip = By.cssSelector("#ctl00_mainContent_rbtnl_Trip_1");
    private final By org = By.cssSelector("input[id='ctl00_mainContent_ddl_originStation1_CTXT']");
    private final By des = By.cssSelector("input[id='ctl00_mainContent_ddl_destinationStation1_CTXT']");
    private final By armed = By.cssSelector("#ctl00_mainContent_chk_IndArm");
    private final By search = By.cssSelector("input[id='ctl00_mainContent_btn_FindFlights']");

    public RoundTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }


    @Override
    public void checkAvailability(HashMap<String, String> reservation) throws InterruptedException {
        System.out.println("I'm inside RoundTrip");
        makestateready(s->selectOriginCity(reservation.get("origin1")));
        Thread.sleep(2000);
        findElement(des).click();
        Thread.sleep(2000);
        selectDestinationCity(reservation.get("dest1"));
        findElement(armed).click();
        findElement(search).click();


    }


    public void selectOriginCity(String origin)
    {
        findElement(By.xpath("//a[@value='"+origin+"']")).click();
    }

    public void selectDestinationCity(String destination)
    {
        findElement(By.xpath("(//a[@value='"+destination+"'])[2]")).click();
    }

    public void makestateready(Consumer<RoundTrip> consumer){
        findElement(roundTrip).click();
        findElement(org).click();
        consumer.accept(this);
    }
}
