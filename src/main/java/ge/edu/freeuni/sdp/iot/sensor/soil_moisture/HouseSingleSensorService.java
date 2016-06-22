package ge.edu.freeuni.sdp.iot.sensor.soil_moisture;

/**
 * Created by khrak on 6/22/16.
 */

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;


@Path("/house/{houseid}/sensor/{sensorid}")
public class HouseSingleSensorService {

    @GET
    public Response get(@PathParam("houseid") String houseid, @PathParam("sensorid") String sensorid) {
        HouseData houseData = HouseData.getInstance();
        HouseSensorData sensorData;

        try {
            Integer houseIntegerid = Integer.valueOf(houseid);
            Integer sensorIntegerid = Integer.valueOf(sensorid);

            sensorData = houseData.get(houseIntegerid);
            SensorValue sensorValues = sensorData.get(sensorIntegerid);
            Double sensorValue = sensorValues.getSensorValue();

            StringBuilder builder = new StringBuilder("{");

            if (sensorValue != null)
                builder.append("\"value\": ");
            else
                builder.append("\"lastvalue\": ");
            builder.append(sensorValue);

            builder.append("}");
            
            return Response.ok().entity(builder.toString()).build();
        } catch (NumberFormatException|NullPointerException e) {
            return Response.status(404).build();
        }
    }

}
