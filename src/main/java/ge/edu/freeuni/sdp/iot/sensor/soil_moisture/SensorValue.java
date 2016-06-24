package ge.edu.freeuni.sdp.iot.sensor.soil_moisture;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by khrak on 6/22/16.
 */
@XmlRootElement
public class SensorValue {

    @XmlElement
    private Double sensorValue;

    @XmlElement
    private int sensorId;

    @XmlElement
    private boolean available;

    public SensorValue(Double sensorValue, int sensorId) {
        this.sensorValue = sensorValue;
        this.sensorId = sensorId;
        this.available = true;
    }

    public Double getSensorValue() {
        return sensorValue;
    }

    public int getSensorId() {
        return sensorId;
    }

    public boolean getAvailable(){
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

}
