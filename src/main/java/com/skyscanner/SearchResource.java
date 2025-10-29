package com.skyscanner;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.stream.Collectors;

@Path("/search")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SearchResource {
    private final List<SearchResult> results;

    public SearchResource(List<SearchResult> results) {
        this.results = results;
    }

    @POST
    public List<SearchResult> search(Search search) {
        String city = search.getCity();
        return results.stream()
                .filter(r -> r.getCity() != null && r.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }
}
