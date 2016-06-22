package ge.edu.freeuni.sdp.iot.sensor.soil_moisture;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * Created by nika on 6/22/16.
 */
@Path("/house/{houseid}")
public class HouseSensorService {

    @GET
    public Response get(@PathParam("houseid") String houseId) {
        HouseData data = HouseData.getInstance();
        HouseSensorData sensorData;
        Integer id;
        try {
            id = Integer.valueOf(houseId);
            sensorData = data.get(id);
            StringBuilder builder = new StringBuilder("{");

            builder.append(" \"sensors\" : [ ");
            boolean first = true;
            for (SensorValue v : sensorData.getValues()) {
                if (first)
                    first = false;
                else
                    builder.append(", ");

                builder.append("{");
                Double value = v.getSensorValue();
                builder.append("\"sensorid\": ").append(v.getSensorId()).append(", ");

                builder.append("\"available\": ");
                if (value != null)
                    builder.append("\"yes\"");
                else
                    builder.append("\"no\"");
                builder.append(", ");

                if (value != null)
                    builder.append("\"value\": ");
                else
                    builder.append("\"lastvalue\": ");
                builder.append(value).append(", ");

                builder.append("}");
            }
            builder.append("]");

            builder.append("}");

            return Response.ok().entity(builder.toString()).build();
        } catch (NumberFormatException|NullPointerException e) {
            return Response.status(404).build();
        }
    }

}
