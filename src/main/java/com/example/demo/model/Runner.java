package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.extern.slf4j.Slf4j;


@Entity
public class Runner {
    @Id
    private int id;
    private String name;
    private String address;
    private String postalCode;
    private String city;
    private String country;
    private String email;
    private String phoneNumber;
    private double registrationFee;

    public Runner(String name, String address, String postalCode, String city, String country, String email, String phoneNumber, Double registrationFee) {
        this.name = name;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.registrationFee = registrationFee;
    }

    public Runner() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getRegistrationFee() {
        return registrationFee;
    }

    public void setRegistrationFee(double registrationFee) {
        this.registrationFee = registrationFee;
    }

    @Override
    public String toString() {
        return "Runner{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", registrationFee='" + registrationFee + '\'' +
                '}';
    }
}
