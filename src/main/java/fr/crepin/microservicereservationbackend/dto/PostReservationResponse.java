package fr.crepin.microservicereservationbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostReservationResponse {
    private Boolean isValid;
    private String message;
    private ReservationDto reservationDto;
}
