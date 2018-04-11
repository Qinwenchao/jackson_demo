# Jackson demo
json与object的映射(序列化和反序列化)
## pom依赖
```
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-core</artifactId>
            <version>2.9.2</version>
        </dependency>

        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-annotations</artifactId>
            <version>2.9.2</version>
        </dependency>

        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.9.2</version>
        </dependency>
    </dependencies>

```
## Annotation    
The Jackson JSON toolkit contains a set of Java annotations which you can use to influence how JSON is read into objects, or what JSON is generated from the objects. This Jackson annotation tutorial explains how to use Jackson's annotations.

### Read + Write Annotations
-   @JsonIgnore     
    The Jackson annotation @JsonIgnore is used to tell Jackson to ignore a certain property (field) of a Java object. The property is ignored both when reading JSON into Java objects, and when writing Java objects into JSON. 
-   @JsonIgnoreProperties   
    The @JsonIgnoreProperties Jackson annotation is used to specify a list of properties of a class to ignore. The @JsonIgnoreProperties annotation is placed above the class declaration instead of above the individual properties (fields) to ignore. 
-   @JsonIgnoreType     
    The @JsonIgnoreType Jackson annotation is used to mark a whole type (class) to be ignored everywhere that type is used.
-   @JsonAutoDetect     
    The Jackson annotation @JsonAutoDetect is used to tell Jackson to include properties which are not public, both when reading and writing objects. Here is an example class showing you how you can use the @JsonAutoDetect annotation:

Read Annotations
- @JsonSetter   
The Jackson annotation @JsonSetter is used to tell Jackson that is should match the name of this setter method to a property name in the JSON data, when reading JSON into objects. This is useful if the property names used internally in your Java class is not the same as the property name used in the JSON file.
- @JsonAnySetter
The Jackson annotation @JsonAnySetter instructs Jackson to call the same setter method for all unrecognized fields in the JSON object. By "unrecognized" I mean all fields that are not already mapped to a property or setter method in the Java object.
- @JsonCreator  
- @JsonProperty
The Jackson annotation @JsonCreator is used to tell Jackson that the Java object has a constructor (a "creator") which can match the fields of a JSON object to the fields of the Java object.

Write Annotations
- @JsonInclude  
The Jackson annotation @JsonInclude tells Jackson only to include properties under certain circumstances. For instance, that properties should only be included if they are non-null, non-empty, or have non-default values. 

- @JsonGetter   
The @JsonGetter Jackson annotation is used to tell Jackson that a certain field value should be obtained from calling a getter method instead of via direct field access. The @JsonGetter annotation is useful if your Java class uses jQuery style for getter and setter names. 

- @JsonAnyGetter
The @JsonAnyGetter Jackson annotation enables you to use a Map as container for properties that you want to serialize to JSON

- @JsonRawValue     
The @JsonRawValue Jackson annotation tells Jackson that this property value should written directly as it is to the JSON output

- @JsonValue    

The Jackson annotation @JsonValue tells Jackson that Jackson should not attempt to serialize the object itself, but rather call a method on the object which serializes the object to a JSON string.

3. 参考文档
    - http://tutorials.jenkov.com/java-json/jackson-objectmapper.html