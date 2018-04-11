package com.qinwenchao.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Main {
    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.configure(
                // ignore unknown fields
                DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        ;

    }

    private static void readFromFile() throws IOException {
        objectMapper = new ObjectMapper();
        File file = new File("data/car.json");

        Car car = objectMapper.readValue(file, Car.class);
        System.out.println(car);
    }


    private static void readFromString() throws IOException {
        objectMapper = new ObjectMapper();

        String carJson =
                "{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";

        Car car = objectMapper.readValue(carJson, Car.class);
        System.out.println(car);
    }

    private static void readFromUri() throws IOException {
        objectMapper = new ObjectMapper();
        // http://jenkov.com/some-data.json
        URL url = new URL("file:data/car.json");
        Car car = objectMapper.readValue(url, Car.class);
        System.out.println(car);
    }

    private static void readFromInputStream() throws IOException {
        objectMapper = new ObjectMapper();
        InputStream input = Main.class.getResourceAsStream("car.json");
        Car car = objectMapper.readValue(input, Car.class);
        System.out.println(car);
    }

    private static void readFromJsonByteArray() throws IOException {
        objectMapper = new ObjectMapper();
        String carJson =
                "{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";
        byte[] bytes = carJson.getBytes("UTF-8");
        Car car = objectMapper.readValue(bytes, Car.class);
        System.out.println(car);
    }

    private static void readObjectArray() throws IOException {
        objectMapper = new ObjectMapper();
        File file = new File("data/car_array.json");

        Car[] cars = objectMapper.readValue(file, Car[].class);
        List<Car> cars1 = objectMapper.readValue(file, new TypeReference<List<Car>>() {
        });

        System.out.println(Arrays.toString(cars));
        System.out.println(cars1);
    }

    private static void readJsonToMap() throws IOException {
        String carJson =
                "{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> jsonMap = objectMapper.readValue(carJson,
                new TypeReference<Map<String, Object>>() {
                });
        System.out.println(jsonMap);
    }

    private static void writeObjectToJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = new Car();
        car.setBrand("BMW");
        car.setDoors(4);
        objectMapper.writeValue(
                new FileOutputStream("data/output_car.json"), car);

    }

    private static void writeObjectToJsonBytes() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = new Car();
        car.setBrand("BMW");
        car.setDoors(4);
        byte[] b = objectMapper.writeValueAsBytes(car);
        System.out.println(b.length);

    }

    private static void writeObjectWithDate(boolean convertFormat) throws JsonProcessingException {
        Transaction transaction = new Transaction("transfer", new Date());

        ObjectMapper objectMapper = new ObjectMapper();
        if (convertFormat) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            objectMapper.setDateFormat(dateFormat);
        }
        String output = objectMapper.writeValueAsString(transaction);
        System.out.println(output);

    }

    private static void readJsonToTreeNode() {
        String carJson =
                "{ \"brand\" : \"Mercedes\", \"doors\" : 5," +
                        "  \"owners\" : [\"John\", \"Jack\", \"Jill\"]," +
                        "  \"nestedObject\" : { \"field\" : \"value\" } }";

        ObjectMapper objectMapper = new ObjectMapper();


        try {

            JsonNode node = objectMapper.readValue(carJson, JsonNode.class);

            JsonNode brandNode = node.get("brand");
            String brand = brandNode.asText();
            System.out.println("brand = " + brand);

            JsonNode doorsNode = node.get("doors");
            int doors = doorsNode.asInt();
            System.out.println("doors = " + doors);

            JsonNode array = node.get("owners");
            JsonNode jsonNode = array.get(0);
            String john = jsonNode.asText();
            System.out.println("john  = " + john);

            JsonNode child = node.get("nestedObject");
            JsonNode childField = child.get("field");
            String field = childField.asText();
            System.out.println("field = " + field);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        readFromString();
        readFromFile();
        readFromUri();
        readFromInputStream();
        readFromJsonByteArray();
        readObjectArray();
        readJsonToMap();
        writeObjectToJson();
        writeObjectToJsonBytes();
        writeObjectWithDate(false);
        writeObjectWithDate(true);
        readJsonToTreeNode();
    }
}
