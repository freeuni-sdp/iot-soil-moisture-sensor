package ge.edu.freeuni.sdp.iot.sensor.soil_moisture.core;

/**
 * Created by nika on 6/26/16.
 */
public class SensorValue {

    private static final long NOT_AVAILABLE_AFTER = 10000;

    private Double sensorValue;
    private String houseId;
    private long lastUpdateTime;
    private long availableTimeout;

    public SensorValue(Double sensorValue, String houseId) {
        this.sensorValue = sensorValue;
        this.houseId = houseId;
        this.availableTimeout = NOT_AVAILABLE_AFTER;
        this.lastUpdateTime = System.currentTimeMillis();
    }

    public synchronized Double getSensorValue() {
        return sensorValue;
    }

    public synchronized String getHouseId() {
        return houseId;
    }

    public synchronized void setSensorValue(Double sensorValue) {
        this.sensorValue = sensorValue;
        lastUpdateTime = System.currentTimeMillis();
    }

    public synchronized void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    public synchronized boolean isAvailable() {
        return System.currentTimeMillis() - lastUpdateTime < availableTimeout;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SensorValue that = (SensorValue) o;

        if (sensorValue != null ? !sensorValue.equals(that.sensorValue) : that.sensorValue != null) return false;
        return houseId != null ? houseId.equals(that.houseId) : that.houseId == null;

    }
}
