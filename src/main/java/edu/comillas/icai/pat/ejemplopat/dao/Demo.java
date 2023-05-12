package edu.comillas.icai.pat.ejemplopat.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("DEMO")
public class Demo {
    private @Column("ID") @Id
    Integer DemoID;
    private @Column("KEY_NAME")
    String key;
    private @Column("FIRST_NAME")
    String Name;
    private @Column("LAST_NAME")
    String Surmame;
    private @Column("EMAIL")
    String email;
    
    public Integer getDemoID() {
        return DemoID;
    }
    public String getKey() {
        return key;
    }
    public String getName() {
        return Name;
    }
    public String getSurmame() {
        return Surmame;
    }
    public String getEmail() {
        return email;
    }

    public void setDemoID(Integer demoID) {
        DemoID = demoID;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public void setName(String name) {
        Name = name;
    }
    public void setSurmame(String surmame) {
        Surmame = surmame;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Demo(Integer id, String key, String name, String surmame, String email) {
        this.DemoID = id;
        this.key = key;
        Name = name;
        Surmame = surmame;
        this.email = email;
    }
    public Demo() {
        this.DemoID =0;
        this.key = "";
        Name = "";
        Surmame = "";
        this.email = "";
    }





    

    
    
}
