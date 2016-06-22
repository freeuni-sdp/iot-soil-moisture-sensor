package ge.edu.freeuni.sdp.iot.sensor.soil_moisture;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * Created by nika on 6/22/16.
 */
@Path("/house/{houseid}")
public class HouseSensorService {

    @GET
    public String get(@PathParam("houseid") String id) {
        return "{   \n" +
                "            \"sensors\" : [\n" +
                "                {\n" +
                "                    \"sendorid\" : 15,\n" +
                "                    \"available\" : \"yes\",\n" +
                "                    \"value\" : 24.22\n" +
                "                },\n" +
                "                {\n" +
                "                    \"sendorid\" : 16,\n" +
                "                    \"available\" : \"yes\",\n" +
                "                    \"value\" : 22.022\n" +
                "                },\n" +
                "                {\n" +
                "                    \"sendorid\" : 17,\n" +
                "                    \"available\" : \"no\",\n" +
                "                    \"lastvalue\" : 17.02\n" +
                "                },\n" +
                "                {\n" +
                "                    \"sendorid\" : 18,\n" +
                "                    \"available\" : \"no\",\n" +
                "                    \"lastvalue\" : null\n" +
                "                }\n" +
                "            ]\n" +
                "        }";
    }

}
