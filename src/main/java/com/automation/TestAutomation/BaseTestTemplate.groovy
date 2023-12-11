package com.automation.TestAutomation

import groovy.json.JsonException
import org.json.JSONObject
import org.json.XML
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import spock.lang.Specification

class BaseTestTemplate extends Specification {
    private static final Logger logger = LoggerFactory.getLogger(BaseTestTemplate.class);

    static String getBasicAuthHeader() {
        String credentials = "userName:password";
        return new String(Base64.encodeBase64(credentials.getBytes()));
    }

    static JSONObject xmlToJson(String xmlString) {
        try {
            return XML.toJSONObject(xmlString)
        }
        catch (JsonException e) {
            logger.info(e.getMessage())
        }
    }
}