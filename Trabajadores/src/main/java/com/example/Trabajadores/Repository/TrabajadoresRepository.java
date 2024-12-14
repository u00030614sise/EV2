/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Trabajadores.Repository;

/**
 *
 * @author Usuario
 */
import com.example.Trabajadores.Model.Trabajadores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabajadoresRepository extends JpaRepository<Trabajadores, Long> {
}