package ge.edu.freeuni.sdp.iot.sensor.soil_moisture;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by nika on 6/22/16.
 */
public class HouseData {

    private ConcurrentHashMap<Integer, HouseSensorData> houseMap;

    public HouseData() {
        this.houseMap = new ConcurrentHashMap<>();
    }

    public void put(Integer houseId, HouseSensorData data) {
        houseMap.put(houseId, data);
    }

    public HouseSensorData get(Integer houseId) {
        return houseMap.get(houseId);
    }

}
