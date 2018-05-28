package com.project.anpr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.anpr.model.Login;
import com.project.anpr.util.Status;

public interface LoginRepository extends JpaRepository<Login,Long> {


	Login findLoginByEmailAndStatusNot(String email, Status delete);

}
