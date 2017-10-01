package iotsecurity.models;

import java.util.ArrayList;

/**
 * Created by Burak on 9/24/17.
 */
public class Sensor {

    public ArrayList<Variable> getSensorData() {
        return sensorData;
    }

    public void setSensorData(ArrayList<Variable> sensorData) {
        this.sensorData = sensorData;
    }

    private ArrayList<Variable> sensorData;
}
