package ge.edu.freeuni.sdp.iot.sensor.soil_moisture;

/**
 * Created by khrak on 6/22/16.
 */

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;


@Path("/house/{houseid}/sensor/{sensorid}")
public class HouseSingleSensorService {

    @GET
    public String get(@PathParam("houseid") String houseid, @PathParam("sensorid") String sensorid) {
        return "{\n" +
                "            \"value\" : 27.234\n" +
                "}";
    }

}
