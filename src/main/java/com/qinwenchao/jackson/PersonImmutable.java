package com.qinwenchao.jackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class PersonImmutable {

    private long   id   = 0;
    private String name = null;

    @JsonCreator
    public PersonImmutable(
            @JsonProperty("id")  long id,
            @JsonProperty("name") String name  ) {

        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) throws IOException {
        String json =
                "{ \"name\" : \"bb\", \"id\" : 5 }";
        PersonImmutable person1 = new ObjectMapper().readValue(json,
                new TypeReference<PersonImmutable>() {
                });
        System.out.println(person1.name);


    }
}