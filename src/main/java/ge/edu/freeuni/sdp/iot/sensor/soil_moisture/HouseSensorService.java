package ge.edu.freeuni.sdp.iot.sensor.soil_moisture;

import ge.edu.freeuni.sdp.iot.sensor.soil_moisture.core.HouseData;
import ge.edu.freeuni.sdp.iot.sensor.soil_moisture.model.SensorValue;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by nika on 6/22/16.
 */
@Path("/house/{houseid}")
@Produces( { MediaType.APPLICATION_JSON})
public class HouseSensorService {

    @GET
    public SensorValue get(@PathParam("houseid") String houseId) {
        return new SensorValue(houseId, 10.25);
    }

}
