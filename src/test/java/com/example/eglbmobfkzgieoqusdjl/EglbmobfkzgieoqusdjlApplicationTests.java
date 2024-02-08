package com.example.eglbmobfkzgieoqusdjl;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

@SpringBootTest
class EglbmobfkzgieoqusdjlApplicationTests {

    @Test
    void contextLoads() {
    }

    @LocalServerPort
    private int port;

    private String baseUrl;

    private TestRestTemplate restTemplate;

    @BeforeMethod
    public void setUp() {
        baseUrl = "http://localhost:" + port;
        restTemplate = new TestRestTemplate();
    }

    @Test
    public void testGreetEndpoint() {
        String url = baseUrl + "/api/v1/customer/greet";
        String response = restTemplate.getForObject(url, String.class);

        assertEquals(response, "hello greetgo");
    }
}
