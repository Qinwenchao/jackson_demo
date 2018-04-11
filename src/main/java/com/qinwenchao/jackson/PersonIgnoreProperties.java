package com.qinwenchao.jackson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"firstName", "lastName"})
public class PersonIgnoreProperties {

    public long    personId = 0;

    public String  firstName = null;
    public String  lastName  = null;

}