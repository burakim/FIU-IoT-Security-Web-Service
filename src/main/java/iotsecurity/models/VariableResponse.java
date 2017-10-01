package iotsecurity.models;

/**
 * Created by Burak on 9/25/17.
 */
public class VariableResponse {
   private String variableName;

    public String getVariableName() {
        return variableName;
    }

    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    private Value value;
}
