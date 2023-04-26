package aero.manna.assignment.service.impl;

import aero.manna.assignment.model.VenueRequest;
import aero.manna.assignment.service.VenueResponseMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class VenueIdResponseMapper implements VenueResponseMapper<Map<String, String>> {
    @Override
    public Map<String, String> convert(Map<String, VenueRequest> venueRequests) {
        Map<String, String> venueResponse = new HashMap<>();

        for (Map.Entry<String, VenueRequest> entry : venueRequests.entrySet()) {
            venueResponse.put(entry.getKey(), entry.getValue().getId());
        }

        return venueResponse;
    }
}
