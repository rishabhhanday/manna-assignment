package aero.manna.assignment.service;

import aero.manna.assignment.model.VenueRequest;

import java.util.List;
import java.util.Map;

public interface VenueService {
    Map<String, String> findVenue(List<VenueRequest> venueRequests, Integer capacity, Integer maxNumberOfDays);
}
