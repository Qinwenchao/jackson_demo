package com.qinwenchao.jackson;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PersonIgnore {

    @JsonIgnore
    public long personId = 0;

    public String name = null;
}