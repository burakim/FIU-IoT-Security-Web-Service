package iotsecurity.models;

import java.util.ArrayList;

/**
 * Created by Burak on 9/24/17.
 */
public class Board {

    public ArrayList<Sensor> getSensor() {
        return sensor;
    }

    public void setSensor(ArrayList<Sensor> sensor) {
        this.sensor = sensor;
    }

    private ArrayList<Sensor> sensor;
}
