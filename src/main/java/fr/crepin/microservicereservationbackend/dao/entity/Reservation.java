package fr.crepin.microservicereservationbackend.dao.entity;


import fr.crepin.microservicereservationbackend.enums.ReservationStatus;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(schema = "microservice", name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue
    private UUID id;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user")
    private UserData user;
    @Column(name = "id_logement")
    private UUID idLogement;
    @Column(name = "date_debut")
    private LocalDate dateDebut;
    @Column(name = "date_fin")
    private LocalDate dateFin;
    @Column(name = "nbr_personnes")
    private int nbrPersonnes;
    private int prix;

    @Enumerated(EnumType.STRING)
    private ReservationStatus status;

    public Reservation() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public UUID getIdLogement() {
        return idLogement;
    }

    public UserData getUser() {
        return user;
    }

    public void setUser(UserData user) {
        this.user = user;
    }

    public void setIdLogement(UUID idLogement) {
        this.idLogement = idLogement;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public int getNbrPersonnes() {
        return nbrPersonnes;
    }

    public void setNbrPersonnes(int nbrPersonnes) {
        this.nbrPersonnes = nbrPersonnes;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
}
