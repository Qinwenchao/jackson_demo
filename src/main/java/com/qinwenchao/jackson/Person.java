package com.qinwenchao.jackson;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Person {

    private long personId = 0;
    private String name = null;

    @JsonGetter("id")
    public long getPersonId() {
        return this.personId;
    }

    @JsonSetter("id")
    // json id <-> personId
    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("name:%s id:%s", name, personId);
    }

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Person person = new Person();
        person.setPersonId(111);
        String s = objectMapper.writeValueAsString(person);
        System.out.println(s);


        String json =
                "{ \"name\" : \"bb\", \"id\" : 5 }";
        Person person1 = objectMapper.readValue(json,
                new TypeReference<Person>() {
                });
        System.out.println(person1);


    }
}