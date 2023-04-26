package aero.manna.assignment.controller;

import aero.manna.assignment.api.VenueApi;
import aero.manna.assignment.model.VenueRequest;
import aero.manna.assignment.service.VenueService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@Slf4j
public class VenueController implements VenueApi {
    private VenueService venueService;

    @Override
    public ResponseEntity<Map<String, String>> venue(List<VenueRequest> venueRequests, Integer maxNumberOfDays, Integer capacity) {
        log.info("Venue mapping request received");
        return ResponseEntity.ok(venueService.findVenue(venueRequests, capacity, maxNumberOfDays));
    }
}
