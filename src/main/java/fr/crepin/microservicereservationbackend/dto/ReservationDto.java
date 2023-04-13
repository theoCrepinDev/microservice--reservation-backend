package fr.crepin.microservicereservationbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDto {
    private String id;
    private String idLogement;
    private String idUser;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private int nbrPersonnes;
    private int prix;
    private String status;
}
