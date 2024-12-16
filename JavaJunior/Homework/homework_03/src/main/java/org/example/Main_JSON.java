package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Main_JSON {
    public static void main(String[] args) {
        Student_JSON toSerialize = new Student_JSON("Bob", 22, 4.4);
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.writeValue(new File("src/main/resources/data.json"), toSerialize);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            Student_JSON toDeSerialize = objectMapper.readValue(new File("src/main/resources/data.json"), Student_JSON.class);
            System.out.println(toDeSerialize);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
