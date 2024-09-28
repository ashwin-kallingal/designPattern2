package org.ashwinkallingal.AbstractComponents;

import java.util.HashMap;

public interface SearchFlightAvail {

    public void checkAvailability(HashMap<String, String> reservation) throws InterruptedException;
}
