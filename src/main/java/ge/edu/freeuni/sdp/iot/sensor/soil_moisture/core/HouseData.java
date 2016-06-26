package ge.edu.freeuni.sdp.iot.sensor.soil_moisture.core;

import ge.edu.freeuni.sdp.iot.sensor.soil_moisture.model.SensorValue;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by nika on 6/22/16.
 */
public class HouseData {

    /* Singleton instance */
    private static HouseData instance;

    private ConcurrentHashMap<String, SensorValue> houseMap;

    private HouseData() {
        this.houseMap = new ConcurrentHashMap<>();
    }

    public static HouseData getInstance() {
        if (instance == null) {
            synchronized (HouseData.class) {
                if (instance == null)
                    instance = new HouseData();
            }
        }

        return instance;
    }

    public void put(String houseId, SensorValue data) {
        houseMap.put(houseId, data);
    }

    public SensorValue get(String houseId) {
        return houseMap.get(houseId);
    }

}
