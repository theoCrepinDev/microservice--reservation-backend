package fr.crepin.microservicereservationbackend.converter;

import fr.crepin.microservicereservationbackend.dao.entity.Reservation;
import fr.crepin.microservicereservationbackend.dao.entity.UserData;
import fr.crepin.microservicereservationbackend.dto.ReservationDto;
import fr.crepin.microservicereservationbackend.enums.ReservationStatus;

import java.util.UUID;

public class ReservationConverter {

    public static Reservation reservationDtoToReservationConverter(ReservationDto reservationDto){
        Reservation reservation = new Reservation();
        reservation.setId(reservationDto.getId() != null && !reservationDto.getId().isEmpty() ? UUID.fromString(reservationDto.getId()) : null);
        reservation.setIdLogement(UUID.fromString(reservationDto.getIdLogement()));
        var user = new UserData();
        user.setId(UUID.fromString(reservationDto.getIdUser()));
        reservation.setUser(user);
        reservation.setDateDebut(reservationDto.getDateDebut());
        reservation.setDateFin(reservationDto.getDateFin());
        reservation.setNbrPersonnes(reservationDto.getNbrPersonnes());
        reservation.setPrix(reservationDto.getPrix());
        reservation.setStatus(reservationDto.getStatus() != null && !reservationDto.getStatus().isEmpty() ? ReservationStatus.valueOf(reservationDto.getStatus()) : ReservationStatus.PENDING);
        return reservation;
    }

    public static ReservationDto reservationToReservationDtoConverter(Reservation reservation){
        return ReservationDto.builder()
                .id(reservation.getId().toString())
                .idLogement(reservation.getIdLogement().toString())
                .idUser(reservation.getUser().getId().toString())
                .dateDebut(reservation.getDateDebut())
                .dateFin(reservation.getDateFin())
                .nbrPersonnes(reservation.getNbrPersonnes())
                .prix(reservation.getPrix())
                .status( reservation.getStatus().name())
                .build();
    }
}
