package ge.edu.freeuni.sdp.iot.sensor.soil_moisture;

import ge.edu.freeuni.sdp.iot.sensor.soil_moisture.core.HouseData;
import ge.edu.freeuni.sdp.iot.sensor.soil_moisture.core.SensorValue;
import ge.edu.freeuni.sdp.iot.sensor.soil_moisture.model.SensorRequest;
import ge.edu.freeuni.sdp.iot.sensor.soil_moisture.model.SensorValueMessage;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by nika on 6/22/16.
 */
@Path("/house/{houseid}")
@Produces( { MediaType.APPLICATION_JSON})
public class HouseSensorService {

    @GET
    public SensorValueMessage get(@PathParam("houseid") String houseId) {
        HouseData houseData = HouseData.getInstance();
        SensorValue sensorValue = houseData.get(houseId);

        if (sensorValue == null)
            throw new NotFoundException();

        return new SensorValueMessage(houseId, sensorValue.getSensorValue(), sensorValue.isAvailable());
    }

    @POST
    public Response post(@PathParam("houseid") String houseId,
                         String requestStr) {
        SensorRequest request = SensorRequest.fromJson(new JSONObject(requestStr));

        HouseData houseData = HouseData.getInstance();
        
        houseData.put(houseId, new SensorValue(request.getSensorValue(), houseId));

        return Response.ok().build();
    }
}
