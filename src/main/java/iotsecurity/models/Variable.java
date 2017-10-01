package iotsecurity.models;

import java.util.ArrayList;

/**
 * Created by Burak on 9/24/17.
 */
public class Variable {

   private String variableName;
   private ArrayList<Value> values;

   public ArrayList<Value> getValues() {
      return values;
   }

   public void setValues(ArrayList<Value> values) {
      this.values = values;
   }

   public String getVariableName() {
      return variableName;
   }

   public void setVariableName(String variableName) {
      this.variableName = variableName;
   }
}

