package fr.crepin.microservicereservationbackend.dao.repository;

import fr.crepin.microservicereservationbackend.dao.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRoleRepository extends JpaRepository<UserRole, UUID> {
}
