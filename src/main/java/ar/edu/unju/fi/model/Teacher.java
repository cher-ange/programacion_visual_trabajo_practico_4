package ar.edu.unju.fi.model;

/** 
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
public class Teacher {
    private String file;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    
    public Teacher() {
    }

    public Teacher(String file,
                   String name,
                   String lastName,
                   String email,
                   String phone) {
        this.file = file;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
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
}
