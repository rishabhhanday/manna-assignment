package aero.manna.assignment.service;

import aero.manna.assignment.model.VenueRequest;

import java.util.Map;

public interface VenueResponseMapper<T> {
    T convert(Map<String, VenueRequest> venueRequests);
}
