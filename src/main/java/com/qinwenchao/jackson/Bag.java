package com.qinwenchao.jackson;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Bag {
    private Map<String, Object> properties = new HashMap<>();

    @JsonAnySetter
    public void set(String fieldName, Object value) {
        this.properties.put(fieldName, value);
    }

    public Object get(String fieldName) {
        return this.properties.get(fieldName);
    }

    @JsonAnyGetter
    public Map<String, Object> properties() {
        return properties;
    }

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json =
                "{ \"name\" : \"bb\", \"id\" : 5 }";
        Bag bag = objectMapper.readValue(json, Bag.class);
        System.out.println(bag.properties);
        bag.properties.put("age", 100);
        System.out.println(objectMapper.writeValueAsString(bag));

    }
}