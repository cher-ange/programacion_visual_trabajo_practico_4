package ar.edu.unju.fi.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

/**
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
@Component
public class Student {
    private String identification;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthdate;
    private String address;
    private String universityRecord;
    private Boolean state = true;

    public Student() {
    }

    public Student(
            String identification,
            String name,
            String lastName,
            String email,
            String phone,
            LocalDate birthdate,
            String address,
            String universityRecord,
            Boolean state) {

        this.identification = identification;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.birthdate = birthdate;
        this.address = address;
        this.universityRecord = universityRecord;
        this.state = state;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUniversityRecord() {
        return universityRecord;
    }

    public void setUniversityRecord(String universityRecord) {
        this.universityRecord = universityRecord;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Student [identification=" + identification + ", name=" + name + ", lastName=" + lastName + ", email="
                + email + ", phone=" + phone + ", birthdate=" + birthdate + ", address=" + address
                + ", universityRecord=" + universityRecord + ", state=" + state + "]";
    }
}
