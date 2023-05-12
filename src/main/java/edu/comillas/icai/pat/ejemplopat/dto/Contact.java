package edu.comillas.icai.pat.ejemplopat.dto;


public class Contact {
    
    private String name;
    private String lastname;
    private String email;
        
    public Contact(String name, String lastname, String email) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public String getLastname() {
        return lastname;
    }
    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "Contact [name=" + name + ", lastname=" + lastname + ", email=" + email + "]";
    }


    
}
