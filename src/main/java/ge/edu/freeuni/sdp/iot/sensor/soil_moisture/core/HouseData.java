package ge.edu.freeuni.sdp.iot.sensor.soil_moisture.core;

import ge.edu.freeuni.sdp.iot.sensor.soil_moisture.model.SensorValueMessage;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by nika on 6/22/16.
 */
public class HouseData {

    /* Singleton instance */
    private static HouseData instance;
    private static HouseData testInstance;

    private static boolean testMode = false;

    private ConcurrentHashMap<String, SensorValue> houseMap;

    private HouseData() {
        this.houseMap = new ConcurrentHashMap<>();
    }

    public static HouseData getInstance() {

        if (testMode) {
            return testInstance;
        }

        if (instance == null) {
            synchronized (HouseData.class) {
                if (instance == null)
                    instance = new HouseData();
            }
        }

        return instance;
    }

    public static void setTestInstance(HouseData instance) {
        testInstance = instance;
    }

    public static void setTestMode(boolean value) {
        testMode = value;
    }

    public void put(String houseId, SensorValue data) {
        houseMap.put(houseId, data);
    }

    public SensorValue get(String houseId) {
        return houseMap.get(houseId);
    }

}
