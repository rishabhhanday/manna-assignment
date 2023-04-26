package aero.manna.assignment.controller;

import aero.manna.assignment.model.VenueRequest;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@SpringBootTest
class VenueControllerTest {
    @Autowired
    private VenueController venueController;

    @Test
    void testVenueForAllCities() throws IOException {
        List<String> cities = Arrays.asList("New York", "Seattle", "Chicago", "Los Angeles", "Austin", "Las Vegas", "Boston", "Miami");

        List<VenueRequest> venueRequests = new ObjectMapper()
                .readValue(new ClassPathResource("static/test-1.json").getFile(), new TypeReference<List<VenueRequest>>() {
                });

        ResponseEntity<Map<String, String>> venue = venueController
                .venue(venueRequests, 3, 15000);

        cities.forEach(city -> Assertions.assertTrue(venue.getBody().containsKey(city)));
    }

    @Test
    void testBestVenueForLasVegas() throws IOException {
        List<VenueRequest> venueRequests = new ObjectMapper()
                .readValue(new ClassPathResource("static/test-1.json").getFile(), new TypeReference<List<VenueRequest>>() {
                });

        ResponseEntity<Map<String, String>> venue = venueController
                .venue(venueRequests, 3, 15000);

        String actualVenueId = venue.getBody().get("Las Vegas");
        String expectedVenueId = "3833b97b-c710-490e-9503-99911b5e3015";
        VenueRequest idealVenue = venueRequests
                .stream().filter(venueRequest -> venueRequest.getId()
                        .equals(actualVenueId)).findFirst()
                .get();

        Assertions.assertEquals(expectedVenueId, expectedVenueId);
        Assertions.assertEquals(15000, idealVenue.getCapacity());
        Assertions.assertTrue(idealVenue.getMinimumTourDurationInDays() <= 3);
    }
}