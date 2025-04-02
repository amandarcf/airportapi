/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.eti.amanda.airports.service;

import br.eti.amanda.airports.DTO.AirportMinDTO;
import br.eti.amanda.airports.DTO.AirportNearMeDTO;
import br.eti.amanda.airports.entities.Airport;
import br.eti.amanda.airports.projections.AirportNearMeProjection;
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
    public List<Airport> findByCity(String city){
        List<Airport> result = airportRepository.findByCityIgnoreCase(city);
        return result;
}
    /**
 * Retorna DTO AirportsMinDTO filtrado por country (país).
 * 
 * @param country
 * @return
 */
public List<AirportMinDTO> findByCountry(String country) {
    List<Airport> resultAirport = airportRepository.findByCountryIgnoreCase(country);

    List<AirportMinDTO> resultDTO = resultAirport.stream()
        .map(x -> new AirportMinDTO(x)).toList();

    return resultDTO;
}
public Airport findByIataCode(String iataCode) {
    Airport result = airportRepository.findByIataCode(iataCode);
    return result;
}
/**
 * Retorna DTO AirportNearMe
 *
 * @param latitude
 * @param longitude
 * @return
 */
public List<AirportNearMeDTO> findNearMe(double latitude, double longitude) {
    List<AirportNearMeProjection> resultNearAirports = airportRepository.findNearMe(latitude, longitude);

    List<AirportNearMeDTO> resultDTO = resultNearAirports.stream()
        .map(x -> new AirportNearMeDTO(x))
        .toList();

    return resultDTO;
}

}
