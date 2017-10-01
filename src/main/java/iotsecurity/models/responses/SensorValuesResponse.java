package iotsecurity.models.responses;

import iotsecurity.ApplicationConstants;

/**
 * Created by Burak on 9/24/17.
 */
public class SensorValuesResponse {

    private ApplicationConstants.RequestResult result;

    public ApplicationConstants.RequestResult getResult() {
        return result;
    }

    public void setResult(ApplicationConstants.RequestResult result) {
        this.result = result;
    }
}
