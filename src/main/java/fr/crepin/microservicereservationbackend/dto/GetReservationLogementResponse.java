package fr.crepin.microservicereservationbackend.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetReservationLogementResponse {
    private Boolean isValid;
    private String message;
    private List<ReservationDto> resevations;
}
