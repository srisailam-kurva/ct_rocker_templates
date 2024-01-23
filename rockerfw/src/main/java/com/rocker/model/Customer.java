package com.rocker.model;

import lombok.ToString;

@ToString
public class Customer {
    private String title;
    private String firstName;
    private String middleName;
    private String lastName;
    private String lastName2;
    private int customerId;

    public Customer(String title, String firstName, String middleName, String lastName, String lastName2, int customerId, String accountID, String externalAccountID, String idNumber, String houseNo, String houseExtension, String pobox, String address, String area, String city, String state, String zipCode, String country, String emailId, String preferredLanguage) {
        this.title = title;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.lastName2 = "";
        this.customerId = customerId;
        this.accountID = accountID;
        this.externalAccountID = externalAccountID;
        this.idNumber = idNumber;
        this.houseNo = houseNo;
        this.houseExtension = houseExtension;
        this.pobox = pobox;
        this.address = address;
        this.area = area;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
        this.emailId = emailId;
        this.preferredLanguage = preferredLanguage;
    }

    private String accountID;
    private String externalAccountID;
    private String idNumber;
    private String houseNo;
    private String houseExtension;
    private String pobox;
    private String address;
    private String area;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    private String emailId;
    private String preferredLanguage;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName2() {
        return lastName2;
    }

    public void setLastName2(String lastName2) {
        this.lastName2 = lastName2;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getExternalAccountID() {
        return externalAccountID;
    }

    public void setExternalAccountID(String externalAccountID) {
        this.externalAccountID = externalAccountID;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPobox() {
        return pobox;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getHouseExtension() {
        return houseExtension;
    }

    public void setHouseExtension(String houseExtension) {
        this.houseExtension = houseExtension;
    }

    public String gePobox() {
        return pobox;
    }

    public void setPobox(String pobox) {
        this.pobox = pobox;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPreferredLanguage() {
        return preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
    }

    public String getDoorInfo() {
        String doorInfo = "";
        if(houseNo != null && !houseNo.isEmpty()) {
            doorInfo = doorInfo.concat(houseNo).concat(" ");
        }
        if(houseExtension != null && !houseExtension.isEmpty()) {
            doorInfo = doorInfo.concat(houseExtension);
        }

        return doorInfo;
    }
}
