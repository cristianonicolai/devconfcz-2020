package org.acme.travel;

/**
 * Hotel
 */
public class Hotel {

    private String name;
    private Address address;
    private String phone;
    private String bookingNumber;
    private String room;

    public Hotel() {
        super();
    }

    public Hotel(String name, Address address, String phone, String bookingNumber) {
        super();
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.bookingNumber = bookingNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(String bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Hotel [address=" + address + ", bookingNumber=" + bookingNumber + ", name=" + name + ", phone=" + phone
                + ", room=" + room + "]";
    }



}