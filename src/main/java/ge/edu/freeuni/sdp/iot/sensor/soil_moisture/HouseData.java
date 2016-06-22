package ge.edu.freeuni.sdp.iot.sensor.soil_moisture;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by nika on 6/22/16.
 */
public class HouseData {

    /* Singleton instance */
    private static HouseData instance;

    private ConcurrentHashMap<Integer, HouseSensorData> houseMap;

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

    public void put(Integer houseId, HouseSensorData data) {
        houseMap.put(houseId, data);
    }

    public HouseSensorData get(Integer houseId) {
        return houseMap.get(houseId);
    }

}
