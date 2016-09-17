package com.lunasol.eamservice;

/**
 * Created by chris on 9/7/2016.
 */
public class DataBinder {
    private Customer mCustomer;
    private IVehicle mAutomobile;

    public DataBinder() {
        mCustomer = new Customer();
        mAutomobile = new Automobile();
    }

    public DataBinder(Customer customer, IVehicle vehicle) {
        this.mAutomobile = vehicle;
        this.mCustomer = customer;
    }

    public DataBinder(Customer customer) {
        if(customer.getVehicle() == null) {
            customer.setVehicle(new Automobile());
        }
        this.mCustomer = customer;
        this.mAutomobile = customer.getVehicle();
    }

    public void SaveCustomer(Customer customer) {
        mCustomer.setFirstName(customer.getFirstName());
        mCustomer.setLastName(customer.getLastName());
        mCustomer.setAddress(customer.getAddress());
        mCustomer.setAge(customer.getAge());
        mCustomer.setEmail(customer.getEmail());
        mCustomer.setPhone(customer.getPhone());
        mCustomer.setVehicle(customer.getVehicle());
    }

    public void setCustomer(Customer customer) {
        mCustomer = customer;
    }

    public void setVehicle(IVehicle vehicle) {
        mAutomobile = vehicle;
    }

    public Customer getCustomer() {
        return this.mCustomer;
    }

    public  IVehicle getIVehicle() {
        return this.mAutomobile;
    }

    public interface DataBinderListener {
        void setDataBinder(DataBinder db);
    }
}
