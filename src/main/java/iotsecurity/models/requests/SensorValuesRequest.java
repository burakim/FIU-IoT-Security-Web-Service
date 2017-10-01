package iotsecurity.models.requests;

import iotsecurity.models.VariableRequest;

import java.util.ArrayList;

/**
 * Created by Burak on 9/24/17.
 */
public class SensorValuesRequest {

    private int pantherId;
    private ArrayList<VariableRequest> values;

    public int getPantherId() {
        return pantherId;
    }

    public void setPantherId(int pantherId) {
        this.pantherId = pantherId;
    }


    public ArrayList<VariableRequest> getValues() {
        return values;
    }

    public void setValues(ArrayList<VariableRequest> values) {
        this.values = values;
    }
}
