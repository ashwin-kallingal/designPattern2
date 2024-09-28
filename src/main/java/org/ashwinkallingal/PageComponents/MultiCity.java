package org.ashwinkallingal.PageComponents;

import org.ashwinkallingal.AbstractComponents.AbstractComponent;
import org.ashwinkallingal.AbstractComponents.SearchFlightAvail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.function.Consumer;

public class MultiCity extends AbstractComponent implements SearchFlightAvail {

    private final By multicity = By.cssSelector("#ctl00_mainContent_rbtnl_Trip_2");
    private final By modalalert = By.cssSelector("#MultiCityModelAlert");
    private final By org1 = By.cssSelector("input[id='ctl00_mainContent_ddl_originStation1_CTXT']");
    private final By des1 = By.cssSelector("input[id='ctl00_mainContent_ddl_destinationStation1_CTXT']");
    private final By org2 = By.cssSelector("input[id='ctl00_mainContent_ddl_originStation2_CTXT']");
    private final By des2 = By.cssSelector("input[id='ctl00_mainContent_ddl_destinationStation2_CTXT']");
    private final By armed = By.cssSelector("#ctl00_mainContent_chk_IndArm");
    private final By search = By.cssSelector("input[id='ctl00_mainContent_btn_FindFlights']");

    public MultiCity(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }


    @Override
    public void checkAvailability(HashMap<String, String> reservation) throws InterruptedException {
        System.out.println("I'm inside Multicity");

        makestateready(s->selectOrigin1City(reservation.get("origin1")));
        Thread.sleep(2000);
        findElement(des1).click();
        selectDestination1City(reservation.get("dest1"));
        Thread.sleep(2000);

        findElement(org2).click();
        selectOrigin2City(reservation.get("origin2"));
        Thread.sleep(2000);
        findElement(des2).click();
        Thread.sleep(2000);
        selectDestination2City(reservation.get("dest2"));
        Thread.sleep(2000);
        findElement(armed).click();
        findElement(search).click();
    }

    public void selectOrigin1City(String origin)
    {
        findElement(By.xpath("//a[@value='"+origin+"']")).click();
    }

    public void selectDestination1City(String destination)
    {
        findElement(By.xpath("(//a[@value='"+destination+"'])[2]")).click();
    }

    public void selectOrigin2City(String origin)
    {
        findElement(By.xpath("(//a[@value='"+origin+"'])[3]")).click();
    }

    public void selectDestination2City(String destination)
    {
        findElement(By.xpath("(//a[@value='"+destination+"'])[4]")).click();
    }

    public void makestateready(Consumer<MultiCity> consumer){
        findElement(multicity).click();
        findElement(modalalert).click();
        waitforelementtodisappear(modalalert);
        findElement(org1).click();
        consumer.accept(this);
    }






}
