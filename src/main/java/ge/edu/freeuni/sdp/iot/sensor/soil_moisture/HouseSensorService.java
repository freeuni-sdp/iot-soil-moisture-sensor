package ge.edu.freeuni.sdp.iot.sensor.soil_moisture;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by nika on 6/22/16.
 */
@Path("/house/{houseid}")
@Consumes( { MediaType.APPLICATION_JSON})
@Produces( { MediaType.APPLICATION_JSON})
public class HouseSensorService {

    @GET
    public HouseSensorData get(@PathParam("houseid") String houseId) {
        HouseData data = HouseData.getInstance();
        HouseSensorData sensorData;
        Integer id;

        id = Integer.valueOf(houseId);
        sensorData = data.get(id);

        SensorValue dummySensor1 = new SensorValue(27.32, 1252);
        SensorValue dummySensor2 = new SensorValue(14.21, 1452);
        SensorValue dummySensor3 = new SensorValue(3.143, 1982);

        HouseSensorData housedata = new HouseSensorData();

        housedata.put(1252, dummySensor1);
        housedata.put(1452, dummySensor2);
        housedata.put(1982, dummySensor3);

        return housedata;
    }

}
