package aero.manna.assignment.service.impl;

import aero.manna.assignment.model.VenueRequest;
import aero.manna.assignment.service.VenueResponseMapper;
import aero.manna.assignment.service.VenueService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@AllArgsConstructor
public class VenueServiceImpl implements VenueService {
    private VenueResponseMapper<Map<String, String>> venueResponseMapper;

    private boolean isNewVenuePreferredOverCurrent(VenueRequest newVenue, VenueRequest currentVenue) {
        return currentVenue.getCapacity() < newVenue.getCapacity();
    }

    @Override
    public Map<String, String> findVenue(List<VenueRequest> venueRequests, Integer capacity, Integer maxNumberOfDays) {
        Map<String, VenueRequest> cityVenueMap = new HashMap<>();

        for (VenueRequest newVenue : venueRequests) {
            if (isIdealVenue(capacity, maxNumberOfDays, newVenue)) {
                log.debug("Ideal venue found for city={}, id={}", newVenue.getCity(), newVenue.getId());
                cityVenueMap.put(newVenue.getCity(), newVenue);
            } else if (newVenue.getCapacity() < capacity && newVenue.getMinimumTourDurationInDays() < maxNumberOfDays) {
                if (cityVenueMap.containsKey(newVenue.getCity())) {
                    VenueRequest currentVenue = cityVenueMap.get(newVenue.getCity());
                    if (isNewVenuePreferredOverCurrent(newVenue, currentVenue)) {
                        log.debug("New venue found for city={}, id={}", newVenue.getCity(), newVenue.getId());
                        cityVenueMap.put(newVenue.getCity(), newVenue);
                    }
                } else {
                    cityVenueMap.put(newVenue.getCity(), newVenue);
                }
            }
        }

        return venueResponseMapper.convert(cityVenueMap);
    }

    private boolean isIdealVenue(Integer capacity, Integer maxNumberOfDays, VenueRequest newVenue) {
        return newVenue.getCapacity().equals(capacity) && newVenue.getMinimumTourDurationInDays() <= maxNumberOfDays;
    }
}
