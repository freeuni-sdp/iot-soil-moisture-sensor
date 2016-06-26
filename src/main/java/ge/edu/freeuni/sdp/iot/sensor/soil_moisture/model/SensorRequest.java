package ge.edu.freeuni.sdp.iot.sensor.soil_moisture.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.json.JSONObject;

/**
 * Created by nika on 6/26/16.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SensorRequest {

    @JsonProperty("sensorValue")
    private Double sensorValue;

    public SensorRequest(Double sensorValue) {
        this.sensorValue = sensorValue;
    }

    public Double getSensorValue() {
        return sensorValue;
    }

    public static SensorRequest fromJson(JSONObject object) {
        return new SensorRequest(object.getDouble("sensorValue"));
    }

}
