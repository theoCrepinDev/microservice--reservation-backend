package fr.crepin.microservicereservationbackend.dao.repository;

import fr.crepin.microservicereservationbackend.dao.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ReservationsRepository extends JpaRepository<Reservation, UUID> {
    @Query("SELECT r FROM Reservation r WHERE r.user.username = :idUser")
    List<Reservation> findReservationByUser(@Param("idUser") String idUser);

    @Query("SELECT r FROM Reservation r WHERE r.idLogement = :idLogement")
    List<Reservation> findReservationByLogement(@Param("idLogement") UUID idLogement);
}
