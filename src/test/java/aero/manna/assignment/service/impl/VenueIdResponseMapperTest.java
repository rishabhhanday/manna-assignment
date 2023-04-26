package aero.manna.assignment.service.impl;

import aero.manna.assignment.model.VenueRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class VenueIdResponseMapperTest {
    private VenueIdResponseMapper venueResponseMapper = new VenueIdResponseMapper();

    @Test
    void convert() {
        Map<String, VenueRequest> venues = new HashMap<>();
        VenueRequest v1 = new VenueRequest();
        v1.setId("123");
        v1.setCity("Seattle");
        venues.put(v1.getCity(), v1);

        VenueRequest v2 = new VenueRequest();
        v2.setId("456");
        v2.setCity("Bangalore");

        venues.put(v2.getCity(), v2);

        Map<String, String> venueId = venueResponseMapper.convert(venues);

        Assertions.assertEquals("123", venueId.get("Seattle"));
        Assertions.assertEquals("456", venueId.get("Bangalore"));
    }
}