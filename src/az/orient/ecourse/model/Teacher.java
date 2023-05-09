package az.orient.ecourse.model;

import java.util.Date;

public class Teacher extends Course {
    private String name;
    private String surname;
    private Date dob;
    private String address;
    private String phone;
    private String pin;
    private int workExperience;
    
    public Teacher(){
        
    }
    public Teacher(Long id,String name,String surname){
        super.setId(id);
        this.name = name;
        this.surname = surname;
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }

    @Override
    public String toString() {
        return name+" "+surname;
    }
}
