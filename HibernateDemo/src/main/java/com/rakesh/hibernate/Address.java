package com.rakesh.hibernate;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String street;
    private String district;
    private String state;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", district='" + district + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
