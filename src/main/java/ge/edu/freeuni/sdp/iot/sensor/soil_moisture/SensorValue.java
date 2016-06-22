package ge.edu.freeuni.sdp.iot.sensor.soil_moisture;

/**
 * Created by khrak on 6/22/16.
 */
public class SensorValue {

    private Double sensorValue;
    private int sensorId;

    public SensorValue(Double sensorValue, int sensorId) {
        this.sensorValue = sensorValue;
        this.sensorId = sensorId;
    }

    public Double getSensorValue() {
        return sensorValue;
    }

    public int getSensorId() {
        return sensorId;
    }

}
