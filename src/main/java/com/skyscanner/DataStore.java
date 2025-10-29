package com.skyscanner;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
import java.util.List;

public class DataStore {
    private final List<SearchResult> hotels;
    private final List<SearchResult> cars;

    public DataStore() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            try (InputStream hotelStream = getClass().getResourceAsStream("/hotels.json");
                 InputStream carStream = getClass().getResourceAsStream("/rental_cars.json")) {

                hotels = mapper.readValue(hotelStream, new TypeReference<List<SearchResult>>() {});
                cars = mapper.readValue(carStream, new TypeReference<List<SearchResult>>() {});
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to load JSON files", e);
        }
    }

    public List<SearchResult> getHotels() {
        return hotels;
    }

    public List<SearchResult> getCars() {
        return cars;
    }
}
