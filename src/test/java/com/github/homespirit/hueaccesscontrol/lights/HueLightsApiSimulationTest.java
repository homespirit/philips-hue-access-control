package com.github.homespirit.hueaccesscontrol.lights;

import com.github.homespirit.hueaccesscontrol.bridge.config.BridgeConfig;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HueLightsApiSimulationTest {

    private RestTemplate restTemplate;

    @Autowired
    private TestRestTemplate proxyRestTemplate;

    @Autowired
    private BridgeConfig bridgeConfig;

    @Autowired
    private LightsApi lightsApi;

    @Before
    public void setup() {
        restTemplate = new RestTemplate();
    }

    @Test
    public void testList() throws JSONException {
        var directResponse = restTemplate.exchange(
                bridgeConfig.createPath(bridgeConfig.getUser(), lightsApi.path()),
                HttpMethod.GET,
                null,
                String.class
        );

        var proxiedResponse = proxyRestTemplate.exchange(
                LightsController.PATH,
                HttpMethod.GET,
                null,
                String.class,
                "userId"
        );
        assertEquals(directResponse.getStatusCode(), directResponse.getStatusCode());
        assertEquals(directResponse.getHeaders(), directResponse.getHeaders());
        JSONAssert.assertEquals(directResponse.getBody(), proxiedResponse.getBody(), JSONCompareMode.STRICT_ORDER);
    }

    @Test
    public void testRead() throws JSONException {
        var directResponse = restTemplate.exchange(
                bridgeConfig.createPath(bridgeConfig.getUser(), lightsApi.path(1)),
                HttpMethod.GET,
                null,
                String.class
        );

        var proxiedResponse = proxyRestTemplate.exchange(
                LightsController.PATH + "/1",
                HttpMethod.GET,
                null,
                String.class,
                "userId"
        );
        assertEquals(directResponse.getStatusCode(), directResponse.getStatusCode());
        assertEquals(directResponse.getHeaders(), directResponse.getHeaders());
        JSONAssert.assertEquals(directResponse.getBody(), proxiedResponse.getBody(), JSONCompareMode.STRICT_ORDER);
    }

}
