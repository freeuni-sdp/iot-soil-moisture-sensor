package ge.edu.freeuni.sdp.iot.sensor.soil_moisture.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.json.JSONObject;

/**
 * Created by khrak on 6/22/16.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SensorValueMessage {

    @JsonProperty("sensorValue")
    private Double sensorValue;

    @JsonProperty("houseId")
    private String houseId;

    @JsonProperty("available")
    private boolean available;

    public SensorValueMessage(String houseId, Double sensorValue, boolean available) {
        this.houseId = houseId;
        this.sensorValue = sensorValue;
        this.available = available;
    }

    public Double getSensorValue() {
        return sensorValue;
    }

    public String getHouseId() {
        return houseId;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setSensorValue(Double sensorValue) {
        this.sensorValue = sensorValue;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public static SensorValueMessage fromJson(JSONObject object) {
        return new SensorValueMessage(object.getString("houseId"),
                object.getDouble("sensorValue"),
                object.getBoolean("available"));
    }

}
