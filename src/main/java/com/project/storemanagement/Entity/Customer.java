package com.project.storemanagement.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "customer_details")
public class Customer {
    //fields
    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int customer_id;
    @Column(name = "first_name")
    String firstName;
    @Column(name = "last_name")
    String lastName;
    @Column(name = "email_id")
    String  emailId;
    @Column(name = "phone_no")
    int phoneNo;

    public Customer(){}
    public  Customer( int customer_id ,String firstName,String lastName,String emailId,int phoneNo){
       this.customer_id =customer_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId =emailId;
        this.phoneNo = phoneNo;

    }

    public  int getCustomer_id(){
        return  customer_id;
    }

    public  void setCustomer_id(int customer_id){
        this.customer_id = customer_id;
    }

    public  String  getFirstName(){
        return  firstName;
    }

    public  void setFirstName(String firstName){
        this.firstName =firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customer_id=" + customer_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", phoneNo=" + phoneNo +
                '}';
    }
}
