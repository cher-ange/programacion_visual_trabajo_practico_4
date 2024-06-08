package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

/**
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
@Component
public class Teacher {

    private String file;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private Boolean state = true;

    public Teacher() {
    }

    public Teacher(
            String file,
            String name,
            String lastName,
            String email,
            String phone,
            Boolean state) {
        this.file = file;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.state = state;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
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

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Teacher [file=" + file + ", name=" + name + ", lastName=" + lastName + ", email=" + email + ", phone="
                + phone + ", state=" + state + "]";
    }
}
