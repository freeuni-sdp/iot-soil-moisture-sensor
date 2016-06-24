package ge.edu.freeuni.sdp.iot.sensor.soil_moisture;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by nika on 6/22/16.
 */
@XmlRootElement
public class HouseData {

    /* Singleton instance */
    @XmlElement
    private static HouseData instance;

    @XmlElement
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
