package com.example.vivekgandhi.tfi;

/**
 * Created by Vivek Gandhi on 4/18/2017.
 */

public class Opportunity {

public String mail,title,description,city,address,pincode,st,end,hours;
    // Default constructor required for calls to
    // DataSnapshot.getValue(Opportunity.class)
    public Opportunity(){}
    public Opportunity(String mail, String title, String description, String city, String address, String pincode, String st, String end, String hours) {
        this.mail = mail;
        this.title = title;
        this.description = description;
        this.city = city;
        this.address = address;
        this.pincode = pincode;
        this.st = st;
        this.end = end;
        this.hours = hours;
    }

    public Opportunity(String title, String mail )
    { this.title = title;
        this.mail = mail;

    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getSt() {
        return st;
    }

    public void setSt(String st) {
        this.st = st;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }
}
