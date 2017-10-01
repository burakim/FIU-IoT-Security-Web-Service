package iotsecurity.models.responses;

import iotsecurity.ApplicationConstants;
import iotsecurity.models.VariableResponse;

import java.util.ArrayList;

/**
 * Created by Burak on 9/25/17.
 */
public class GetLatestSensorValuesResponse {
    private ApplicationConstants.RequestResult requestResult;
    private ArrayList<VariableResponse> values;
    private int pantherId;

    public ArrayList<VariableResponse> getValues() {
        return values;
    }

    public void setValues(ArrayList<VariableResponse> values) {
        this.values = values;
    }

    public int getPantherId() {
        return pantherId;
    }

    public void setPantherId(int pantherId) {
        this.pantherId = pantherId;
    }

    public ApplicationConstants.RequestResult getRequestResult() {
        return requestResult;
    }

    public void setRequestResult(ApplicationConstants.RequestResult requestResult) {
        this.requestResult = requestResult;
    }


}
