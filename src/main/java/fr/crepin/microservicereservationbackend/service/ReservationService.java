package fr.crepin.microservicereservationbackend.service;

import fr.crepin.microservicereservationbackend.dao.entity.Reservation;
import fr.crepin.microservicereservationbackend.dto.ReservationDto;

import java.util.List;

public interface ReservationService {
    List<Reservation> getUserReservations(String token);
    List<Reservation> getAllReservations();
    Reservation postReservation(ReservationDto reservationDto);
    List<Reservation> getLogementReservations(String logementId);
}
