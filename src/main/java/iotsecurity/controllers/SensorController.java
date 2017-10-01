package iotsecurity.controllers;

import iotsecurity.ApplicationConstants;
import iotsecurity.models.*;
import iotsecurity.models.requests.SensorValuesRequest;
import iotsecurity.models.responses.GetLatestSensorValuesResponse;
import iotsecurity.models.responses.SensorValuesResponse;
import iotsecurity.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Created by Burak on 9/24/17.
 */
@RestController
public class SensorController {

    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping(value = "/sendsensorvalue/",method = RequestMethod.PUT)
    SensorValuesResponse getSensorValueFromStudents (@RequestBody SensorValuesRequest sensorValuesRequest)
    {
        SensorValuesResponse sensorValuesResponse = new SensorValuesResponse();
        try {
            Student student = studentRepository.findOneByPantherId(sensorValuesRequest.getPantherId());

            if (student == null) {
                student = createNewStudent(sensorValuesRequest.getPantherId());
                studentRepository.insert(student);
            }


            for (Sensor sensor : student.getBoard().getSensor()) {
                for (VariableRequest variableFromSensor : sensorValuesRequest.getValues()) {
                    for (Variable variable : sensor.getSensorData()) {

                        if (variableFromSensor.getVariableName().compareTo(variable.getVariableName()) == 0) {
                            Value value = new Value();
                            value.setTimeStamp(variableFromSensor.getTimeStamp());
                            value.setValue(variableFromSensor.getValue());
                            variable.getValues().add(value);
                        }

                    }
                }
            }

            studentRepository.save(student);
            sensorValuesResponse.setResult(ApplicationConstants.RequestResult.SUCCESS);
        }
        catch (Exception exception)
        {
            sensorValuesResponse.setResult(ApplicationConstants.RequestResult.FAIL);
            exception.printStackTrace();
        }
        return sensorValuesResponse;
        }


        @RequestMapping(value ="/getsensorvalues/{pantherId}",method = RequestMethod.GET)
        GetLatestSensorValuesResponse getLatestSensorValues(@PathVariable int pantherId)
        {
            GetLatestSensorValuesResponse getLatestSensorValuesResponse = new GetLatestSensorValuesResponse();
            try{
                Student student = studentRepository.findOneByPantherId(pantherId);
                getLatestSensorValuesResponse.setPantherId(pantherId);
                ArrayList<VariableResponse> variableResponses = new ArrayList<>();
                if(student != null)
                {
                    for(Sensor sensor: student.getBoard().getSensor())
                    {
                        for(Variable variable: sensor.getSensorData())
                        {
                            VariableResponse variableResponse = new VariableResponse();
                            variableResponse.setVariableName(variable.getVariableName());

                            variableResponse.setValue(getLatestValue(variable.getValues()));

                            variableResponses.add(variableResponse);

                        }
                    }

                    getLatestSensorValuesResponse.setValues(variableResponses);
                    getLatestSensorValuesResponse.setRequestResult(ApplicationConstants.RequestResult.SUCCESS);

                }
                else
                {
                    getLatestSensorValuesResponse.setRequestResult(ApplicationConstants.RequestResult.FAIL);

                }
            }
            catch (Exception exception)
            {
                getLatestSensorValuesResponse.setRequestResult(ApplicationConstants.RequestResult.FAIL);
                exception.printStackTrace();

            }
            return getLatestSensorValuesResponse;
        }

        private Value getLatestValue(ArrayList<Value> values)
        {
            if(values.size()>0)
            return values.get(values.size()-1);
            else
            return null;
        }


        private Student createNewStudent(int pantherId)
        {
            Student newStudent = new Student();
            newStudent.setPantherId(pantherId);
            ArrayList<Sensor> sensors = new ArrayList<>();
            Sensor bmp280 = new Sensor();
            ArrayList<Variable> variables = new ArrayList<>();
            Variable temperatureVariable = new Variable();
            Variable pressureVariable = new Variable();
            Variable humidityVariable = new Variable();
            temperatureVariable.setVariableName("Temperature");
            pressureVariable.setVariableName("Pressure");
            humidityVariable.setVariableName("Humidity");
            temperatureVariable.setValues(new ArrayList<>());
            pressureVariable.setValues(new ArrayList<>());
            humidityVariable.setValues(new ArrayList<>());
            variables.add(temperatureVariable);
            variables.add(pressureVariable);
            variables.add(humidityVariable);
            bmp280.setSensorData(variables);

            sensors.add(bmp280);

            Board board = new Board();
            board.setSensor(sensors);

            newStudent.setBoard(board);
            return  newStudent;
        }

}
