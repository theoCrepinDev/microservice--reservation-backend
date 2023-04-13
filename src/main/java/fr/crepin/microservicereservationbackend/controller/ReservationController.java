package fr.crepin.microservicereservationbackend.controller;

import fr.crepin.microservicereservationbackend.converter.ReservationConverter;
import fr.crepin.microservicereservationbackend.dao.entity.Reservation;
import fr.crepin.microservicereservationbackend.dto.GetReservationLogementResponse;
import fr.crepin.microservicereservationbackend.dto.PostReservationResponse;
import fr.crepin.microservicereservationbackend.dto.ReservationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import fr.crepin.microservicereservationbackend.service.ReservationService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "${front.url}")
public class ReservationController {
    private final ReservationService service;

    @Autowired
    public ReservationController(final ReservationService reservationService){
        this.service = reservationService;
    }

    @GetMapping("/reservations/me")
    public List<ReservationDto> getUserReservations(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String language){
        List<Reservation> reservation = this.service.getUserReservations(language.split(" ")[1]);
        return reservation.stream().map(ReservationConverter::reservationToReservationDtoConverter).toList();
    }

    @GetMapping("/reservations")
    public List<ReservationDto> getAllReservation(){
        return service.getAllReservations().stream().map(ReservationConverter::reservationToReservationDtoConverter).toList();
    }
    @GetMapping("/logement/reservations")
    public ResponseEntity<GetReservationLogementResponse> getLogementReservations(@RequestParam(name = "logement-id") String logementId){
        try{
            return new ResponseEntity<>(GetReservationLogementResponse.builder()
                    .isValid(true)
                    .resevations(service.getLogementReservations(logementId).stream().map(ReservationConverter::reservationToReservationDtoConverter).toList())
                    .build(),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(GetReservationLogementResponse.builder()
                    .isValid(false)
                    .message("Exception caugth when saving reservation : \n" + e.getMessage() )
                    .build(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/reservations")
    public ResponseEntity<PostReservationResponse> postReservation(
            @RequestBody ReservationDto reservationDto
    ){
        try{
            return new ResponseEntity<>(PostReservationResponse.builder()
                    .isValid(true)
                    .message("Reservation has been saved")
                    .reservationDto(ReservationConverter.reservationToReservationDtoConverter(service.postReservation(reservationDto)))
                    .build(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(PostReservationResponse.builder()
                    .isValid(false)
                    .message("Exception caugth when saving reservation : \n" + e.getMessage() )
                    .build(), HttpStatus.BAD_REQUEST);
        }
    }
}
