package com.proyecto.main.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.main.entity.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante,Integer> {

}
