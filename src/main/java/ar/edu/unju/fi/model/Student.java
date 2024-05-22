package ar.edu.unju.fi.model;

import java.time.LocalDate;

/** 
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
public class Student {
    private String identification;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private LocalDate birthdate;
    private String address;
    private String universityRecord;

    public Student() {
    }

    public Student(String identification,
                   String name,
                   String lastName,
                   String email,
                   String phone,
                   LocalDate birthdate,
                   String address,
                   String universityRecord) {
        this.identification = identification;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.birthdate = birthdate;
        this.address = address;
        this.universityRecord = universityRecord;
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
}
