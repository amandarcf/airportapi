/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.eti.amanda.airports.controllers;

import br.eti.amanda.airports.DTO.AirportMinDTO;
import br.eti.amanda.airports.entities.Airport;
import br.eti.amanda.airports.service.AirportService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sesideva
 */
@RestController
public class AirportController {

    @Autowired
    private AirportService airportService;

    /**
     * Endpoint /airports/airport Retorna TODOS os aeroportos da base de dados.
     *
     * @return
     */
    @GetMapping("/airport")
    public List<Airport> findAll() {
        List<Airport> result = airportService.findAll();
        return result;
    }

    @GetMapping("/country/{countryName}")
    public ResponseEntity<List<AirportMinDTO>> findByCountryIgnoreCase(@PathVariable String countryName) {

        List<AirportMinDTO> result = airportService.findByCountry(countryName);

        if (result.isEmpty()) {

            return ResponseEntity.notFound().build();
        } else {

            return ResponseEntity.ok(result);
        }
    }

    
    
}
