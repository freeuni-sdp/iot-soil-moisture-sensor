package ge.edu.freeuni.sdp.iot.sensor.soil_moisture;

/**
 * Created by khrak on 6/22/16.
 */
public class SensorValue {
    private Double sensorValue;

    public SensorValue(Double sensorValue) {
        this.sensorValue = sensorValue;
    }

    public Double getSensorValue() {
        return sensorValue;
    }
}
