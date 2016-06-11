package ge.edu.freeuni.sdp.iot.sensor.soil_moisture;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Created by khrak on 6/11/16.
 */
@Path("/ping")
public class PingService {

    @GET
    public Response get() {
        return Response.ok().build();
    }

}
