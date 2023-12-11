package com.automation.TestAutomation

import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate

class ApiTest extends BaseTestTemplate {

    def 'get method call'() {
        given: 'basic step'
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON)
        httpHeaders.add("Authorization", "apikey" + "apikey")
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_XML))

        HttpEntity<?> httpEntity = new HttpEntity<>(httpHeaders);

        when:
        ResponseEntity<String> response = restTemplate.exchange(URLConstants.url, HttpMethod.GET, httpEntity, String.class)
        logger.info("The Response code" + response.getStatusCode())

        then:
        true

    }
}
