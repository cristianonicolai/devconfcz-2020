package org.acme.travel.service;

import java.util.Date;

import javax.enterprise.context.ApplicationScoped;

import org.acme.travel.Flight;
import org.acme.travel.Trip;

/**
 * FlightBookingService
 */
@ApplicationScoped
public class FlightBookingService {

    public Flight bookFlight(Trip trip) {
        return new Flight("MX555", "1A", "16A", new Date(), new Date());
    }
}