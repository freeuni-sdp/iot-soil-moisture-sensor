package ge.edu.freeuni.sdp.iot.sensor.soil_moisture;

/**
 * Created by khrak on 6/22/16.
 */

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/house/{houseid}/sensor/{sensorid}")
@Consumes( { MediaType.APPLICATION_JSON})
@Produces( { MediaType.APPLICATION_JSON})
public class HouseSingleSensorService {

    @GET
    public SensorValue get(@PathParam("houseid") String houseid, @PathParam("sensorid") String sensorid) {
        HouseData houseData = HouseData.getInstance();
        HouseSensorData sensorData;

        Integer houseIntegerid = Integer.valueOf(houseid);
        Integer sensorIntegerid = Integer.valueOf(sensorid);

        sensorData = houseData.get(houseIntegerid);
        SensorValue sensorValues = sensorData.get(sensorIntegerid);

        SensorValue dummySensor = new SensorValue(3.143, 1982);

        return dummySensor;
    }
}
