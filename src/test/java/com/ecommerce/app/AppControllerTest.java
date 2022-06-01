package com.ecommerce.app;


import com.ecommerce.app.controller.request.SearchDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.time.LocalDateTime;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AppControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private final String HOST_IP = "http://localhost:";

    private final String URL = "/api/v1/";


    @Test
    public void checkPrices() throws Exception {
        SearchDTO search = new SearchDTO();
        search.setBrandId(1);
        search.setProductId(35455);

        search.setDate(LocalDateTime.of(2020, Month.JUNE, 14, 10, 00, 00));
        assertThat(restTemplate.postForObject(HOST_IP + port + URL + "/search/price", search,
                String.class)).contains("\"price\":35.5,");

        search.setDate(LocalDateTime.of(2020, Month.JUNE, 14, 16, 00, 00));
        assertThat(restTemplate.postForObject(HOST_IP + port + URL + "/search/price", search,
                String.class)).contains("\"price\":25.45,");

        search.setDate(LocalDateTime.of(2020, Month.JUNE, 14, 21, 00, 00));
        assertThat(restTemplate.postForObject(HOST_IP + port + URL + "/search/price", search,
                String.class)).contains("\"price\":35.5,");

        search.setDate(LocalDateTime.of(2020, Month.JUNE, 15, 10, 00, 00));
        assertThat(restTemplate.postForObject(HOST_IP + port + URL + "/search/price", search,
                String.class)).contains("\"price\":30.5,");

        search.setDate(LocalDateTime.of(2020, Month.JUNE, 16, 21, 00, 00));
        assertThat(restTemplate.postForObject(HOST_IP + port + URL + "/search/price", search,
                String.class)).contains("\"price\":38.95,");

    }

}