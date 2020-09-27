/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author luoqi
 */
public class Person {
    
    private String name;
    private String address;
    private String birthday;
    private long telephoneNumber;
    private long FAXnumber;
    private String emailAddress;
    private String socialSecurityNumber;
    private String medicalRecordNumber;
    private String healthPlanNumber;
    private String bankAccountNumber;
    private String licenseNumber;
    private String vehicleIdentifierNumber;
    private String deviceNumber;
    private String linkedIn;
    private String internetProtocolAddress;
    private String biometricIdentifier;
    private Photo facePhoto;
    private String other;
    
    
    public Person(){
        facePhoto = new Photo();
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public long getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(long telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public long getFAXnumber() {
        return FAXnumber;
    }

    public void setFAXnumber(long FAXnumber) {
        this.FAXnumber = FAXnumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getMedicalRecordNumber() {
        return medicalRecordNumber;
    }

    public void setMedicalRecordNumber(String medicalRecordNumber) {
        this.medicalRecordNumber = medicalRecordNumber;
    }

    public String getHealthPlanNumber() {
        return healthPlanNumber;
    }

    public void setHealthPlanNumber(String healthPlanNumber) {
        this.healthPlanNumber = healthPlanNumber;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getVehicleIdentifierNumber() {
        return vehicleIdentifierNumber;
    }

    public void setVehicleIdentifierNumber(String vehicleIdentifierNumber) {
        this.vehicleIdentifierNumber = vehicleIdentifierNumber;
    }

    public String getDeviceNumber() {
        return deviceNumber;
    }

    public void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }

    public String getInternetProtocolAddress() {
        return internetProtocolAddress;
    }

    public void setInternetProtocolAddress(String internetProtocolAddress) {
        this.internetProtocolAddress = internetProtocolAddress;
    }

    public String getBiometricIdentifier() {
        return biometricIdentifier;
    }

    public void setBiometricIdentifier(String biometricIdentifier) {
        this.biometricIdentifier = biometricIdentifier;
    }

    public Photo getFacePhoto() {
        return facePhoto;
    }

    public void setFacePhoto(Photo facePhoto) {
        this.facePhoto = facePhoto;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
    
    
    
}
