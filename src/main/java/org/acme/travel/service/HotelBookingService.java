package org.acme.travel.service;

import javax.enterprise.context.ApplicationScoped;

import org.acme.travel.Address;
import org.acme.travel.Hotel;
import org.acme.travel.Trip;

/**
 * HotelBookingService
 */
@ApplicationScoped
public class HotelBookingService {

    public Hotel bookHotel(Trip trip) {
        return new Hotel("Perfect hotel", new Address("street", trip.getCity(), "12345", trip.getCountry()), "09876543", "XX-012345");
    }
}