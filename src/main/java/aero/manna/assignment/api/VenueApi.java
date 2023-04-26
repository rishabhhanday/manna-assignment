package aero.manna.assignment.api;

import aero.manna.assignment.model.VenueRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface VenueApi {
    @PostMapping("/venue")
    ResponseEntity<Map<String, String>> venue(@RequestBody List<VenueRequest> venueRequests,
                                              @RequestParam(required = false, defaultValue = "3") Integer maxNumberOfDays,
                                              @RequestParam(required = false, defaultValue = "15000") Integer capacity);
}
