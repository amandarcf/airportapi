/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.eti.amanda.airports.controllers;

import br.eti.amanda.airports.DTO.AirportMinDTO;
import br.eti.amanda.airports.DTO.AirportNearMeDTO;
import br.eti.amanda.airports.entities.Airport;
import br.eti.amanda.airports.service.AirportService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sesideva
 */

@RestController
public class AirportController {

    @Autowired
    private AirportService airportService;

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

    @GetMapping("/iatacode/{iataCode}")
    public ResponseEntity<Airport> findByIataCode(@PathVariable String iataCode) {
        Airport result = airportService.findByIataCode(iataCode);
        if (result == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(result);
        }
    }
    
    /**
 * Endpoint /airports/nearme
 * Retorna os aeroportos próximos à coordenada enviada como parâmetro
 * da requisição GET.
 *
 * @param latitude
 * @param longitude
 * @return
 */
@GetMapping("/nearme")
public ResponseEntity<List<AirportNearMeDTO>> findNearMe(
    @RequestParam double latitude,
    @RequestParam double longitude) {

    List<AirportNearMeDTO> result = airportService.findNearMe(latitude, longitude);

    if (result.isEmpty()) {
        // Ops... lista vazia...
        // notFound devolve 404
        return ResponseEntity.notFound().build();
    } else {
        // Eba! Tem dados!
        // ok devolve 200
        return ResponseEntity.ok(result);
    }
}

}
