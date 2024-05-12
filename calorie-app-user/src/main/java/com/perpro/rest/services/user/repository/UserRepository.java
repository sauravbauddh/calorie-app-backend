package com.perpro.rest.services.user.repository;

import com.perpro.rest.services.user.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
