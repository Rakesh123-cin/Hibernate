package com.rakesh.hibernate;

import jakarta.persistence.*;

@Entity
@Table(name="Student_Table")
public class Student {
    @Id
    @Column(name="RollNo")
    private int rollNo;
    @Column(name="Age")
    private int sAge;

    @Column(name="Name")
    private String sName;

    @Transient
    private String tech;

    @Column(name="Address")
    private Address address;

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public int getsAge() {
        return sAge;
    }

    public void setsAge(int sAge) {
        this.sAge = sAge;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", sAge=" + sAge +
                ", sName='" + sName + '\'' +
                ", tech='" + tech + '\'' +
                ", address=" + address +
                '}';
    }
}
