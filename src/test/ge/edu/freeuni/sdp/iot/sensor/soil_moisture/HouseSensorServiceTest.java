package ge.edu.freeuni.sdp.iot.sensor.soil_moisture;

import ge.edu.freeuni.sdp.iot.sensor.soil_moisture.core.HouseData;
import ge.edu.freeuni.sdp.iot.sensor.soil_moisture.core.SensorValue;
import ge.edu.freeuni.sdp.iot.sensor.soil_moisture.model.SensorRequest;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.hamcrest.Matcher;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.matchers.Any;
import org.mockito.internal.verification.Times;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * Created by nika on 7/11/16.
 */
public class HouseSensorServiceTest extends JerseyTest {

    @Mock private HouseData data;
    private String houseId;

    @Override
    protected Application configure() {
        return new ResourceConfig(HouseSensorService.class);
    }

    @Before
    public void setUpChild() throws Exception {
        houseId = "3c5afb74-2e82-4f10-9931-89187fe47adf";

        MockitoAnnotations.initMocks(this);
        HouseData.setTestInstance(data);
        HouseData.setTestMode(true);
    }

    @After
    public void tearDownChild() throws Exception {
        HouseData.setTestMode(false);
    }


    @Test
    public void get_correct_200() throws Exception {
        double value = 1.0;
        SensorValue sensorValue = new SensorValue(value, houseId);
        when(data.get(houseId)).thenReturn(sensorValue);

        Response response = target("/house/" + houseId).request().get();
        assertEquals(200, response.getStatus());

        String strResp = response.readEntity(String.class);
        JSONObject respJson = new JSONObject(strResp);

        assertEquals(value, respJson.getDouble("sensorValue"), 0.00000001);
        assertEquals(houseId, respJson.getString("houseId"));
        assertTrue(respJson.getBoolean("available"));
    }

    @Test
    public void get_unavailable_404() throws Exception {
        when(data.get(houseId)).thenReturn(null);
        Response response = target("/house/" + houseId).request().get();
        assertEquals(404, response.getStatus());
    }

    @Test
    public void postCheckStatusCodeFore200() throws Exception {
        double value = 20.12;

        String postBody = "{\"sensorValue\": " + value + "}";

        when(data.contains(houseId)).thenReturn(true);

        Response response;
        response = target("/house/" + houseId).request()
                .post(Entity.entity(postBody, MediaType.APPLICATION_JSON_TYPE));

        assertEquals(200, response.getStatus());
    }

    @Test
    public void checkForCallingPutMethodOfHouseData() throws Exception {
        double value = 20.12;

        String postBody = "{\"sensorValue\": " + value + "}";


        when(data.contains(houseId)).thenReturn(true);

        Response response;
        response = target("/house/" + houseId).request()
                .post(Entity.entity(postBody, MediaType.APPLICATION_JSON_TYPE));

        assertEquals(200, response.getStatus());

        SensorValue sensorValue = new SensorValue(value, houseId);

        verify(data).put(houseId, sensorValue);
    }
}