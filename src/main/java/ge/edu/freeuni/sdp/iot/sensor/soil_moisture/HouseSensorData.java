package ge.edu.freeuni.sdp.iot.sensor.soil_moisture;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by khrak on 6/22/16.
 */
public class HouseSensorData {

    private ConcurrentHashMap<Integer, SensorValue> data;

    public HouseSensorData() {
        data = new ConcurrentHashMap<>();
    }

    public void put(Integer sensorid, SensorValue sensorValue) {
        data.put(sensorid, sensorValue);
    }

    public SensorValue get(Integer sensorid) {
        return data.get(sensorid);
    }

    public Collection<SensorValue> getValues() {
        return data.values();
    }

}
