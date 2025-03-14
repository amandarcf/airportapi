/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.eti.amanda.airports.service;

import br.eti.amanda.airports.entities.Airport;
import br.eti.amanda.airports.repositories.AirportRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sesideva
 */
@Service
public class AirportService {
 @Autowired
 private AirportRepository airportRepository;
 
 public List<Airport> findAll() {
     
     List<Airport> result = airportRepository.findAll();
     return result;
 }
}
