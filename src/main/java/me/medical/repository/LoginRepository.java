package me.medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import me.medical.model.LoginModel;

public interface LoginRepository extends JpaRepository<LoginModel, Integer> {
}