package ge.edu.freeuni.sdp.iot.sensor.soil_moisture;

import sun.management.Sensor;

import java.util.HashMap;

/**
 * Created by khrak on 6/22/16.
 */
public class HouseSensorData {

    private HashMap<Integer, SensorValue> data;

    public HouseSensorData() {
        data = new HashMap<Integer, SensorValue>();
    }

    public void put(Integer sensorid, SensorValue sensorValue) {
        data.put(sensorid, sensorValue);
    }


    public SensorValue get(Integer sensorid) {
        if(data.containsKey(sensorid))
            return data.get(sensorid);

        return null;
    }
}
