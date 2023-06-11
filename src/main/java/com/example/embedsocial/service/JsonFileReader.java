package com.example.embedsocial.service;

import com.example.embedsocial.model.Review;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonFileReader {
    public List<Review> readReviewsFromFile(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(filePath);

        return objectMapper.readValue(file, new TypeReference<List<Review>>() {});
    }
}
