package iotsecurity.models;

/**
 * Created by Burak on 9/24/17.
 */
public class Value {
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    private double value;
    private String timeStamp;
}
