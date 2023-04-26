package aero.manna.assignment.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VenueRequest {
    private String id;
    private String name;
    private String city;
    private String state;
    private String country;
    private Integer capacity;
    @JsonProperty("minimum_tour_duration_in_days")
    private Integer minimumTourDurationInDays;
}
