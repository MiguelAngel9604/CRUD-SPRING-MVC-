package com.proyecto.main.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.main.entity.Curso;
public interface CursoRepository extends JpaRepository<Curso,Integer> {

}
