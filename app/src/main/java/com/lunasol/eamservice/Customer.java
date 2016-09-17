package com.lunasol.eamservice;

/**
 * Created by chris on 8/9/2016.
 */
public class Customer {


    private String firstName;
    private String lastName;
    private String address;
    private int age;
    private String email;
    private String phone;
    private IVehicle vehicle;

    public Customer(String firstName, String lastName, String mAddress, int mAge, String mEmail, String mPhone, IVehicle mVehicle) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = mAddress;
        this.age = mAge;
        this.email = mEmail;
        this.phone = mPhone;
        this.vehicle = mVehicle;
    }

    public Customer() {
        this.firstName = "Jane";
        this.lastName = "Doe";
        this.address = "123 Example St";
        this.age = 30;
        this.email = "example@email.com";
        this.phone = "123456789";
        this.vehicle = null;
    }

    public void setAddress(String mAddress) {
        this.address = mAddress;
    }


    public void setAge(int mAge) {
        this.age = mAge;
    }

    public void setEmail(String mEmail) {
        this.email = mEmail;
    }

    public void setPhone(String mPhone) {
        this.phone = mPhone;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {

        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }


    public String getAddress() {
        return this.address;
    }

    public int getAge() {
        return this.age;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhone() {
        return this.phone;
    }

    public IVehicle getVehicle() {
        return this.vehicle;
    }

    public void setVehicle(IVehicle vehicle) {
        this.vehicle = vehicle;
    }

}
