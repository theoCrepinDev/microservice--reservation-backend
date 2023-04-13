package fr.crepin.microservicereservationbackend.service;

import fr.crepin.microservicereservationbackend.config.JwtService;
import fr.crepin.microservicereservationbackend.converter.ReservationConverter;
import fr.crepin.microservicereservationbackend.dao.entity.Reservation;
import fr.crepin.microservicereservationbackend.dao.repository.ReservationsRepository;
import fr.crepin.microservicereservationbackend.dto.ReservationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ReservationServiceImpl implements ReservationService{

    private ReservationsRepository repository;

    private JwtService jwtService;

    @Autowired
    public ReservationServiceImpl(ReservationsRepository repository, JwtService jwtService){
        this.repository = repository;
        this.jwtService = jwtService;
    }
    @Override
    public List<Reservation> getUserReservations(String token) {
        String username = jwtService.extractUsernameOrEmail(token);
        try{
            return repository.findReservationByUser(username);
        }catch (Exception e){
            throw new IllegalArgumentException("Error when getting logements for this user");
        }
    }

    @Override
    public List<Reservation> getAllReservations(){
        return repository.findAll();
    }

    @Override
    public Reservation postReservation(ReservationDto reservationDto){
        Reservation reservation = ReservationConverter.reservationDtoToReservationConverter(reservationDto);
        return repository.save(reservation);
    }

    @Override
    public List<Reservation> getLogementReservations(String logementId){
        return repository.findReservationByLogement(UUID.fromString(logementId));
    }
}
